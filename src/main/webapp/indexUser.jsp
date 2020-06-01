<%-- 
    Document   : indexUser
    Created on : 10 may. 2020, 17:24:16
    Author     : ferna
    Author     : francesc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proctor</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/calendari.css">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script src="js/script.js"></script>
        <script src="js/calendari.js"></script>
    </head>
    <body>
        <header>
            <div class="wrapper">
                <div class="logo">
                    <!-- <img src="logoSapa.png" id="sapa"> -->
                    Institut Sa Palomera
                </div>
                <nav>
            <%
               HttpSession sesion = request.getSession();
               String usuario;
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
        <div id="demanarCodi">
            <h2>Solicitar nou codi</h2>
            <form action="SrvDemanarCodi" method="POST">
                <label for="certificacio">Quina certificació vols escollir?</label>
                <br>
                <select name="certificacio" id="certificacio">
                    <option value=""></option>
                    <option value="MOS">MOS</option>
                    <option value="MTA">MTA</option>
                </select>
                <br>
                <label for="correu">Escriu el teu correu electrònic</label>
                <br>
                <input type="email" placeholder="elteu@correu.com">
                <br>
                <input type="submit">
            </form>
        </div>
        <div id="calendar">
            <h2>Calendari de dates disponibles per examens</h2>
            <table id="calendar">
                <caption></caption>
                <thead>
                        <tr>
                                <th>Lun</th><th>Mar</th><th>Mie</th><th>Jue</th><th>Vie</th><th>Sab</th><th>Dom</th>
                        </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </body>
</html>

<script>
var actual=new Date();
function mostrarCalendario(year,month)
{
var now=new Date(year,month-1,1);
var last=new Date(year,month,0);
var primerDiaSemana=(now.getDay()==0)?7:now.getDay();
var ultimoDiaMes=last.getDate();
var dia=0;
var resultado="<tr bgcolor='silver'>";
var diaActual=0;
console.log(ultimoDiaMes);

var last_cell=primerDiaSemana+ultimoDiaMes;

// hacemos un bucle hasta 42, que es el máximo de valores que puede
// haber... 6 columnas de 7 dias
for(var i=1;i<=42;i++)
{
        if(i==primerDiaSemana)
        {
                // determinamos en que dia empieza
                dia=1;
        }
        if(i<primerDiaSemana || i>=last_cell)
        {
                // celda vacia
                resultado+="<td>&nbsp;</td>";
        }else{
                // mostramos el dia
                if(dia==actual.getDate() && month==actual.getMonth()+1 && year==actual.getFullYear())
                        resultado+="<td class='hoy'>"+dia+"</td>";
                else
                        resultado+="<td>"+dia+"</td>";
                dia++;
        }
        if(i%7==0)
        {
                if(dia>ultimoDiaMes)
                        break;
                resultado+="</tr><tr>\n";
        }
}
resultado+="</tr>";

var meses=Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");

// Calculamos el siguiente mes y año
nextMonth=month+1;
nextYear=year;
if(month+1>12)
{
        nextMonth=1;
        nextYear=year+1;
}

// Calculamos el anterior mes y año
prevMonth=month-1;
prevYear=year;
if(month-1<1)
{
        prevMonth=12;
        prevYear=year-1;
}

document.getElementById("calendar").getElementsByTagName("caption")[0].innerHTML="<div>"+meses[month-1]+" / "+year+"</div><div><a onclick='mostrarCalendario("+prevYear+","+prevMonth+")'>&lt;</a> <a onclick='mostrarCalendario("+nextYear+","+nextMonth+")'>&gt;</a></div>";
document.getElementById("calendar").getElementsByTagName("tbody")[0].innerHTML=resultado;
}

mostrarCalendario(actual.getFullYear(),actual.getMonth()+1);
</script>
