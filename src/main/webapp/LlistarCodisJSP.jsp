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
        <h1>Hello World!</h1>
    </body>
<table width="100%" border="1" cellpadding="0" cellspacing="2" style="border-collapse:separate;border-spacing:2px;border-color:#ddd;">
<%
ArrayList<CodiMTA> preTestMOS =(ArrayList<CodiMTA>) request.getAttribute("PreTestMTA");
//ArrayList<CodiPreTestMTA> preTestMTA =(ArrayList<CodiPreTestMTA>) request.getAttribute("PreTestMTA");
//ArrayList<CodiTestMOS> testMOS =(ArrayList<CodiTestMOS>) request.getAttribute("TestMOS");
out.print("PreTestMOS");
if(preTestMOS != null){
    for(int i=0;i< preTestMOS.size();i++) {
%>
	<tr>
        <td>HOLA</td>
	<td><%out.print((String) preTestMOS.get(i).getUsuari());%></td>
	<td><%out.print((String) preTestMOS.get(i).getPassword());%></td>
	<td><%out.print((String) preTestMOS.get(i).getPracticeTest());%></td>
	</tr>
<%
    }
}
%>
<div><form method="post" action="llegirCSVServlet" enctype="multipart/form-data">
    CSV File:<input type="file" name="fileMOS" id="fileMOS">
    <br>
    <label for="tipusCodi">Tipus de codis a inserir:</label>
    <select name="tipusCodi">
        <option name="MOS" value="MOS">Codis MOS</option>
        <option name="MTA" value="MTA">Codis MTA</option>
    </select>
    
    <input type="submit" value="Enviar" name="Enviar">
    </form></div>
</table>
</html>
