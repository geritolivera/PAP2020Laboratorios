<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
	<% HttpSession ses = request.getSession();
    	String nickname = (String) ses.getAttribute("nickname");
    	String nombre = (String) ses.getAttribute("nombre");
   		String apellido = (String) ses.getAttribute("apellido");
    	String correo = (String) ses.getAttribute("correo");
    	Date fechaN = (Date) ses.getAttribute("fechaNac");
    	SimpleDateFormat fechaNa = new SimpleDateFormat("yyyy/MM/dd");
    	String fechaNac = fechaNa.format(fechaN);
    %>
 

	<div class="main"> 
    	<br><br>
    	<div class="container">
      	<!-- FORM-->
      	<div class="row">
			<form class="col s12" action="ModificarDatos" method="post">
			<input type="hidden" name="boton" id="boton" value="">
          	<div class="card-panel">
            	<h4 class="header2"> <span style="color: #81054b">></span>Modificar Datos de Usuario</h4>
            	<div class="row">
              		<div class="input-field col s10">
                		<i class="material-icons prefix">account_circle</i>
          				<input disabled  id="nickname" type="text" class="validate">
  				        <label for="nickname"><%=nickname %></label>
              		</div>
            	</div>
            	<div class = "row">
            		<div class="input-field col s10">
                		<i class="material-icons prefix">email</i>
          				<input disabled id="correo" type="text" class="validate">
          				<label for="nickname"><%=correo %></label>
              		</div>
            	</div>
            	<div class="row">
              		<div class="input-field col s10">
                		<input id="nombre" type="text" class="validate">
                		<label for="nombre"><%=nombre %></label>
              		</div>
              		<div class="input-field col s1">
                		<a type="button" class="btn-floating btn-small rojo oscuro-4" onclick="editar('nombre')"><i class="material-icons">mode_edit</i></a>
              		</div>
            	</div>
            	<div class="row">
            		
            		<div>
            			<div class="input-field col s10">
                			<input id="apellido" type="text" class="validate">
                			<label for="apellido"><%=apellido %></label>
              			</div>
              		</div>
              		<div class="input-field col s1">
                		<a type="button" class="btn-floating btn-small rojo oscuro-4" onclick="editar('apellido')"><i class="material-icons ">mode_edit</i></a>
              		</div>
              	</div>
            	<div class = "row">
            		<div class="input-field col s10">
                		<i class="material-icons prefix">date_range</i>
                		<input type="text" id="fechaNacimiento" class="datepicker">
                		<label for="fechaNacimiento"><%=fechaNac %></label>
              		</div>
              		    <div class="input-field col s1">
                		<a type="button" class="btn-floating btn-small rojo oscuro-4" onclick="editar('fechaNac')"><i class="material-icons ">mode_edit</i></a>
              		</div>
            	</div>
          	</div>
        	</form>
      	</div>
      	</div>
  	</div>
 
 <%@include  file="footer.jsp" %>
 <script>
 	function editar(atributo) {
		document.getElementById("boton").value = atributo;
		document.forms[0].submit();
	}
 
 </script>
 <script>
 		document.addEventListener('DOMContentLoaded', function () {
        	var elems = document.querySelectorAll('.datepicker');
        	var options = {
          	autoClose: true
        	};
        var instances = M.Datepicker.init(elems, options);
      	});
      
</script>
