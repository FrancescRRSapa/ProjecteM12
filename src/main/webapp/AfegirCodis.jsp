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
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Afegir nous codis a la base de dades</h1>
            <a href="indexAdmin.jsp">Index</a>
            <form method="post" action="llegirCSVServlet" enctype="multipart/form-data">
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
