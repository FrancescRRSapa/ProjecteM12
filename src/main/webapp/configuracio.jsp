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
        <link rel="icon" href="img/logoSapa.png">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
        <script src="js/formularis.js"></script>
        <!-- Links per editor de textarea -->
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script>tinymce.init({selector:'textarea'});</script>
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
        <% Configuracio c = (Configuracio) request.getAttribute("configuracio");%>
            <summary>Configuració de correu</summary>
            <fieldset id="configuracio">
                <form id="formulari" action="SrvConfiguracio" method="POST" onsubmit="return formulariConfiguracio()">
                    <!-- CODIS MINIM -->
                    <div>
                        <label for="codisMin">Número mínim de codis</label>
                        <br>
                        <input type="number" name="codisMin" id="codisMin" value="<%=c.getCodisMin()%>">
                    </div>
                    <!-- ALUMNES PER AULA -->
                    <div>
                        <label for="alumnesAula">Número màxim d'alumnes a l'aula</label>
                        <br>
                        <input type="number" name="alumnesAula" id="alumnesAula" value="<%=c.getAlumnesAula()%>">
                    </div>
                    <!-- DIRECCIO CORREU -->
                    <div>
                        <label for="direccioCorreu">Direcció de correu</label>
                        <br>
                        <input type="email" name="direccioCorreu" id="direccioCorreu" value="<%=c.getDireccioCorreu()%>">
                    </div>
                    <!-- Contrasenya Correu -->
                    <div>
                        <label for="contrasenyaCorreu">Contrassenya del correu</label>
                        <br>
                        <input type="password" name="contrasenyaCorreu" id="contrasenyaCorreu" value="<%=c.getContrasenyaCorreu()%>">
                        <input type="checkbox" onclick="myFunction()">Veure contrassenya
                        <script>
                            function myFunction() {
                              var x = document.getElementById("contrasenyaCorreu");
                              if (x.type === "password") {
                                x.type = "text";
                              } else {
                                x.type = "password";
                              }
                            }
                        </script>
                    </div>
                    <!-- Correu Envia Codis -->
                    <div>
                        <label for="correuEnviaCodis">Correu per enviar codis</label>
                        <br>
                        <textarea name="correuEnviaCodis" id="correuEnviaCodis" form="formulari" rows="10" cols="50"><%=c.getCorreuEnviaCodis()%></textarea>
                    </div>
                    <!-- Correu Envia Alerta Codis -->
                    <div>
                        <label for="correuEnviaAlertaCodis">Correu per enviar alerta de pocs codis</label>
                        <br>
                        <textarea name="correuEnviaAlertaCodis" id="correuEnviaAlertaCodis" form="formulari" rows="10" cols="50"><%=c.getCorreuEnviaAlertaCodis()%></textarea>
                    </div>
                    <div>
                        <label for="submit">Enviar canvis!</label>
                        <br>
                        <input type="submit">
                    </div>
                </form>
            </fieldset>
            <footer id="footer">
                Sergio Fernández i Francesc Roca - 2n DAW 2019/2020
            </footer>
    </body>
</html>
