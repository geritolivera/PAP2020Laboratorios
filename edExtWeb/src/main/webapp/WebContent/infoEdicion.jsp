<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="resources/styles/styleTableEdicion.css">
<link rel="stylesheet" href="resources/styles/style.css">
<div class="main">
    <br><br>

    <div class="container">

        <div class="row">
            <!-- CARD PROGRAMA-->
            <div class="col s12 m7">
                <div class="card">
                    <div class="card-image">
                        <img src="resources/images/img2.jpg">
                        <span class="card-title" id="nombre">${nombre}</span>
                        <!-- -Aca se pone el a si es vigente -->
                        <%
	                            String tipoUser = (String) session.getAttribute("tipoUser");
                            	Boolean userLog = (Boolean) request.getAttribute("userLog");
	                        	String vigencia = (String) request.getAttribute("vigencia");
	                        	String cupo = (String) request.getAttribute("haycupo");
	                        	if(userLog && tipoUser.equals("estudiante") && vigencia.equals("Si") && cupo.equals("Si")){
	                        		String inscripto = (String) request.getAttribute("inscripto");
	                        		if(inscripto.equals("No") || inscripto.equals("Rechazado")){
                            %>
                        <div class="card-action right-align">
                            <a id="ediBTN" class="waves-effect waves-light btn" type="button"
                                onclick="inscribirUsuario('${nombre}')"
                                <%--href="inscripcionUE?edicion=${nombre}"--%>><i
                                    class="material-icons"></i>Inscribirse</a>
                        </div>
                        <%}else if(inscripto.equals("Pendiente")){%>
                        <div class="card-action right-align">
                            <a class="btn disabled">Pendiente</a>
                        </div>
                        <%}else{%>
                        <div class="card-action right-align">
                            <a class="btn disabled">Inscripto</a>
                        </div>
                        <%}
							}%>
                    </div>
                    <ul id="dataEdicion" class="collection">
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha Publicacion
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="fechaPub">${fechaPub}</div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="cupo">${cupo}</div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>
                                    Fecha Inicio</div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="fechaI">${fechaI}</div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha Fin
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="fechaF">${fechaF}</div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-help_outline"></i> Vigente
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align">${vigencia}</div>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
             <!-- CARD DOCENTES-->
            <div class="col s12 m5">
                <div class="card teal darken-4">
                    <div class="card-content white-text">
                        <span class="card-title">Docentes</span>
                    </div>
                    <div class="collection" name="docentes" id="docentes">
                        <c:forEach var="docs" items="${docentes}">
                            <a class="collection-item">${docs}</a>
                        </c:forEach>
                    </div>
                </div>
            <% if(userLog && tipoUser.equals("docente")&& vigencia.equals("Si")){ %>
                <div class="row center">
                    <button onclick="toggleEstudiantes()" class="btn pink darken-4">Agregar Estudiantes +</button>
                </div>
                <div class="row center">
                    <button onclick="toggleAceptados()" class="btn pink darken-4">Ver Aceptados</button>
                </div>
                <%}%>
            </div>
            
            <!-- TABLA INSCRIPCIONES-->
            <div class="row" style="display: none;" id="containerEstudiantes">
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

            <!-- TABLA ACEPTADOS-->
            
            <div class="row" style="display: none;" id="containerEstudiantesAceptados">
                <div id="admin" class="col s12">
                    <div class="card material-table">
                        <div class="table-header">
                            <span class="table-title">Estudiantes Aceptados</span>
                        </div>
                        <table id="datatable">
                            <thead>
                                <tr>
                                    <th>Edicion</th>
	                                <th>Estudiante</th>
	                                <th>Estado</th>
	                                <th>Fecha de inscripcion</th>
	                                <th>Prioridad</th>
                                </tr>
                            </thead>
                            <tbody id="detallesAceptados">
	                        
	                        </tbody>
	                        
                        </table>
                    </div>
                </div>
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
        <script src="resources/scripts/scriptTableAceptados.js"></script>
		<script src="resources/scripts/alta.js"> </script>		
		<script src="resources/scripts/listas.js"> </script>
    <%@include  file="footer.jsp" %>

                <script>

                    $(document).ready(function () {
                        tableInscripciones('${nombre}');
                        tableInscripcionesAceptados('${nombre}');
                    });

                </script>