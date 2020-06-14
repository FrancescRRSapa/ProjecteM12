<%-- 
    Document   : certificacions
    Created on : 22 may. 2020, 18:10:37
    Author     : Francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pàgina certificacions</title>
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
                    Certificacions
                </div>
                <nav>
                    <a href="indexAdmin.jsp">Principal</a>
                    <a href="#">Certificacio MOS</a>
                    <a href="#">Certificacio MTA</a>
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
        <h1>Afegir certificació</h1>       
        <form id="formulari" action="SrvCertificacions" method="POST">
            <label for="idCertificacio">Id de la certificació</label>
            <br>
            <input type="text" name="idCertificacio" id="idCertificacio" placeholder="idCert"></input>
            <br><br>
            <label for="nom">Nom de la certificació</label>
            <br>
            <input type="text" name="nom" id="nom" placeholder="Nom"></input>
            <br><br>
            <label for="descripcio">Descripció de la certificació</label>
            <br>
            <input type="text" name="descripcio" id="descripcio" placeholder="Descripcio"></input>
            <br><br>
            <label for="dataPublicacio">Data de publicació de la certificació</label>
            <br>
            <input type="date" name="dataPublicacio" id="dataPublicacio"></input>
            <br><br>
            <label for="nivellAlumneRecomanat">Nivell d'alumne recomanat</label>
            <br>
            <input type="text" name="nivellAlumneRecomanat" id="nivellAlumneRecomanat"></input>
            <br><br>
            <input type='submit'></input>
        </form>
        <footer id="footer">
            Sergio Fernández i Francesc Roca - 2n DAW 2019/2020
        </footer>
    </body>
</html>
