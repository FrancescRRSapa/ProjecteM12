<%-- 
    Document   : configuracio
    Created on : 20 may. 2020, 18:02:47
    Author     : Francesc
--%>

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
        <details>
            <summary>Configuració de correu</summary>
            <fieldset id="configMail">
                <form id="formulari" action="SrvMail" method="POST">
                    <label for="correu">Modifica el correu:</label>
                    <br>
                    <textarea rows="4" cols="50" name="correu" form="formulari"></textarea>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        </details>
        
        <br>
        <!-- L'única cosa que em preocupa és que no poguem realitzaar les crides o rebre les dates correctament -->
        <details>
            <summary>Configuració de dates</summary>
            <fieldset id="esborrarCodi">
                <form id="formulari" action="SrvEsborrarCodis" method="POST">
                    <label for="dates">Escull una data</label>
                     <select name="data" id="data">
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
            </fieldset>
        </details>
        <details>
            <summary>Configuració de dates</summary>
            <fieldset id="novaCertificacio">
                <form id="formulari" action="SrvCertificacions" method="POST">
                  <label for="correu">Afegir una nova certificació:</label>
                    <br>
                    <input type='text' name="certificacio" id='certificacio' placeholder="Nova Certificació"></input>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        </details>
    </body>
</html>
