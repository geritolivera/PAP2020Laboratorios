<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
    <div class="main">
        <br><br>

        <div class="container">
            <div class="row" id="containerEstudiantes">
            <div id="admin" class="col s12">
                <div class="card material-table">
                    <div class="table-header">
                        <span class="table-title">Inscripciones</span>
                    </div>
                    <form>
                    	<input type="hidden" name="id" id="id"/>
                    	<input type="hidden" name="edicion" id="edicion"/>
                    	<input type="hidden" name="usuario" id="usuario"/>
                    	<input type="hidden" name="estado" id="estado"/>                   
                    	<input type="hidden" name="fecha" id="fecha"/>
                    	<input type="hidden" name="prioridad" id="prioridad"/>
	                    <table id="tablaInscripciones" class="table table-bordered table-striped table-hover">
	                        <thead>
	                            <tr>
	                            	<th></th>
	                                <th>Edicion</th>
	                                <th>Estudiante</th>
	                                <th>Estado</th>
	                                <th>Fecha de inscripcion</th>
	                                <th>Prioridad</th>
	                            </tr>
	                        </thead>
	                        <tbody id="detallesIns">
	                        
	                        </tbody>
	                        
	                    </table>
                    </form>
                </div>
            </div>
        </div>
            
            
        </div>
    </div>
  		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
		<script src="resources/scripts/alta.js"> </script>		
    	<script src="resources/scripts/listas.js"> </script>
    <%@include  file="footer.jsp" %>
    
<script>

	$(document).ready(function () {
		tableInscripciones();
	 });

</script>