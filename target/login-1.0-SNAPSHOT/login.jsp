<%@page import="com.mycompany.login.Conexion"%>
<%@page session ="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
                            <form class="login100-form validate-form flex-sb flex-w" action="login.jsp" method="POST">
					<span class="login100-form-title p-b-51">
						Login
					</span>

					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<input class="login100-form-btn" type="submit" name="btnLogin" value="Login">
					</div>

				</form>
                                <%
                                    Conexion c = new Conexion();
                                    if(request.getParameter("btnLogin")!= null){
                                        String nombre = request.getParameter("username");
                                        String contrasenya = request.getParameter("pass");
                                        HttpSession sesion = request.getSession();
                                        switch(c.loguear(nombre, contrasenya)){
                                            case "administrador":
                                                sesion.setAttribute("user", nombre);
                                                sesion.setAttribute("tipusUsuari", "administrador");
                                                response.sendRedirect("indexAdmin.jsp");
                                                break;
                                            case "professor":
                                                sesion.setAttribute("user", nombre);
                                                sesion.setAttribute("tipusUsuari", "professor");
                                                response.sendRedirect("indexUser.jsp");
                                                break;
                                            case "alumne":
                                                sesion.setAttribute("user", nombre);
                                                sesion.setAttribute("tipusUsuari", "alumne");
                                                response.sendRedirect("indexUser.jsp");
                                                break;
                                            case "extern":
                                                sesion.setAttribute("user", nombre);
                                                sesion.setAttribute("tipusUsuari", "extern");
                                                response.sendRedirect("indexUser.jsp");
                                                break;
                                            default:
                                                out.write("usuario/contrasenya invàlida");
                                                break;
                                        }
                                    }
                                    if(request.getParameter("cerrar")!=null){
                                        session.invalidate();
                                    }
                                    %>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>