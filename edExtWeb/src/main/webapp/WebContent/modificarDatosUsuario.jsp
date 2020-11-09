<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%}%>

<link rel="stylesheet" href="resources/styles/style.css">
 <%
  HttpSession ses = request.getSession();
  String nickname = (String) ses.getAttribute("nickname");
  String nombre = (String) ses.getAttribute("nombre");
  String correo = (String) ses.getAttribute("correo");
  String apellido = (String) ses.getAttribute("apellido");
  Date fechaN = (Date) ses.getAttribute("fechaNac");

  SimpleDateFormat fechaNa = new SimpleDateFormat("yyyy/MM/dd");
  String fechaNac = fechaNa.format(fechaN);

 %>
	<div class="main"> 
    	<br><br>
    	<div class="container">
      	<!-- FORM-->
      	<div class="row">
			<form class="col s8 offset-s2 center-align" id="formModUser" >
          	<div class="card-panel">
            	<h4 class="header2"> <span style="color: #81054b">></span>Modificar Datos de Usuario</h4>
            	<div class="row">
              		<div class="input-field col s11">
                		<i class="material-icons prefix">account_circle</i>
          				<input disabled id="nickname" type="text" value="<%=nickname%>">
              		</div>
            	</div>
            	<div class = "row">
            		<div class="input-field col s11">
                			<i class="material-icons prefix">email</i>
          					<input disabled id="email" type="text" value="<%=correo%>">
              		</div>
            	</div>
            	<div class="row">
              		<div class="input-field col s11">
                		<input disabled id="nombre" type="text" class="validate" value="<%=nombre%>">
                		<label for="nombre">Nombre</label>
              		</div>
              		<div class="input-field col s1" id="editNombre">
                		<a class="btn-floating btn-small rojo oscuro-4"><i class="material-icons">mode_edit</i></a>
              		</div>
            	</div>
            	<div class="row">
            		
            		<div>
            			<div class="input-field col s11">
                			<input disabled id="apellido" type="text" class="validate" value="<%=apellido%>">
                			<label for="apellido">Apellido</label>
              			</div>
              		</div>
              		<div class="input-field col s1" id="editApellido">
                		<a class="btn-floating btn-small rojo oscuro-4"><i class="material-icons ">mode_edit</i></a>
              		</div>
              	</div>
            	<div class = "row">
            		<div class="input-field col s11">
                		<i class="material-icons prefix">date_range</i>
                		<input disabled type="text" name="fechaNacimiento" id="fechaNacimiento" class="datepicker" value="<%=fechaNac%>">
                		<label for="fechaNacimiento">Fecha de Nacimiento</label>
              		</div>
              		<div class="input-field col s1" id="editFecha">
                		<a class="btn-floating btn-small rojo oscuro-4"><i class="material-icons ">mode_edit</i></a>
              		</div>
            	</div>
            	<div class = "row">
            		<div class="center-align">
             			<button class="btn waves-effect waves-light rojo" type="button" name="action" onclick="modUsuario()">Modificar
                			<i class="material-icons right">send</i>
             			</button>
            		</div>
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
 	    $('#editFecha').click(function(){
 		  $('#fechaNacimiento').prop('disabled', function(i, v) { return !v; });
 	    });
 	    $('#editApellido').click(function(){
  		  $('#apellido').prop('disabled', function(i, v) { return !v; });
  	    });
 	    $('#editNombre').click(function(){
 		  $('#nombre').prop('disabled', function(i, v) { return !v; });
 	    });
 		
 	   function modUsuario() {
 		    const nickname = document.querySelector("#nickname").value;
 		    const nombre = document.querySelector("#nombre").value;
 		    const apellido = document.querySelector("#apellido").value;
 		    const fechaNacimiento = document.querySelector("#fechaNacimiento").value;
 		    console.log(nickname);
 		    console.log(fechaNacimiento);
 		    let fetchUrl;
 		    fetchUrl = 'ModificarDatos?nickname=' + nickname +
 		        '&nombre=' + nombre +
 		        '&apellido=' + apellido +
 		        '&fechaNacimiento=' + fechaNacimiento;
 		        fetch(fetchUrl, {
 		            method: 'POST',
 		        }).then((res) => {
 		            return res.json();
 		            console.log(`que me devolviste papei `, res);
 		        }).then((respuesta) => {
 		            console.log(`respuesta: `, respuesta);
 		            respuesta.codigo //1 o 0
 		            respuesta.mensaje //mensaje de error o success
 		            if (respuesta.codigo == 0) {
 		                mensajeConfirmacion("El usuario ha sido modificado!", respuesta.mensaje).then(() => {

 		                    window.location = baseURL + 'miPerfil.jsp';
 		                })
 		            } else {
 		                mensajeError("Error en alta", respuesta.mensaje).then(() => {
 		                    if (respuesta.elemento != null)
 		                        document.getElementById(respuesta.elemento).focus();
 		                }
 		                )
 		            }
 		        }).catch((err) => {
 		            console.error(' paso algo: ', err);
 		        });
 		}
</script>