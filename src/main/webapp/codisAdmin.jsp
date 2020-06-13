<%-- 
    Document   : codisAdmin
    Created on : 20 may. 2020, 16:35:04
    Author     : Francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Admins</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Administració de codis
                </div>
                <nav>
                    <a href="indexAdmin.jsp">Principal</a>
        <%
            HttpSession sesion = request.getSession();
            String usuario;
            String tipusUsuari;
            
            if(sesion.getAttribute("user")!= null && sesion.getAttribute("tipusUsuari")!= null){
                usuario = sesion.getAttribute("user").toString();
                tipusUsuari = sesion.getAttribute("tipusUsuari").toString();
                out.print("<a href='index.jsp?cerrar=true'><h5>Tancar sessió de " + usuario +"</h5></a> ");
                if(tipusUsuari != "administrador"){
                    response.sendRedirect("index.jsp?cerrar=true");
                }
            }else{
                out.print("<script>location.replace('index.jsp');</script>");
                }
            %>
                </nav>
            </div> 
        </header>
        <h1>Afegir nous codis a la base de dades</h1>
        <form method="post" action="SrvLlegirCSV" enctype="multipart/form-data">
            CSV File:<input type="file" name="file" id="file">
            <br>
            <label for="tipusCodi">Tipus de codis a inserir:</label>
            <br>
            <select name="tipusCodi">
                <option name="MOS" value="MOS">Codis MOS</option>
                <option name="MTA" value="MTA">Codis MTA</option>
            </select>
            <br>
            <input type="submit" value="Enviar" name="Enviar">
            </form>
            <footer id="footer">
                Sergio Fernández i Francesc Roca - 2n DAW 2019/2020
            </footer>
    </body>
</html>

