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
                            <a class="btn-floating halfway-fab waves-effect waves-light rojo"><i
                                    class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                            <p id="desc"></p>

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
                        <ul class="collection" name="categorias" id="categorias">
                                <c:forEach var="cat" items="${categorias}">
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
                        <div class="collection" name="cursos" id="cursos">
                            <c:forEach var="cur" items="${cursos}">
                            <a href="" class="collection-item">${cur}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    </div>
 <%@ include file="footer.jsp" %>
