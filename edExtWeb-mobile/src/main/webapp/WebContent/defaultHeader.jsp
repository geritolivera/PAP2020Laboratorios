<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="resources/images/intento2.png">
  <link rel="stylesheet" href="resources/styles/style.css">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <!--https://coolors.co/ba1200-5e0035-020202-023618-005c69 -->
  <!-- Compiled and minified JavaScript -->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css">
  <title>edExt</title>
</head>

<body>

<div class="navbar-fixed">
  <nav class="rojo">
<%--    <div class="container">--%>
      <div class="nav-wrapper">
        <a href="index.jsp" class="brand-logo hide-on-med-and-down" id="brand-logo-large">edExt</a>
        <a href="index.jsp" class="brand-logo hide-on-large-only" id="brand-logo-mobile">edExt</a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">

          <li class="rojo-rita">
          <li>
            <a class="waves-effect waves-light btn" id="searchIcon"  onclick="window.location = 'http://localhost:8081/edExtWeb-mobile/busquedaGeneral.jsp';">Buscar</a>
          </li>
          </li>
          <li>
            <a class="dropdown-trigger" data-target="dropdownPrograma" href='#'>Programas<i class="material-icons right">arrow_drop_down</i></a>
          </li>
          <li>
            <a class="dropdown-trigger" data-target="dropdownCurso" href="#">Cursos<i class="material-icons right">arrow_drop_down</i></a>
          </li>
          <li>
            <a class="dropdown-trigger" data-target="dropdownEdicion" href='#'>Ediciones<i class="material-icons right">arrow_drop_down</i></a>
          </li>
          <li>
            <a href="consultaUsuario.jsp">Usuarios</a>
          </li>
          <li>
            <a href="miPerfil.jsp"><i class="material-icons left">account_circle</i><%= session.getAttribute("nombreUser") %></a>
          </li>
          <li>
            <a ><i class="material-icons left" type="button" onclick="logout()">exit_to_app</i></a>
          </li>

        </ul>
      </div>
<%--    </div>--%>
  </nav>

</div>
<ul class="sidenav" id="mobile-demo" style="width: 48%">
  <li class="rojo"><a href="miPerfil.jsp" class="white-text"><i class="material-icons white-text">account_circle</i><%= session.getAttribute("nombreUser") %></a></li>
  <li class="no-padding">
    <ul class="collapsible collapsible-accordion">
      <li class="no-padding">
        <ul class="collapsible collapsible-accordion">
          <li>
            <a class="collapsible-header">Programas<i class="material-icons right">arrow_drop_down</i></a>
            <div class="collapsible-body">
              <ul>
                <li><a href="consultaPrograma.jsp" class="hijo">Buscar</a></li>
              </ul>
            </div>
          </li>
          <li>
            <a class="collapsible-header">Cursos<i class="material-icons right">arrow_drop_down</i></a>
            <div class="collapsible-body">
              <ul>
                <li><a href="consultaCurso.jsp" class="hijo">Buscar Cursos</a></li>
              </ul>
            </div>
          </li>
          <li>
            <a class="collapsible-header">Edicion<i class="material-icons right">arrow_drop_down</i></a>
            <div class="collapsible-body">
              <ul>
                <li><a href="consultaEdicion.jsp" class="hijo">Buscar Edicion</a></li>
              </ul>
            </div>
          </li>
          <li>
            <a href="consultaUsuario.jsp">Usuarios</a>
        </li>
        </ul>
      </li>
    </ul>
    <!-- Dropdown Programa -->
    <ul id="dropdownPrograma" class="dropdown-content">
      <li><a href="consultaPrograma.jsp">Ver Programas</a></li>
    </ul>
    <!-- Dropdown Curso -->
    <ul id="dropdownCurso" class="dropdown-content">
      <li><a href="consultaCurso.jsp">Ver Cursos</a></li>
    </ul>
    <!-- Dropdown Edicion -->
    <ul id="dropdownEdicion" class="dropdown-content">
      <li><a href="consultaEdicion.jsp">Ver Ediciones</a></li>
    </ul>
    <li><a type="button" href="busquedaGeneral.jsp" ><i class="material-icons left ind">search</i>Buscar</a></li>
	<% if (session.getAttribute("nombreUser")!=null) {%>
    <li><a type="button" onclick="logout()"><i class="material-icons left ind">exit_to_app</i>Logout</a></li>
    <%}%>
  </li>
</ul>



<script>

  // Or with jQuery

  $(document).ready(function(){
    $('.collapsible').collapsible();
  });
</script>
<script src="resources/scripts/log.js"></script>
<script src="resources/scripts/alta.js"></script>