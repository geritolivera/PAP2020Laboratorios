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



    <div class="container" id="estudiante">
        <div class="row">
            <!-- CARD USUARIO ESTUDIANTE-->
            <div class="col s12 m5">
                <div class="card">
                    <div class="card-image">
                        <img src="${imagenURL}">
                        <span class="card-title" id="nicknameSelected"></span>
                        <%
                            Boolean userLog = (Boolean) request.getAttribute("userLog");
                            if(userLog){
                                Boolean igualdad = (Boolean) request.getAttribute("igualdad");
                                if(!igualdad){
                                    Boolean yaSeguido = (Boolean) request.getAttribute("yaSeguido");
                                    if(!yaSeguido){
                        %>
                        <div class="card-action right-align">
                            <a class="waves-effect waves-light btn" type="button" onclick="seguirUsuario('${nickname}')"><i
                                    class="material-icons"></i>Seguir</a>
                        </div>
                        <%}else{%>
                        <div class="card-action right-align">
                            <a class="waves-effect waves-light btn" type="button" onclick="dejarSeguirUsuario('${nickname}')"><i
                                    class="material-icons"></i>Dejar de seguir</a>
                        </div>
                        <%}
                        }
                        }%>
                    </div>
                </div>
                <div class="card-content">
                    <p id="descripcion"></p>
                </div>
                <ul id="dataUsuario" class="collection">
                    <li class="collection-item">
                        <div class="row">
                            <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>Nickname</div>
                            <div class="col s7 grey-text text-darken-4 right-align" id="nicknamee">${nickname}</div>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div class="row">
                            <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Nombre
                            </div>
                            <div class="col s7 grey-text text-darken-4 right-align" id="nombre">${nombre}</div>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div class="row">
                            <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Apellido
                            </div>
                            <div class="col s7 grey-text text-darken-4 right-align" id="apellido">${apellido}</div>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div class="row">
                            <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Correo
                            </div>
                            <div class="col s7 grey-text text-darken-4 right-align" id="correo">${correo}</div>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div class="row">
                            <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Fecha de
                                Nacimiento
                            </div>
                            <div class="col s7 grey-text text-darken-4 right-align" id="fechaNac">${fechaNac}</div>
                        </div>
                    </li>

                </ul>
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
        <%
            String tipo = (String) request.getAttribute("tipo");
            if(tipo.equals("estudiante")){
        %>
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
        <%}%>
            <div class="col s12 m5">
            <div class="card teal darken-4">
                <div class="card-content white-text">
                    <span class="card-title">Seguidores</span>
                </div>
                <ul class="collection" name="seguidores" id="seguidores">
                    <c:forEach var="seguidor" items="${seguidores}">
                        <li class="collection-item"><div>${seguidor}<a href="consultaUsuario?nickname=${seguidor}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                    </c:forEach>
                </ul>
            </div>
        </div>

            <div class="col s12 m5">
            <div class="card teal darken-4">
                <div class="card-content white-text">
                    <span class="card-title">Seguidos</span>
                </div>
                <ul class="collection" name="seguidos" id="seguidos">
                    <c:forEach var="seguido" items="${seguidos}">
                        <li class="collection-item"><div>${seguido}<a href="consultaUsuario?nickname=${seguido}" class="secondary-content"><i class="material-icons">send</i></a></div></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        </div>
    </div>

</div>
<%@include  file="footer.jsp" %>
<script src="resources/scripts/alta.js"> </script>
