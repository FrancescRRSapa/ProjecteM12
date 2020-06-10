<%-- 
    Document   : reservarHora
    Created on : 10 jun. 2020, 22:56:15
    Author     : Francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/calendari.css">
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
                    <a href="indexUser.jsp"><h5>Principal</h5></a>
            <%
               HttpSession sesion = request.getSession();
               String usuario;
               String tipusUsuari;

               if(sesion.getAttribute("user")!= null && sesion.getAttribute("tipusUsuari")!= null){
                   usuario = sesion.getAttribute("user").toString();
                   tipusUsuari = sesion.getAttribute("tipusUsuari").toString();
                   out.print("<a href='index.jsp?cerrar=true'><h5>Tancar sessió de " + usuario +"</h5></a> ");            
               }else{
                   out.print("<script>location.replace('index.jsp');</script>");
                   }
            %>
                </nav>
            </div> 
        </header>
    </body>
</html>
