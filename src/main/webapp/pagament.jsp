<%-- 
    Document   : pagament
    Created on : 24 may. 2020, 16:19:33
    Author     : Francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin. pagament</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Pagament
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
        <details>
            <summary>Configuració de Grup partit</summary>
            <fieldset id="afegirgruppartit">
                <form id="formulari" action="SrvGrupPartit" method="POST">
                    <label for="nom">Nom de grup partit</label>
                    <br>
                    <input type="text" name="nom" id="nom"></input>
                    <br><br>
                    <label for="nom">Data d'alta</label>
                    <br>
                    <input type="date" name="dataAlta" id="dataAlta"></input>
                    <br><br>
                    <label for="dataBaixa">Data de baixa</label>
                    <br>
                    <input type="date" name="dataBaixa" id="dataBaixa"></input>
                    <br><br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
            <br>
            <fieldset id="borrargruppartit">
                <form id="formulari" action="SrvBorrarGrupPartit" method="POST">
                    <label for="correu">Esborra un grup partit:</label>
                    <br>
                    <select name="gruppartit" id="data">
                       <%
                           char prova[] = {'a','b','c','d','e'};
                           for(int i = 0; i < prova.length; i++){
                               out.print("<option value='prova'"+ prova[i] +">"+ prova[i] +"</option>");
                           }
                       %>
                    </select>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        </details>
        <details>
            <summary>Crear nova tarifa</summary>
            <fieldset id="tarifa">
                <form id="formulari" action="SrvTarifes" method="POST">
                    <!-- L'id serà autoincremental a la base de dades? -->
                    <label for="idTarifa">Id de la tarifa</label>
                    <br>
                    <input type="number" name="idTarifa" id="idTarifa"></input>
                    <br><br>
                    <label for="nom">Nom de la tarifa</label>
                    <br>
                    <input type="text" name="nom" id="nom" placeholder="Nom"></input>
                    <br><br>
                    <label for="preu">Preu de la tarifa</label>
                    <br>
                    <input type="number" name="preu" id="preu"></input>
                    <br><br>
                    <!-- Què fem amb l'objecte concepte i l'objecte gruppartit??? -->
                    <!-- Aquí anirien els inputs de concepte i grup partit -->
                    <!-- Concepte -->
                    <!-- GrupPartit -->
                    <label for="grupAlumne">Grup alumne</label>
                    <br>
                    <input type="text" name="grupAlumne" id="grupAlumne"></input>
                    <br><br>
                    <label for="dataAlta">Data d'alta</label>
                    <br>
                    <input type="date" name="dataAlta" id="dataAlta"></input>
                    <br><br>
                    <label for="dataBaixa">Data de baixa</label>
                    <br>
                    <input type="date" name="dataBaixa" id="dataBaixa"></input>
                    <br><br>
                    <input type='submit'></input>
                </form>
            </fieldset>
        </details>
        <details>
            <summary>Esborrar una tarifa</summary>
            <form action="SrvBorrarTarifa" method0="POST">
                <label for='esborrarTarifa'>Escriu l'id de la tarifa a esborrar</label>
                <br>
                <input type='number' name="idTarifa" id="idTarifa"></input>
                <br><br>
                <input type="submit">
            </form>
        </details>
        <details>
            <summary>Configuració de Concepte</summary>
            <fieldset id="afegirconcepte">
                <form id="formulari" action="SrvAfegirConcepte" method="POST">
                    <label for="nom">Nom de grup partit</label>
                    <br>
                    <input type="text" name="nom" id="nom"></input>
                    <br><br>
                    <label for="nom">Data d'alta</label>
                    <br>
                    <input type="date" name="dataAlta" id="dataAlta"></input>
                    <br><br>
                    <label for="dataBaixa">Data de baixa</label>
                    <br>
                    <input type="date" name="dataBaixa" id="dataBaixa"></input>
                    <br><br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        </details>
    </body>
</html>
