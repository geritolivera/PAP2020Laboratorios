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
            <select name="listaUsuarios" id="listaUsuarios" onchange="listaEdicionesUsuarioEstudiante(listaUsuarios.value);obtenerDatosUsuario(listaUsuarios.value)">
                <option value="" disabled>Seleccionar un usuario</option>
            </select>
            <label>Lista de usuarios</label>
            <div class="col s12 m7">
                <div class="card">
                    <div class="card-image">
                        <img src="resources/images/asd.jpg">
                        <span class="card-title" id="nicknameSelected"></span>
                        <a class="btn-floating halfway-fab waves-effect waves-light rojo"><i
                                class="material-icons">person_add</i></a>
                    </div>
                    <div class="card-content">
                        <p id="descripcion"></p>
                    </div>
                    <ul id="detallesUE" class="collection">
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>Nickname</div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="nicknamee"></div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Nombre
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="nombree"></div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Apellido
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="apellidoe"></div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Correo
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="correoe"></div>
                            </div>
                        </li>
                        <li class="collection-item">
                            <div class="row">
                                <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Fecha de
                                    Nacimiento
                                </div>
                                <div class="col s7 grey-text text-darken-4 right-align" id="fechaNace"></div>
                            </div>
                        </li>

                    </ul>
                </div>
            </div>
            <div class="col s12 m5">
                <div class="card teal darken-4">
                    <div class="card-content white-text">
                        <span class="card-title">Ediciones</span>
                    </div>
                    <ul class="collection" name="edicionese" id="edicionese">
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
                            <li class="collection-item">
                                <div>${prog}<a href="consultaProgramaFormacion?programa=${prog}"
                                        class="secondary-content"><i class="material-icons">send</i></a></div>
                            </li>
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
                            <li class="collection-item">
                                <div><a href="" class="secondary-content"><i class="material-icons">send</i></a></div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col s12 m5">
                <div class="card teal darken-4">
                    <div class="card-content white-text">
                        <span class="card-title">Seguidores</span>
                    </div>
                    <ul class="collection" name="seguidores" id="seguidores">
                        <c:forEach var="seguidor" items="${seguidores}">
                            <li class="collection-item">
                                <div><a href="" class="secondary-content"><i class="material-icons">send</i></a></div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
<%@include  file="footer.jsp" %>

<script>
    $(document).ready(function () {
        $('#listaUsuarios').formSelect();
    });
    
    window.onload = function(){
    	getUsuarios();
    }
</script>

<script src="resources/scripts/listas.js"> </script>
</body>

</html>