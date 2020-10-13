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
            <!-- Dropdowns -->
            <li>
              <a class="dropdown-trigger" data-target="dropdownPrograma" href='#'>Programas<i
                  class="material-icons right">arrow_drop_down</i></a>
            </li>
            <li>
              <a class="dropdown-trigger" data-target="dropdownCurso" href="#">Cursos<i
                  class="material-icons right">arrow_drop_down</i></a>
            </li>
            <li>
              <a class="dropdown-trigger" data-target="dropdownEdicion" href='#'>Ediciones<i
                  class="material-icons right">arrow_drop_down</i></a>
            </li>
            <li>
              <a class="dropdown-trigger" data-target="dropdownUsuario" href='#'>Usuarios<i
                  class="material-icons right">arrow_drop_down</i></a>
            </li>
            <li><a href="miPerfil.jsp"><i class="material-icons left">account_circle</i><%= session.getAttribute("nombreUser") %></a></li>
            <li><a href="logout"><i class="material-icons left">exit_to_app</i></a></li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
  <ul class="sidenav" id="mobile-demo">
    <li class="rojo"><a href="miPerfil.jsp" class="white-text"><i class="material-icons white-text">account_circle</i><%= session.getAttribute("nombreUser") %></a></li>
    <li class="no-padding">
      <ul class="collapsible collapsible-accordion">
        <li class="no-padding">
          <ul class="collapsible collapsible-accordion">
            <li>
              <a class="collapsible-header">Programas<i class="material-icons right">arrow_drop_down</i></a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="altaProgramaEdicion.jsp">Alta Programa</a></li>
                  <li><a href="consultaPrograma.jsp">Buscar</a></li>
                  <li><a href="agregarCursoPrograma.jsp">Agregar Curso</a></li>
                </ul>
              </div>
            </li>
            <li>
              <a class="collapsible-header">Cursos<i class="material-icons right">arrow_drop_down</i></a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="altaCurso.jsp">Alta Cursos</a></li>
                  <li><a href="consultaCurso.jsp">Buscar Cursos</a></li>
                </ul>
              </div>
            </li>
            <li>
              <a class="collapsible-header">Edicion<i class="material-icons right">arrow_drop_down</i></a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="altaEdicion.jsp">Agregar Edicion</a></li>
                  <li><a href="consultaEdicion.jsp">Buscar Edicion</a></li>
                </ul>
              </div>
            </li>
            <li>
              <a class="collapsible-header">Usuarios<i class="material-icons right">arrow_drop_down</i></a>
              <div class="collapsible-body">
                <ul>
                  <li><a href="altaUsuario.jsp">Alta Usuario</a></li>
                  <li><a href="consultaUsuario.jsp">Buscar</a></li>
                  <li><a href="consultaUsuario.jsp">Seguir Usuario</a></li>
                </ul>
              </div>
            </li>
           <li><a href="logout"><i class="material-icons left">exit_to_app</i></a></li>
          </ul>
        </li>
      </ul>
      <!-- Dropdown Programa -->
      <ul id="dropdownPrograma" class="dropdown-content">
        <li><a href="altaProgramaFormacion.jsp">Alta</a></li>
        <li><a href="consultaPrograma.jsp">Ver Programas</a></li>
      </ul>
      <!-- Dropdown Curso -->
      <ul id="dropdownCurso" class="dropdown-content">
        <li><a href="altaCurso.jsp">Alta</a></li>
        <li><a href="consultaCurso.jsp">Ver Cursos</a></li>
      </ul>
      <!-- Dropdown Edicion -->
      <ul id="dropdownEdicion" class="dropdown-content">
        <li><a href="altaEdicion.jsp">Alta</a></li>
        <li><a href="consultaEdicion.jsp">Ver Ediciones</a></li>
      </ul>
      <!-- Dropdown Usuario -->
      <ul id="dropdownUsuario" class="dropdown-content">
        <li><a href="altaUsuario.jsp">Alta</a></li>
        <li><a href="consultaUsuario.jsp">Ver Usuarios</a></li>
      </ul>
   </li>
   </ul>
   