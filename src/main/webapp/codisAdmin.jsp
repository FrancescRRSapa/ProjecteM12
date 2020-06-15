<%-- 
    Document   : codisAdmin
    Created on : 20 may. 2020, 16:35:04
    Author     : Francesc
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Admins</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="icon" href="img/logoSapa.png">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/formularis.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
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
        <details>
            <summary>Afegir nous codis a la base de dades</summary>
            <fieldset>
                <form method="post" action="SrvLlegirCSV" enctype="multipart/form-data">
                    CSV File:<input type="file" name="file" id="file">
                    <br>
                    <label for="tipusCodi">Tipus de codis a inserir:</label>
                    <select name="tipusCodi">
                        <option name="MOS" value="MOS">Codis MOS</option>
                        <option name="MTA" value="MTA">Codis MTA</option>
                    </select>
                    <br>
                    <input type="submit" value="Enviar" name="Enviar">
                </form>
            </fieldset>
        </details>
        <details>
            <summary>Esborrar codis</summary>
            <%
                ArrayList<Timestamp> llistaDatesMTA = (ArrayList<Timestamp>)request.getAttribute("llistaDatesMTA");
                ArrayList<Timestamp> llistaDatesMOS = (ArrayList<Timestamp>)request.getAttribute("llistaDatesMOS");
            %>
            <fieldset>
                <script>
                function actualitza(){
                    var x = document.getElementById("tipus").value;
                    if(x == 'mta'){
                        document.getElementById("seleccioData").innerHTML = ""
                        <%for(int i=0; i < llistaDatesMTA.size(); i++){ %>
                           + "<option value='<%=llistaDatesMTA.get(i) %>'><%=llistaDatesMTA.get(i) %></option>"
                        <% } %>;
                    }else if(x == 'mos'){
                        document.getElementById("seleccioData").innerHTML = ""
                        <%for(int i=0; i < llistaDatesMOS.size(); i++){ %>
                            + "<option value='<%=llistaDatesMOS.get(i) %>'><%=llistaDatesMOS.get(i) %></option>"
                        <% } %>;
                    }
                }
                </script>
                <form action="SrvEsborrarCodis" method="POST" onsubmit="return confirm('Estas segur que vols eliminar els codis? No és poden recuperar')">
                    <div>
                        <select name='tipus' id='tipus' onchange="actualitza()">
                            <option value="mta">Codis MTA</option>
                            <option value="mos">Codis MOS</option>
                        </select>
                    </div>
                    <div>
                        <select name='seleccioData' id='seleccioData'>
                            <%for(int i=0; i < llistaDatesMTA.size(); i++){ %>
                                <option value="<%=llistaDatesMTA.get(i) %>"><%=llistaDatesMTA.get(i) %></option>
                            <% } %>
                        </select>
                    </div>
                        <div><button>Esborrar</button></div>
                </form>
            </fieldset>
        </details>
        <details>
            <summary>Enviar codi a usuari</summary>
            <fieldset>
                <% String error = (String)request.getAttribute("error"); %>
                <form action="SrvEnviarCodi" method="POST" onsubmit="return validarCorreuCodisAdmin()">
                    <label for="correu">Correu Usuari</label>
                    <input type="email" name="direccioCorreu" id="direccioCorreu" placeholder="elseu@correu.com"><br>
                    <label for="certificacio">Quina certificació vols escollir?</label>
                    <select name="certificacio" id="certificacio">
                        <option value="MOS">MOS</option>
                        <option value="MTA">MTA</option>
                    </select><br>
                    <% 
                    if(error != null){
                        %>
                        <div><%=error %></div>
                        <%
                    }
                    %>
                    <input type='submit'>
                </form>
            </fieldset>
        </details>
            <footer id="footer">
                Sergio Fernández i Francesc Roca - 2n DAW 2019/2020
            </footer>
    </body>
</html>

