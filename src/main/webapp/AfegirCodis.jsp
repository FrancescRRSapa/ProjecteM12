<%-- 
    Document   : LlistarCodisJSP
    Created on : 11 may. 2020, 17:41:42
    Author     : Francesc
--%>

<%@page import="Model.CodiMTA"%>
<%@page import="Model.CodiMOS"%>
<%@ page import="java.util.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Afegir Codis</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Afegir codis
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
            <h1>Afegir nous codis a la base de dades</h1>
            <a href="indexAdmin.jsp">Index</a>
            <form method="post" action="SrvLlegirCSV" enctype="multipart/form-data">
            CSV File:<input type="file" name="fileMOS" id="fileMOS">
            <br>
            <label for="tipusCodi">Tipus de codis a inserir:</label>
            <br>
            <select name="tipusCodi">
                <option name="MOS" value="MOS">Codis MOS</option>
                <option name="MTA" value="MTA">Codis MTA</option>
            </select>
            <br>
            <input type="submit" value="Enviar" name="Enviar">
            </form>
        </div>
    </body>
</html>
