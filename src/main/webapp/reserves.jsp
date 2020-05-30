<%-- 
    Document   : reserves
    Created on : 23 may. 2020, 16:09:35
    Author     : Francesc
--%>

<%@page import="Model.LlistaReserves"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Reserves</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Reserves
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
        <div>
            <h1>Reserves a validar</h1>
            <!-- Mostrar una taula amb totes les peticions de reserves i fer que es puguin clicar, al 
            clicar redirigir a un altre pàgina on es pugui donar a Validar i així acceptar-la
            Que sigui algo semblant a l'examen de l'UF2 de M7.
            Comentar amb Sergio.-->
            <table>
            <% 
                LlistaReserves lc = (LlistaReserves) request.getAttribute("llistaReserves");
                for(int i = 0; i < lc.size(); i++){
                    out.print("<tr>");
                    out.print("<td>" + lc.get(i).getIdReserva() + "</td><td>" + lc.get(i).getIdUsuari() + "</td><td>"  + lc.get(i).getIdHoraExamen() + "</td>");
                    out.print("</tr>");
                }
            %>
        </table>
        </div>
    </body>
</html>
