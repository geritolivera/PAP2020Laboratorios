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
                            <img src="resources/images/asd.jpg">
                            <span class="card-title" id="tituloPrograma">${tituloPrograma}</span>
                            <%
                                String tipoUser = (String) session.getAttribute("tipoUser");
                            	Boolean inscripto = (Boolean) request.getAttribute("inscripto");
                                if(tipoUser != null && tipoUser.equals("estudiante")){
                                	if(!inscripto){
                            %>
                            <div class="card-action right-align">
                            	<a class="waves-effect waves-light btn" type="button" onclick="inscribirUsuarioProg('${tituloPrograma}')"><i
                                    class="material-icons"></i>Inscribirse</a>
                            </div>
                            	<%}else{%>
                            <div class="card-action right-align">
                            	<a class="btn disabled">Inscripto</a>
                            </div>
                            	<%}
							}%>
                        </div>
                        <div class="card-content">

                            <p id="desc">${desc}</p>

                        </div>
                        <ul id="dataPrograma" class="collection">
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>
                                        Fecha Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="fechaInicio">${fechaInicio}</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Fecha Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="fechaFin">${fechaFin}</div>
                                </div>
                            </li>
                           
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Categorias</span>
                        </div>
                        <ul class="collection" name="categoriass" id="categoriass">
                                <c:forEach var="cat" items="${categoriass}">
                                    <a href="" class="collection-item">${cat}</a>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Cursos</span>
                        </div>
                        <ul class="collection" name="cursos" id="cursos">
                                <c:forEach var="cur" items="${cursos}">
                                    <li class="collection-item"><div>${cur}<a href="consultaCurso?curso=${cur}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
                <%
                	tipoUser = (String) session.getAttribute("tipoUser");
                	if(tipoUser != null && tipoUser.equals("docente")){
                %>
                <div class="col s12 m5">
                	<div class="card teal darken-4">
                		<div class="card-content white-text">
                            <span class="card-title">Agregar Cursos</span>
                        </div>
                	</div>
	                	<select name="cursosagregar" id="cursosagregar" onchange="agregarCursoPrograma(cursosagregar.value, '${tituloPrograma}')">
	                    	<option value="" disabled >Seleccione uno</option>
	                	</select>
                </div>
                <%} %>
            </div>

        </div>
    </div>
    </div>

<script type="text/javascript">

	$(document).ready(function () {
	    $('#cursosagregar').formSelect();
	 });

	window.onload = function(){
		getCursos();
    }

</script>
<script src="resources/scripts/listas.js"> </script>
<script src="resources/scripts/alta.js"> </script>
 <%@ include file="footer.jsp" %>
