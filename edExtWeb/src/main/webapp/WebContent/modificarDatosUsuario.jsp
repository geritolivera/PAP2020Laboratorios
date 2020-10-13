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
            	<h4 class="header2"> <span style="color: #81054b">></span>Modificar Datos de Usuario</h4>
            	<div class="row">
              		<div class="input-field col s10">
                		<i class="material-icons prefix">account_circle</i>
          				<input disabled value="Nickname" id="nickname" type="text" class="validate">
              		</div>
            	</div>
            	<div class = "row">
            		<div class="input-field col s10">
                			<i class="material-icons prefix">email</i>
          					<input disabled value="Correo Electronico" id="email" type="text" class="validate">
              		</div>
            	</div>
            	<div class="row">
              		<div class="input-field col s10">
                		<input id="nombre" type="text" class="validate">
                		<label for="nombre">Nombre</label>
              		</div>
            	</div>
            	<div class="row">
            		<div>
            			<div class="input-field col s10">
                			<input id="apellido" type="text" class="validate">
                			<label for="apellido">Apellido</label>
              			</div>
              		</div>
              	</div>
            	<div class = "row">
            		<div class="input-field col s10">
                		<i class="material-icons prefix">date_range</i>
                		<input type="text" name="fechaNacimiento" id="fechaNacimiento" class="datepicker">
                		<label for="fechaNacimiento">Fecha de Nacimiento</label>
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
      
</script>