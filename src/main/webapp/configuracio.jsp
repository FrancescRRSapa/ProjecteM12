<%-- 
    Document   : configuracio
    Created on : 20 may. 2020, 18:02:47
    Author     : Francesc
--%>

<%@page import="Model.Configuracio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuració</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Configuració
                </div>
                <nav>
                    <a href="indexAdmin.jsp">Principal</a>
                    <!-- <a href="configMail.jsp">Config. Mail</a>
                    <a href="configDates.jsp">Config. Dates</a> -->
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
        <h1>Benvingut/da a la configuració</h1>
            <summary>Configuració de correu</summary>
            <fieldset id="configuracio">
                <form id="formulari" action="SrvUpdateConfiguracio" method="POST">
                    <label for="codisMin">Número mínim de codis</label>
                    <br>
                    <%
                        Configuracio c = (Configuracio) request.getAttribute("configuracio");
                    %>
                    
                    <div><%=c.getCodisMin()%></div>
                    <input type="number" name="codisMin" value="">
                    <br>
                    <label for="correuEnviaCodis">Modifica el correu per enviar codis:</label>
                    <br>
                    <textarea rows="4" cols="50" name="correuEnviaCodis" form="formulari"></textarea>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        
    </body>
</html>
