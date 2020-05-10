<%-- 
    Document   : indexUser
    Created on : 10 may. 2020, 17:24:16
    Author     : ferna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String usuario;
            String tipusUsuari;
            
            if(sesion.getAttribute("user")!= null && sesion.getAttribute("tipusUsuari")!= null){
                usuario = sesion.getAttribute("user").toString();
                tipusUsuari = sesion.getAttribute("tipusUsuari").toString();
                out.print("<a href='login.jsp?cerrar=true'><h5>Cerrar Session " + usuario +"</h5></a> ");            
            }else{
                out.print("<script>location.replace('login.jsp');</script>");
                }
            %>
        <h1>Pagina Usuarios</h1>
    </body>
</html>
