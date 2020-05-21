<%-- 
    Document   : configDates
    Author     : Francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Config Dates</title>
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
                    <a href="configuracio.jsp">Configuracio</a>
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
        <form id="formulari" action="SrvEsborrarCodis" method="POST">
           <label for="dates">Escull una data</label>
            <select name="data" id="data">
              <option value="volvo">Volvo</option>
              <%
                  char prova[] = {'a','b','c','d','e'};
                  for(int i = 0; i < prova.length; i++){
                      out.print("<option value='prova'"+ prova[i] +">"+ prova[i] +"</option>");
                  }
              %>
            </select>
            <br><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
