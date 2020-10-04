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
            <li>
              <a href="#home">Inicio</a>
            </li>
            <li>
              <a href="#popular">Programas</a>
            </li>
            <li>
              <a href="#gallery">Cursos</a>
            </li>
            <li>
              <a href="#contact">Contacto</a>
            </li>
            <li><a href="mobile.html"><i class="material-icons left">account_circle</i>Login</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
  <ul class="sidenav" id="mobile-demo">
    <li><a href="mobile.html"><i class="material-icons">account_circle</i>Login</a></li>
    <li>
      <a href="#home">Home</a>
    </li>
    <li>
      <a href="#popular">Programas</a>
    </li>
    <li>
      <a href="#gallery">Cursos</a>
    </li>
    <li>
      <a href="#contact">Contact</a>
    </li>
  </ul>

  <div class="main">
    <br><br>

    <div class="container">
      <!-- FORM-->
      <div class="row">
        <form class="col s12" action="altaUsuario" method="POST">
          <div class="card-panel">
            <h4 class="header2"> <span style="color: #81054b">></span>Alta de Usuario</h4>
            <div class="row">
              <div class="input-field col s6">
                <input type="text" name="nickName" id="nickName">
                <label for="nickName">NickName</label>
              </div>
              <div class="input-field col s6">
                <select name="tipoUser" id="tipoUser">
                  <option value="" disabled selected>Seleccione uno</option>
                  <option value="estudiante">Estudiante</option>
                  <option value="docente">Docente</option>
                </select>
                <label>Tipo de usuario</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">account_circle</i>
                <input name="nombre" id="nombre" type="text" class="validate">
                <label for="nombre">Nombre</label>
              </div>
              <div class="input-field col s6">
                <input name="apellido" id="apellido" type="text" class="validate">
                <label for="apellido">Apellido</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <i class="material-icons prefix">email</i>
                <input name="email" id="email" type="email" class="validate">
                <label for="email">Email</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">lock</i>
                <input name="password" id="password" type="password" class="validate">
                <label for="password">Contraseña</label>
              </div>
              <div class="input-field col s6">
                <input name="passwordValidacion" id="passwordValidacion" type="password" class="validate">
                <label for="passwordValidacion">Repita contraseña</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">date_range</i>
                <input type="text" name="fechaNacimiento" id="fechaNacimiento" class="datepicker">
                <label for="fechaNacimiento">Fecha de Nacimiento</label>
              </div>
              <div class="input-field col s6">
                <select name="instituto" id="instituto">
                  <option value="" disabled selected>Seleccione uno</option>
                  <option value="elbio">ELBIO</option>
                  <option value="mat">MAT</option>
                </select>
                <label id="lblInstituto">Instituto</label>
              </div>
            </div>
            <div class="center-align">
              <button class="btn waves-effect waves-light rojo" type="submit" name="action">Crear
                <i class="material-icons right">send</i>
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- Footer -->
  <footer class="section rojo white-text center">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="scripts/script.js"> </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
      document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.datepicker');
        var options = {
          autoClose: true
        };
        var instances = M.Datepicker.init(elems, options);
      });
      $(document).ready(function () {
        $('#tipoUser').formSelect();
        $('.datepicker').datepicker();
        $("#instituto").hide();
        $("#lblInstituto").hide();

      });
      $("#tipoUser").change(function () {
        if ($(this).val() == "docente") {
          $('#instituto').formSelect();
          $("#lblInstituto").show();
        }
        else{
          $('#instituto').formSelect('destroy');
          $("#lblInstituto").hide();
        }

      });
    </script>
    <p class="flow-text">edExt &copy; 2020</p>
  </footer>
</body>
</html>