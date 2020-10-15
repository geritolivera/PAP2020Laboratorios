<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/styles/style.css">
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
                <a href="index.jsp" class="brand-logo">edExt</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li class="rojo-rita">
                        <form action="Busqueda" method="post" id="formBusqueda">
                            <div class="input-field col s12">
                                <i class="material-icons prefix" id="searchIcon">search</i>
                                <input type="text" id="busqueda" class="autocomplete white-text">
                            </div>
                        </form>
                    </li>
                    <li>
                        <a href="consultaPrograma.jsp">Programas</a>
                    </li>
                    <li>
                        <a href="consultaCurso.jsp">Cursos</a>
                    </li>
                    <li>
                        <a href="consultaCurso.jsp">Ediciones</a>
                    </li>
                    <% if (session.getAttribute("nombreUser")!=null) {%>
                    <li><a href="miPerfil.jsp"><i class="material-icons left">account_circle</i><%= session.getAttribute("nombreUser") %></a></li>
                    <li><a href="logout"><i class="material-icons left">exit_to_app</i></a></li>
                    <%}else{%>
                    <li><a href="iniciarSesion.jsp"><i class="material-icons left">account_circle</i>Login</a></li>
                    <%}%>
                </ul>
            </div>
        </div>
    </nav>
</div>
<ul class="sidenav" id="mobile-demo">
    <% if (session.getAttribute("nombreUser")!=null) {%>
    <li class="rojo"><a href="miPerfil.jsp" class="white-text"><i
            class="material-icons white-text">account_circle</i><%= session.getAttribute("nombreUser") %></a></li>
    <%}else{%>
    <li class="rojo"><a href="login.html" class="white-text"><i
            class="material-icons white-text">account_circle</i>Login</a></li>
    <%}%>

    <li>
        <a href="consultaPrograma.jsp">Programas</a>
    </li>
    <li>
        <a href="consultaCurso.jsp">Cursos</a>
    </li>
    <li>
        <a href="consultaCurso.jsp">Ediciones</a>
    </li>
    <li>
        <a href="consultaUsuario.jsp">Usuarios</a>
    </li>
    <% if (session.getAttribute("nombreUser")!=null) {%>
    <li><a href="logout"><i class="material-icons left">exit_to_app</i></a></li>
    <%}%>
</ul>