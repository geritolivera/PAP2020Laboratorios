<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@ page import="datatypes.DTUsuario" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Usuario</title>
	<% if (session.getAttribute("tipoUser")=="docente"){ %>
	<%@include file="defaultHeader.jsp"%>
	<%}else{ %>
	<%@include file="headerEstVis.jsp"%>
	<%}%>

</head>
<body>
<div class=main>
	<div class="container">
		<div class="row">
			<div class="input-field col s12">
		    <select id="listassUsuarios">
		      <option value="" disabled >Seleccionar un usuario</option>
		    </select>
		    <label>Lista de usuarios</label>
			</div>
			<div class="col s12">
			<div class="col s3">
		      <div class="card">
		        <div class="card-image">
		          <img src="resources/images/asd.jpg">
		          <span class="card-title">Usuarios</span>
		        </div>
		        <div class="card-content">
		          <p id="descripcion"></p>
		        </div>
		      </div>
			</div>
			<div class="col s9">
				<ul class="collapsible">
		    		<li>
		      		<div class="collapsible-header green"><i class="material-icons">account_circle</i>Informacion personal</div>
		      		<div class="collapsible-body">

		      			<div class="col s5">
              			<img src="images/img2.jpg" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
           				 </div>
                		<label for="nickname" style="color:black"><b>NickName:</b><br></label>
                		<label for="nombre" style="color:black"><b>Nombre:</b><br></label>
                		<label for="apellido" style="color:black"><b>Apellido:</b> <br></label>
                		<label for="correo" style="color:black"><b>Correo:</b><br></label>
                		<label for="fnacimiento" style="color:black"><b>Fecha de Nacimiento:</b> <br></label>
		      		</div>
		    		</li>

		    		<li>
		      		<div class="collapsible-header lime"><i class="material-icons">book</i>Cursos</div>
		      		<div class="collapsible-body">
			    		<select id="listaCursos">
			      		<option value="" disabled selected>Seleccionar un curso</option>
			      		<option value="1">cursos</option>
			   			 </select>
			    		<label>Lista de cursos</label>
                		<label for="nombre" style="color:black"><b>Nombre: </b><br></label>
                		<label for="finicio" style="color:black"><b>Fecha de Inicio: </b><br></label>
                		<label for="ffin" style="color:black"><b>Fecha de Fin:</b><br></label>
                		<label for="fpublicacion" style="color:black"><b>Fecha de publicacion:</b><br></label>
                		<label for="vigente" style="color:black"><b>Vigente:</b><br></label>
					</div>
		    		</li>
		    		<li>
		      		<div class="collapsible-header light-green accent-1"><i class="material-icons">people</i>Social</div>
		      		<div class="collapsible-body">
		      		<ul class="collection with-header">
				        <li class="collection-header"><h10 style="color:black"><b>Seguidos</b></h10></li>
				        <li class="collection-item">Alvin</li>
				        <li class="collection-item">Alvin</li>
				     </ul>
				     <ul class="collection with-header">
				        <li class="collection-header"><h10 style="color:black"><b>Seguidores</b></h10></li>
				        <li class="collection-item">Alvin</li>
				        <li class="collection-item">Alvin</li>

				     </ul>

		      		</div>
		    		</li>
		  		</ul>
			</div>
			</div>
			<%}else if(nickname.equals("estudiante")) {%>
						<div class="col s12">
			<div class="col s3">
		      <div class="card">
		        <div class="card-image">
		          <img src="images/img1.jpg">
		          <span class="card-title">Usuarios</span>
		        </div>
		        <div class="card-content">
		          <p>Aqui puedes encontrar la informacion de todos los usuarios.</p>
		        </div>
		      </div>
			</div>
			<div class="col s9">
				<ul class="collapsible">
		    		<li>
		      		<div class="collapsible-header green"><i class="material-icons">account_circle</i>Informacion personal</div>
		      		<div class="collapsible-body">

		      			<div class="col s5">
              			<img src="images/img2.jpg" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
           				 </div>
                		<label for="nickName" style="color:black"><b>NickName:</b><br></label>
                		<label for="nombre" style="color:black"><b>Nombre:</b> <br></label>
                		<label for="apellido" style="color:black"><b>Apellido:</b> <br></label>
                		<label for="correo" style="color:black"><b>Correo:</b><br></label>
                		<label for="fnacimiento" style="color:black"><b>Fecha de Nacimiento:</b> <br></label>
		      		</div>
		    		</li>

		    		<li>
		      		<div class="collapsible-header lime"><i class="material-icons">book</i>Cursos</div>
		      		<div class="collapsible-body">
			    		<select id="listaCursos">
			      		<option value="" disabled selected>Seleccionar un curso</option>
			      		<option value="1">cursos</option>
			   			 </select>
			    		<label>Lista de cursos</label>
                		<label for="nombre" style="color:black"><b>Nombre: </b><br></label>
                		<label for="finicio" style="color:black"><b>Fecha de Inicio: </b><br></label>
                		<label for="ffin" style="color:black"><b>Fecha de Fin:</b><br></label>
                		<label for="fpublicacion" style="color:black"><b>Fecha de publicacion:</b><br></label>
                		<label for="vigente" style="color:black"><b>Vigente:</b><br></label>
					</div>
		    		</li>
		   			<li>
		      		<div class="collapsible-header yellow"><i class="material-icons">book</i>Programas</div>
		      		<div class="collapsible-body">
						<select id="listaProgramas">
			      		<option value="" disabled selected>Seleccionar un programa</option>
			      		<option value="1">programas</option>
		   			 	</select >
		    			<label>Lista de Programas</label>
                		<label for="nombre" style="color:black"><b>Nombre:</b><br></label>
                		<label for="descripcon" style="color:black"><b>Descripcion:</b><br></label>
                		<label for="finicio" style="color:black"><b>Fecha de Inicio:</b><br></label>
                		<label for="ffin" style="color:black"><b>Fecha de Fin:</b><br></label>
                		<label for="fingreso" style="color:black"><b>Fecha de ingreso:</b><br></label>
					</div>
		    		</li>
		    		<li>
		      		<div class="collapsible-header light-green accent-1"><i class="material-icons">people</i>Social</div>
		      		<div class="collapsible-body">
		      		<ul class="collection with-header">
				        <li class="collection-header"><h10 style="color:black"><b>Seguidos</b></h10></li>
				        <li class="collection-item">Alvin</li>
				        <li class="collection-item">Alvin</li>
				     </ul>
				     <ul class="collection with-header">
				        <li class="collection-header"><h10 style="color:black"><b>Seguidores</b></h10></li>
				        <li class="collection-item">Alvin</li>
				        <li class="collection-item">Alvin</li>

				     </ul>

		      		</div>
		    		</li>
		  		</ul>
			</div>
			</div>
			<%%>
		</div>
	</div>		
</div>
<%@include file="footer.jsp" %>
<script type="text/javascript">
var nickname = document.getElementById("listaUsuarios");
function infoUsuario() { 
    //completar los datos del usuario
    //listar los cursos 
    //listar los programas
} 
nickname.onchange=infoUsuario;    
</script>
<script type="text/javascript">
var curso = document.getElementById("listaCursos");
function infoCurso() { 
    //completar los datos del curso
    } 
curso.onchange=infoCurso;  

</script>
<script type="text/javascript">
var prog = document.getElementById("listaProgramas");
function infoPrograma() { 
    //completar los datos del curso
    } 
prog.onchange=infoPrograma;  
 selected
</script>
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.collapsible');
    var instances = M.Collapsible.init(elems);
  });
</script>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('select');
    var instances = M.FormSelect.init(elems);
  });
</script>
</body>
</html>