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
            <form name="tableForm" class="col s12 signup-form" action="inscripcionConfirmar" method="POST">
                <div class="card material-table">
                    <div class="table-header">
                        <span class="table-title">Inscripciones</span>
                        <div class="actions">
                            <a href="#" class="search-toggle btn-flat nopadding"><i
                                    class="material-icons prefix">search</i></a>
                        </div>
                    </div>
                    <table id="tablaInscripciones">
                        <thead>
                            <tr>
                                <th>Edicion</th>
                                <th>Estudiante</th>
                                <th>Estado</th>
                                <th>Fecha de inscripcion</th>
                                <th>Prioridad</th>
                            </tr>
                        </thead>
                        
                        <tbody id="detallesIns">
                        	<tr>
	                        		
                            </tr>
                        </tbody>
                        
                    </table>
                </div>
                	<button type="submit" name="submit" class="btn-large waves-effect waves-light cyan darken-1">Confirmar</button>
            </form>
            </div>
        </div>
            
            
        </div>
    </div>
  		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdn.datatables.net/fixedcolumns/3.3.2/js/dataTables.fixedColumns.min.js"></script>
        <script src="https://cdn.datatables.net/select/1.3.1/js/dataTables.select.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
        <script src="https://gyrocode.github.io/jquery-datatables-checkboxes/1.2.10/js/dataTables.checkboxes.min.js"></script>
		<script src="resources/scripts/alta.js"> </script>		
    	<script src="resources/scripts/listas.js"> </script>
        <script src="resources/scripts/scriptTable2.js"></script>
    <%@include  file="footer.jsp" %>
<script>
		
	window.onload = function(){
		tableInscripcionesAjax();
	}
</script>