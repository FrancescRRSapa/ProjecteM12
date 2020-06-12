<%-- 
    Document   : reservarHora
    Created on : 10 jun. 2020, 22:56:15
    Author     : Francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva examen</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/calendari.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body onload="loadFunction()">
<header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Institut Sa Palomera
                </div>
                <nav>
                    <a href="indexUser.jsp"><h5>Principal</h5></a>
            <%
               HttpSession sesion = request.getSession();
               String usuario = "";
               String tipusUsuari;

               if(sesion.getAttribute("user")!= null && sesion.getAttribute("tipusUsuari")!= null){
                   usuario = sesion.getAttribute("user").toString();
                   tipusUsuari = sesion.getAttribute("tipusUsuari").toString();
                   out.print("<a href='index.jsp?cerrar=true'><h5>Tancar sessió de " + usuario +"</h5></a> ");            
               }else{
                   out.print("<script>location.replace('index.jsp');</script>");
                   }
            %>
                </nav>
            </div> 
        </header>
        <div>
            <form action="" method="POST">
                <label for="dia_setmana">Dia a escollir:</label><br>
                <input type="date" id="dia_setmana" name="dia_setmana" required><br>
                <label for="hora">Hora:</label><br>
                <input type="time" id="hora" name="hora" value="16:00" required><br>
                <label for="tipus">Tipus examen:</label><br>
                <select name="tipus" id="tipus">
                    <option value=""></option>
                    <option value="MOS">MOS</option>
                    <option value="MTA">MTA</option>
                </select><br><br>
                <input type="text" name="nomusuari" value="<% out.print(usuario); %>" hidden>
                <input type="submit" name="enviar">
            </form>
        </div>
        <footer id="footer">
            Sergio Fernández i Francesc Roca - 2n DAW 2019/2020
        </footer>
    </body>
</html>
<script>
    /**
     * Funció per donar la data d'avui al input de la data del formulari de reserva
     * @author Francesc Roca
     * @returns Data formatada i inserida al value per defecte de la data examen
     */
    function loadFunction() {
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10){
        dd='0'+dd;
    } 
    if(mm<10){
        mm='0'+mm;
    } 

    today = yyyy+'-'+mm+'-'+dd;                
    document.getElementById("dia_setmana").defaultValue =today+"";
}
</script>