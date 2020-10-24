<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <!--https://coolors.co/ba1200-5e0035-020202-023618-005c69 -->
  <!-- Compiled and minified JavaScript -->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="resources/styles/styleTable.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css">
  <link rel="stylesheet" href="resources/styles/style.css">

  <title>edExt</title>
</head>

<body>

<div class="navbar-fixed">
  <nav class="rojo">
    <div class="col">
      <a href="index.jsp" class="brand-logo">edExt</a>
    </div>
    <div class="container">
      <div class="nav-wrapper">
        <div class="row" >
          <div class="col s2">
            <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
          </div>
          <div class="col s10">
            <ul class="row right hide-on-med-and-down">
              <li class="col s2" >
                <form  id="formBusqueda" >
                  <div class="input-field col s12">
                    <i class="material-icons prefix" id="searchIcon" style="top: 0;">search</i>
                    <input type="text" id="busqueda" class="autocomplete white-text" placeholder="Buscar" onsubmit="busqueda($event)">
                  </div>
                </form>
              </li>
              <li class="col s2" >
                <a class="dropdown-trigger" data-target="dropdownPrograma" href='#'>Programas<i class="material-icons right">arrow_drop_down</i></a>
              </li>
              <li class="col s2" >
                <a class="dropdown-trigger" data-target="dropdownCurso" href="#">Cursos<i class="material-icons right">arrow_drop_down</i></a>
              </li>
              <li class="col s2" >
                <a class="dropdown-trigger" data-target="dropdownEdicion" href='#'>Ediciones<i class="material-icons right">arrow_drop_down</i></a>
              </li>
              <li class="col s2" >
                <a class="dropdown-trigger" data-target="dropdownUsuario" href='#'>Usuarios<i class="material-icons right">arrow_drop_down</i></a>
              </li>
              <li class="col s2">

                <div class="row">
                  <div class=" col s10">
                    <a href="miPerfil.jsp"><i class="material-icons left">account_circle</i>admin</a>
                  </div>
                  <div class="col s2">
                    <i class="material-icons left" type="button" onclick="logout()">exit_to_app</i>
                  </div>
                </div>
              </li>

            </ul>
          </div>
        </div>

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
                <li><a href="altaProgramaFormacion.jsp">Alta Programa</a></li>
                <li><a href="consultaPrograma.jsp">Buscar</a></li>
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


<script>

  $(document).ready(function(){
    $('.collapsible').collapsible();
  });



</script>
<script src="resources/scripts/log.js"></script>
<script src="resources/scripts/busqueda.js"></script>
<script src="resources/scripts/alta.js"></script>