<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/style.css">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <!--https://coolors.co/ba1200-5e0035-020202-023618-005c69 -->
    <!-- Compiled and minified JavaScript -->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>edExt</title>
</head>

<body>
    <div class="navbar-fixed">
        <nav class="rojo">
            <div class="container">
                <div class="nav-wrapper">
                    <a href="#!" class="brand-logo">edExt</a>
                    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                    <ul class="right hide-on-med-and-down">
                      <li class="rojo-rita	">
             			 <form action="Busqueda" method="post" id="formBusqueda">
                 			 <div class="input-field col s12">
                    			 <i class="material-icons prefix" id="searchIcon">search</i>
                      			<input type="text" id="busqueda" class="autocomplete white-text">
                  			</div>
              			</form>
          			 </li>
                     <li>
                            <a href="#popular">Programas</a>
                        </li>
                        <li>
                            <a href="#gallery">Cursos</a>
                        </li>
                        <li>
                            <a href="#gallery">Ediciones</a>
                        </li>
                        <li><a href="mobile.html"><i class="material-icons left">account_circle</i>Nombre Estudiante</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <ul class="sidenav" id="mobile-demo">
        <li class="rojo"><a href="login.html" class="white-text"><i
                    class="material-icons white-text">account_circle</i>Nombre Estudiante</a></li>
        <li>
            <a href="infoPrograma.html">Programas</a>
        </li>
        <li>
            <a href="">Cursos</a>
        </li>
        <li>
            <a href="#contact">Ediciones</a>
        </li>
        <li>
            <a href="#contact">Usuarios</a>
        </li>
    </ul>