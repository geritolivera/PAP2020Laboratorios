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
                            	//String tipoUser = (String) session.getAttribute("tipoUser");
                            	String tipoUser = "estudiante";
                            	if(tipoUser != null && tipoUser.equals("estudiante")){                            
                            %>
                            <a id="ediBTN" class="btn-floating halfway-fab waves-effect waves-light rojo" type="button" onclick="inscribirUsuario('${nombre}')" <%--href="inscripcionUE?edicion=${nombre}"--%>><i
                                    class="material-icons">add</i></a>
							<%}%>
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
                                    <div class="col s7 grey-text text-darken-4 right-align">Si</div>
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
            </div>
        </div>
    </div>
<script src="resources/scripts/alta.js"> </script>
    <%@include  file="footer.jsp" %>