<%-- 
    Document   : LlistarCodisJSP
    Created on : 11 may. 2020, 17:41:42
    Author     : Francesc
--%>
<%@ page import="java.util.*" %> 
<%@ page import="com.mycompany.llegircsv.Codi" %>
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
ArrayList<Codi> codis = new ArrayList<>();
codis =(ArrayList<Codi>) request.getAttribute("codis");
for(int i=0;i< codis.size();i++) {
%>
	<tr>
        <td>HOLA</td>
	<td><%out.print((String) codis.get(i).getUsuari());%></td>
	<td><%out.print((String) codis.get(i).getPassword());%></td>
	<td><%out.print((String) codis.get(i).getPracticeTest());%></td>
	</tr>
<%
}
%>
<%out.print(codis.size());%>
</table>
</html>
