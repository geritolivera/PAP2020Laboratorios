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
                            <img src="${imagenURL}" width="702.281" height="345.953">
                            <span class="card-title" id="nombre">${nombre}</span>
                        </div>
                        <div class="card-content">
                            <p id="descripcion">${descripcion}</p>
                        </div>
                        <ul id="dataCurso" class="collection">
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>Duracion</div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="duracion">${duracion}</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Cantidad de Horas
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="cantHoras">${cantHoras}</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Creditos
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="creditos">${creditos}</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Fecha de Registro 
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="fechaR">${fechaR}</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>URL
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="url">${url}</div>
                                </div>
                            </li>

                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Previas</span>
                        </div>
                        <ul class="collection" name="previas" id="previas">
                            <c:forEach var="pre" items="${previas}">
                                <li class="collection-item"><div>${pre}<a href="consultaCurso?curso=${pre}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Categorias</span>
                        </div>
                        <ul class="collection" name="categorias" id="categorias">
                            <c:forEach var="pre" items="${categorias}">
                                <li class="collection-item"><div>${pre}</div></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Ediciones</span>
                        </div>
                        <ul class="collection" name="ediciones" id="ediciones">
                                <c:forEach var="edi" items="${ediciones}">
                                    <li class="collection-item"><div>${edi}<a href="consultaEdicionCurso?edicion=${edi}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Programas</span>
                        </div>
                        <ul class="collection" name="programas" id="programas">
                                <c:forEach var="prog" items="${programas}">
                                    <li class="collection-item"><div>${prog}<a href="consultaProgramaFormacion?programa=${prog}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                                </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include  file="footer.jsp" %>