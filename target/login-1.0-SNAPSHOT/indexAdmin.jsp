<%-- 
    Document   : indexMain
    Created on : 10 may. 2020, 17:23:30
    Author     : ferna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administració</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="icon" href="img/logoSapa.png">
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
                    <a href="codisAdmin.jsp">Admin. codis</a>
                    <a href="certificacions.jsp">Certificacions</a>                                 
                    <a href="SrvLlistarReserva">Reserves</a>
                    <a href="pagament.jsp">Pagament</a>
                    <a href="SrvConfiguracio">Configuracio</a>
        <%
            HttpSession sesion = request.getSession();
            String usuario = "";
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
                    <p>
                        Benvingut administrador/a <% out.print(usuario); %><br>
                        Utilitza el menú de la part superior de la pàgina per entrar a les diferents pàgines de configuració del lloc.
                    </p>
                </div>
                        <footer id="footer">
                            Sergio Fernández i Francesc Roca - 2n DAW 2019/2020
                        </footer>
    </body>
</html>
