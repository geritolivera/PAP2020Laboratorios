<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include  file="defaultHeader.jsp" %>
 
  <div class="main">
    <br><br>
    <div class="container">
      <!-- FORM-->
      <div class="row">
        <form class="col s12">
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
                <input id="nombre" type="text" class="validate">
                <label for="nombre">Nombre</label>
              </div>
              <div class="input-field col s6">
                <input id="apellido" type="text" class="validate">
                <label for="apellido">Apellido</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s12">
                <i class="material-icons prefix">email</i>
                <input id="email" type="email" class="validate">
                <label for="email">Email</label>
              </div>
            </div>
            <div class="row">
              <div class="input-field col s6">
                <i class="material-icons prefix">lock</i>
                <input id="password" type="password" class="validate">
                <label for="password">Contraseña</label>
              </div>
              <div class="input-field col s6">
                <input id="passwordValidacion" type="password" class="validate">
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
                <select name="institutos" id="institutos">
                  <option value="" disabled>Seleccione uno</option>
                  </select>
                <label id="lblInstituto">Instituto</label>
              </div>
            </div>
            <div class="center-align">
              <button class="btn waves-effect waves-light rojo" type="button" name="action" onclick="usuario()">Crear
                <i class="material-icons right">send</i>
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
<%@include  file="footer.jsp" %>
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
        $("#institutos").hide();
        $("#lblInstituto").hide();

      });
      $("#tipoUser").change(function () {
        if ($("#tipoUser").val() == "docente") {
          $('#institutos').formSelect();
          $("#lblInstituto").show();
        }
        else{
          $('#institutos').formSelect('hide');
          $("#lblInstituto").hide();
        }

      });
</script>
<script src="resources/scripts/listas.js"> </script>
<script src="resources/scripts/alta.js"> </script>