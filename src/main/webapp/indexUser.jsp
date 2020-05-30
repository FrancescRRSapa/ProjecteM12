<%-- 
    Document   : indexUser
    Created on : 10 may. 2020, 17:24:16
    Author     : ferna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proctor</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Institut Sa Palomera
                </div>
                <nav>
            <%
               HttpSession sesion = request.getSession();
               String usuario;
               String tipusUsuari;

               if(sesion.getAttribute("user")!= null && sesion.getAttribute("tipusUsuari")!= null){
                   usuario = sesion.getAttribute("user").toString();
                   tipusUsuari = sesion.getAttribute("tipusUsuari").toString();
                   out.print("<a href='login.jsp?cerrar=true'><h5>Tancar sessió de " + usuario +"</h5></a> ");            
               }else{
                   out.print("<script>location.replace('login.jsp');</script>");
                   }
            %>
                </nav>
            </div> 
        </header>
        <!-- Posar aquí el calendari de quan es pot demanar hora per realitzar l'examen -->
        <h2>Calendari de dates disponibles per examens</h2>
    </body>
</html>
