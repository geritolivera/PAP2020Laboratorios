<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <% if (session.getAttribute("tipoUser")=="docente"){ %>
  <%@include file="defaultHeader.jsp"%>
  <%}else{ %>
  <%@include file="headerEstVis.jsp"%>
  <%}%>
  <title>edExt</title>
</head>

<body>
  <!-- Section: Slider -->
  <section class="slider">
    <ul class="slides">
      <li>
        <img src="resources/images/img1.jpg" alt="">
        <div class="caption center-align ">
          <h2 >Bienvenido a edEXT</h2>
          <h5 class="light white-text text-lighten-3 hide-on-small-only">La plataforma educativa y social que ofrece un servicio de gesti&#243;n de cursos
relacionados con la extensi�n universitaria</h5>
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

  <!-- Section: Search -->
  <section id="search" class="section section-search  rojo white-text center scrollspy">
    <div class="container">
      <div class="row">
        <div class="col s12">
          <h3>Buscar Programas</h3>
          <div class="input-field">
            <form action="infoPrograma">
              <input class="white grey-text autocomplete" placeholder="Progrmacion 1, matematica, etc..." type="text"
                id="autocomplete-input">
            </form>
          </div>
        </div>
      </div>
    </div>
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
  <!-- Section: Follow -->
  <section class="section section-follow rojo darken-4 darken-2 white-text center">
    <div class="container">
      <div class="row">
        <div class="col s12">
          <h4></h4>
          <p>Siguenos en redes sociales para enterarte de todas las novedades</p>
        </div>
      </div>
    </div>
  </section>


 
  <%@include file="footer.jsp" %>
  <script type="text/javascript">
  document.addEventListener('DOMContentLoaded', function() {
	    var elems = document.querySelectorAll('.parallax');
	    var instances = M.Parallax.init(elems);
	  });
  </script>
</body>

</html>