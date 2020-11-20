<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>

<link rel="stylesheet" href="resources/styles/style.css">
<div class="main">
	<br><br>
	<div class="container">
		<div class="row">
			<h5 class="header2"> <span style="color: #81054b">></span>Consulta de Curso</h5>
			<div class="input-field col s12 m6">
				<div>
					<label>Instituto</label>
					<select name="institutos" id="institutos" onchange="collectionCursosPorInstituto(institutos.value)">
						<option value="" disabled >Seleccione uno</option>
					</select>
				</div>
				<div>
					<label>Categorias</label>
					<select name="categorias" id="categorias" onchange="collectionCursosPorCategoria(categorias.value)">
						<option value="" disabled >Seleccione uno</option>
					</select>
				</div>
			</div>

			<!-- CARD CONSULTA CURSO-->
			<div>
				<div class="col s12 m6">
					<div class="card teal darken-4">
						<div class="card-content white-text">
							<span class="card-title">Cursos</span>
						</div>
						<ul class="collection" name="curso" id="curso">
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="resources/scripts/listas.js"> </script>
<script>
	$(document).ready(function () {
		getInstitutos();
		getCategorias();
		$('#institutos').formSelect();
		$('#categorias').formSelect();
	});
</script>
<%@include  file="footer.jsp" %>
   