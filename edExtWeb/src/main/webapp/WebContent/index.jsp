<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="resources/styles/styleTable.css">
  <link rel="stylesheet" href="resources/styles/style.css">
  <link rel="shortcut icon" href="resources/images/intento3.png" sizes="35px;35px">
  <% if (session.getAttribute("tipoUser")=="docente"){ %>
  <%@include file="defaultHeader.jsp"%>
  <%}else{ %>
  <%@include file="headerEstVis.jsp"%>
  <%}%>

  <title>edExt</title>
</head>

<body>
<div class="main">
  <!-- Section: Slider -->
  <section class="slider">
    <ul class="slides">
      <li>
        <img src="resources/images/img1.jpg" alt="">
        <div class="caption center-align ">
          <h2 >Bienvenido a edEXT</h2>
          <h5 class="light white-text text-lighten-3 hide-on-small-only">La plataforma educativa y social que ofrece un servicio de gesti&#243;n de cursos
relacionados con la extensi&#243;n universitaria</h5>
          <% if (session.getAttribute("nickname")==null){ %>
            <a href="altaUsuario.jsp" class="btn btn-large rojo">&#218;nete</a>
          <% }%>
        </div>
      </li>
      <li>
        <img src="resources/images/img2.jpg" alt="">
        <div class="caption left-align">
          <h2>Gesti&#243;n de Cursos</h2>
          <h4 class="light grey-text text-lighten-3 hide-on-small-only">Adquiere informaci&#243;n sobre los Cursos registrados! </h4>
          <a href="consultaCurso.jsp" class="btn btn-large rojo">Ver Cursos</a>
        </div>
      </li>
      <li>
        <img src="resources/images/img3.jpg"  alt="">
        <div class="caption right-align -text">
          <h2>Gesti&#243;n de Programas</h2>
          <h4 class="light white-text text-lighten-3 hide-on-small-only">Adquiere informaci&#243;n sobre los Programas registrados!</h4>
          <a href="consultaPrograma.jsp" class="btn btn-large rojo">Ver Programas</a>
        </div>
      </li>
    </ul>
  </section>

  <!-- Section: Icon Boxes -->
  <section class="section section-icons grey lighten-4 center">
    <div class="container">
      <div class="row">
        <div class="col s12 m4">
          <div class="card-panel">
            <i class="material-icons  large red-text">library_books</i>
            <h4>Cursos</h4>
            <p>Gestiona tus cursos como desees.</p>
          </div>
        </div>
        <div class="col s12 m4">
          <div class="card-panel">
            <i class="material-icons large red-text">collections_bookmark</i>
            <h4>Programas</h4>
            <p>Mejora tu organizaci&#243;n.</p>
          </div>
        </div>
        <div class="col s12 m4">
          <div class="card-panel">
            <i class="material-icons large red-text">people</i>
            <h4>Amigos</h4>
            <p>Tus amigos te estan esperando.</p>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Section: Search -->
  <section id="search" class="section section-search center scrollspy">
    <div class="container">
      <div class="row">
        <div class="col s12">
          <div id="admin" class="col s12">
            <div class="card material-table">
              <div class="table-header">
                <span class="table-title">Busqueda General</span>
                <div class="actions">
                  <a href="#" class="search-toggle btn-flat nopadding" name="input"><i class="material-icons prefix">search</i></a>
                </div>
              </div>
              <table id="datatable" class="responsive-table">
                <thead>
                <tr>
                  <th>Tipo</th>
                  <th>Nombre</th>
                  <th>Descripcion</th>
                  <th>Link</th>
                </tr>
                </thead>
                <tbody id="datatablebody">
                <tr>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>



</div>
<%@include file="footer.jsp" %>
  <script type="text/javascript">
  document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.parallax');
	    var instances = M.Parallax.init(elems);
	  });
  </script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="resources/scripts/busqueda.js"></script>
