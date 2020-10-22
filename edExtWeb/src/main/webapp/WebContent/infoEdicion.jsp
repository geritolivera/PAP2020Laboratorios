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
	                        	if(userLog && tipoUser.equals("estudiante") && vigencia.equals("Si")){
	                        		Boolean inscripto = (Boolean) request.getAttribute("inscripto");
	                        		if(!inscripto){
                            %>
                            <div class="card-action right-align">
	                            <a id="ediBTN" class="waves-effect waves-light btn" type="button" onclick="inscribirUsuario('${nombre}')" <%--href="inscripcionUE?edicion=${nombre}"--%>><i
	                                    class="material-icons"></i>Inscribirse</a>
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
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Docentes</span>
                        </div>
                        <div class="collection" name="docentes" id="docentes">
                            <c:forEach var="docs" items="${docentes}">
                            <a href="" class="collection-item">${docs}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <% if(userLog && tipoUser.equals("docente")&& vigencia.equals("Si")){ %>
               <div class="row center">
	            <button onclick="toggleEstudiantes()" class="btn pink darken-4">Agregar Estudiantes +</button>
            	</div>
                <%}%>
            </div>
            
            <div class="row" style="display: none;" id="containerEstudiantes">
            <div id="admin" class="col s12">
                <div class="card material-table">
                    <div class="table-header">
                        <span class="table-title">Seleccionar Estudiantes</span>
                        <div class="actions">
                            <a href="#" class="search-toggle btn-flat nopadding"><i
                                    class="material-icons prefix">search</i></a>
                        </div>
                    </div>
                    <table id="datatable">
                        <thead>
                            <tr>
                                <th></th>
                                <th>NickName</th>
                                <th>Estudiante</th>
                                <th>Estado</th>
                                <th>Fecha de inscripcion</th>
                                <th>Prioridad</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td>jPerez</td>
                                <td>Julian Perez</td>
                                <td>Aceptado</td>
                                <td>2011/04/25</td>
                                <th>0.5</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td>mmartinez</td>
                                <td>Martin Martinez</td>
                                <td>Rechazado</td>
                                <td>2020/08/25</td>
                                <th>0.0</th>
                            </tr>
                            <tr>
                                <td></td>
                                <td>mgutierrez</td>
                                <td>Marta Gutierrez</td>
                                <td>Rechazado</td>
                                <td>2020/08/25</td>
                                <td>0.5</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>dmaradona</td>
                                <td>Diego Maradona</td>
                                <td>En espera</td>
                                <td>2020/08/25</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>lmessi</td>
                                <td>Lionel Messi</td>
                                <td>Aceptado</td>
                                <td>2020/08/25</td>
                                <td>0.7</td>
                            </tr>
                        </tbody>
                    </table>
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
        <script src="resources/scripts/scriptTable2.js"></script>
		<script src="resources/scripts/alta.js"> </script>		
    <%@include  file="footer.jsp" %>