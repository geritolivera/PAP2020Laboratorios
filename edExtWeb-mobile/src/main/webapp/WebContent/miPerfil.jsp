<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>


<head>
    <meta charset="ISO-8859-1">
    <title>Mi Perfil</title>
    <% if (session.getAttribute("tipoUser")=="docente"){ %>
    <%@include file="defaultHeader.jsp"%>
    <%}else{ %>
    <%@include file="headerEstVis.jsp"%>
    <%}%>
    <link rel="stylesheet" href="resources/styles/style.css">
</head>

<body>
<!--GET-ATRIBUTOS USUARIO-->
<%
    //ver la imagen\
    HttpSession ses = request.getSession();
    String nickname = (String) ses.getAttribute("nickname");
    String nombre = (String) ses.getAttribute("nombre");
    String apellido = (String) ses.getAttribute("apellido");
    String correo = (String) ses.getAttribute("correo");
    String fechaNac = (String) ses.getAttribute("fechaNac");
    String[] seguidos = (String[]) ses.getAttribute("seguidos");
    String[] seguidores = (String[]) ses.getAttribute("seguidores");
    ArrayList<String> programas = (ArrayList<String>) ses.getAttribute("programas");

%>
<div class="main">
    <br><br>
    <div class="container">
        <div class="row">
            <!-- CARD USUARIO-->
            <div class="col s12 m3">
                <div class="card">
                    <div class="card-image">
                        <!-- IMAGEN DEL USUARIO-->
                        <img id="imagen" src="${imagen}">
                    </div>
                    <!-- COLLAPSIBLE USUARIO -->
                    <ul class="collapsible">
                        <li>
                            <div class="collapsible-header rosado white-text">
                                <i class="material-icons">account_circle</i>Mi Perfil
                            </div>
                            <div class="collapsible-body">
                                <p><a href="modificarDatosUsuario.jsp" type="button"
                                        onclick="window.location = 'http://localhost:8080/edExtWeb/modificarDatosUsuario.jsp'">Modificar
                                        Datos</a></p>
                            </div>
                        </li>
                    </ul>
                </div>
        <div class="col s12 m9">
            <!-- TAB DE INFORMACION-->
            <div id="cardInfo" class="card">
                <div class="card-tabs">
                    <ul class="tabs tabs-fixed-width">
                        <li class="tab" class="active"><a href="#test1">Datos</a></li>
                        <li class="tab"><a href="#test2">Social</a></li>
                        <li class="tab"><a href="#test3">Ediciones</a></li>
                        <li class="tab"><a href="#test4">Programas</a></li>
                    </ul>
        </div>
        <div class="card-content " style="padding: 30px">
            <!-- DATOS USUARIO -->
            <div id="test1">
                <div class="row">
                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nickname
                    </div>
                    <div class="col s7 grey-text text-darken-4 right-align"><%=nickname%></div>
                </div>
                <div class="row">
                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                    <div class="col s7 grey-text text-darken-4 right-align"><%=nombre%></div>
                </div>
                <div class="row">
                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Apellido
                    </div>
                    <div class="col s7 grey-text text-darken-4 right-align"><%=apellido %></div>
                </div>
                <div class="row">
                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Email</div>
                    <div class="col s7 grey-text text-darken-4 right-align"><%=correo %></div>
                </div>
                <div class="row">
                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                        Nacimiento</div>
                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaNac %></div>
                </div>
            </div>
            <!-- SEGUIDORES Y SEGUIDOS -->
            <div id="test2">
                <ul class="collection with-header">
                    <li class="collection-header" name="seguidos" id="seguidos">
                        <h10>Seguidos</h10>
                        <% if(seguidos != null){ %>
                        <c:forEach var="ed" items="${seguidos}">
                    <li class="collection-item">
                        <div>${ed}<a class="secondary-content"><span class="waves-effect waves-light btn-small"
                                    style="height: 27px;"><i class="material-icons" type="button"
                                        onclick="dejarSeguirUsuario('${ed}')">delete_forever</i></span></a>
                            </c:forEach>
                            <%}else{%>
                    <li class="collection-item">No sigue a nadie aun.</li>
                    <%}%>
                            </li>
                        </ul>
                        <ul class="collection with-header">
                            <li class="collection-header" name="seguidores" id="seguidores">
                                <h10>Seguidores</h10>
                                    <% if(seguidos != null){ %>
                                <c:forEach var="ed" items="${seguidores}">
                            <li class="collection-item"><div>${ed}<a class="secondary-content"><span class="waves-effect waves-light btn-small" style="height: 27px;" ><i class="material-icons" type="button" onclick="seguirUsuario('${ed}')">person_add</i></span></a>
                                </c:forEach>
                                    <%}else{%>
                            <li class="collection-item">No sigue a nadie aun.</li>
                            <%}%>
                            </li>


                        </ul>

                    </div>
                    <!--GET-EDICIONES-->
                    <div id="test3">
                        <div class="row">
                            <div class="input-field col s12">
                                <select id="edicionesNombres" name="edicionesNombres" onchange="getDatosEdicion(edicionesNombres.value)" >
                                    <option value="" selected disabled>Seleccionar una edicion</option>
                                    <c:forEach var="ed" items="${edicionesNombres}">
                                        <option value="${ed}">${ed}</option>
                                    </c:forEach>
                                </select>
                                <label>Inscripciones a Ediciones de Cursos</label>
                            </div>
                        </div>
                        <div class="row">
                            <!--imagen del programa-->
                            <div class="col s12 m7" style="width: 100%">
                                <div class="card" id="infoSelecEdi"></div>
                            </div>
                        </div>
                    </div>

                    <!--GET- PROGRAMAS DE FORMACION-->
                    <div id="test4">
                        <div class="row">
                            <div class="input-field col s12">
                                <!--GET-PROGRAMAS-->
                                <select id="programasNombre" name="programasNombre" onchange="getDatosPrograma(programasNombre.value)">
                                    <% programas = (ArrayList<String>) ses.getAttribute("programasNombre");
                                        if(programas != null){ %>
                                    <option value="" disabled selected>Seleccionar un programa</option>
                                    <c:forEach var="pro" items="${programasNombre}">
                                        <option value="${pro}">${pro}</option>
                                    </c:forEach>
                                    <%}else{%>
                                    <option value="" disabled selected>No hay inscripciones a programas</option>
                                    <%}%>
                                </select>
                                <label>Inscripciones a Programas de Formacion</label>
                            </div>
                        </div>
                        <div class="row">
                            <!--imagen del programa-->
                            <div class="col s12 m7" style="width: 100%">
                                <div class="card" id="infoSelectedProg"></div>
                            </div>
                        </div>

                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<%@ include file="footer.jsp" %>



<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.collapsible');
        var instances = M.Collapsible.init(elems);
    });
</script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems);
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.tabs').tabs();
    });
</script>
<script>
    function getDatosPrograma(nombre) {
        var baseURL = 'http://localhost:8081/edExtWeb/';

        var url = baseURL + `GetDatosPrograma?nombre=` + nombre;

        fetch(url)
            .then((res) => {
                return res.json();
            }).then((progSelected) => {
                var progHtml = document.getElementById("infoSelectedProg");
                console.log(progSelected)

                JSON.stringify(progSelected);


                var fechaInicio = new Date(progSelected.fechaI).toLocaleDateString();
                var fechaFin = new Date(progSelected.fechaF).toLocaleDateString();
                var fechaAlta = new Date(progSelected.fechaA).toLocaleDateString();

                progHtml.innerHTML = `<div class="card-image">
                                        <img src="`+ progSelected.imagenURL + `" width="702.281" height="345.953">
                                        <span class="card-title">`+ progSelected.nombre + `</span>
                                      </div>`;
                progHtml.innerHTML += `<div class="card-content">`;
                progHtml.innerHTML += `<div class="row">`;
                progHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Descripcion</div>`;
                progHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + progSelected.descripcion + `</div>`;
                progHtml.innerHTML += `</div>`;
                progHtml.innerHTML += `<div class="row">`;
                progHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Inicio</div>`;
                progHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + fechaInicio + `</div>`;
                progHtml.innerHTML += `</div>`;
                progHtml.innerHTML += `<div class="row">`;
                progHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin</div>`;
                progHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + fechaFin + `</div>`;
                progHtml.innerHTML += `</div>`;
                progHtml.innerHTML += `<div class="row">`;
                progHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Alta</div>`;
                progHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + fechaAlta + `</div>`;
                progHtml.innerHTML += `</div>`;
                progHtml.innerHTML += `<div class="card-action">
                                                <a href="consultaProgramaFormacion?programa=`+ progSelected.nombre + `">Ir al programa</a>
                                         </div>`

            })
    }
</script>
<script>
    function getDatosEdicion(nombre) {
        var baseURL = 'http://localhost:8081/edExtWeb/';

        var url = baseURL + `GetDatosEdicion?nombre=` + nombre;

        fetch(url)
            .then((res) => {
                return res.json();
            }).then((ediSelected) => {
                var edicionHtml = document.getElementById("infoSelecEdi");
                console.log(ediSelected)


                JSON.stringify(ediSelected);

                var fechaInicio = new Date(ediSelected.fechaI).toLocaleDateString();
                var fechaFin = new Date(ediSelected.fechaF).toLocaleDateString();
                var fechaPublic = new Date(ediSelected.fechaPub).toLocaleDateString();

                edicionHtml.innerHTML = `<div class="card-image">
                                                <img src="`+ ediSelected.imagenURL + `" width="702.281" height="345.953">
                                          </div>`;
                edicionHtml.innerHTML += `<div class="card-content">
                                             <div class="row">`;
                edicionHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>`;
                edicionHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + ediSelected.nombre + `</div>`;
                edicionHtml.innerHTML += `</div>`;
                edicionHtml.innerHTML += `<div class="row">`;
                edicionHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Descripcion</div>`;
                edicionHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + fechaInicio + `</div>`;
                edicionHtml.innerHTML += `</div>`;
                edicionHtml.innerHTML += `<div class="row">`;
                edicionHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de inicio</div>`;
                edicionHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + fechaFin + `</div>`;
                edicionHtml.innerHTML += `</div>`;
                edicionHtml.innerHTML += `<div class="row">`;
                edicionHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de publicacion</div>`;
                edicionHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + fechaPublic + `</div>`;
                edicionHtml.innerHTML += `</div>`;
                edicionHtml.innerHTML += `<div class="row">`;
                edicionHtml.innerHTML += `<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de alta</div>`;
                edicionHtml.innerHTML += `<div class="col s7 grey-text text-darken-4 right-align">` + ediSelected.cupo + `</div>`;
                edicionHtml.innerHTML += `</div>`;
                edicionHtml.innerHTML += `<div class="row">
                                                    <div class="card-action">
                                                    <a href="consultaEdicionCurso?edicion=`+ ediSelected.nombre + `">Ir a la Edicion</a>
                                                </div>
                                           </div></div>`

            })
    }
</script>
<script type="text/javascript">

    $(document).ready(function () {
        collectionSeguidores();
        collectionSeguidos();
    });

</script>

<script src="resources/scripts/alta.js"> </script>
<script src="resources/scripts/listas.js"> </script>