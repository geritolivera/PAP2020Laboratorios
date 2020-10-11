<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include  file="defaultHeader.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <div class="main">
        <br><br>

        <div class="container">
            <!-- FORM-->
            <div class="row">
                 <form class="col s12 ">
                    <div class="card-panel">
                        <h4 class="header2"> <span style="color: #81054b">></span>Alta de Edicion</h4>

                        <div class="row">
                            <div class="input-field col s6">
                                <select name="instituto" id="instituto" onchange="obtenerCursosPorInstituto(instituto.value);obtenerDocentesPorInstituto(instituto.value)" >
                                    <option value="" disabled selected>Seleccione uno</option>
                                    <c:forEach var="inst" items="${institutos}">
                                        <option value="${inst}">${inst}</option>
                                    </c:forEach>
                                </select>
                                <label>Instituto</label>
                            </div>

                            <div class="input-field col s6">
                                <select name="curso" id="curso">
                                    <option value="" disabled selected>Seleccione uno</option>
                                </select>
                                <label>Curso</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="nombre" id="nombre">
                                <label for="nombre">Nombre de la Edicion</label>
                            </div>
                            <div class="input-field col s6">
                                <select multiple name="docentes" id="docentes">
                                    <option value="" disabled selected>Seleccionar docentes</option>
                                </select>
                                <label>Docentes</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field s6 col">
                                <i class="material-icons prefix">date_range</i>
                                <input type="text" name="fechaInicio" id="fechaInicio" class="datepicker">
                                <label for="fechaInicio">Fecha de Inicio</label>
                            </div>
                            <div class="input-field s6 col">
                                <i class="material-icons prefix">date_range</i>
                                <input type="text" name="fechaFin" id="fechaFin" class="datepicker">
                                <label for="fechaFin">Fecha de Fin</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s4">
                                <i class="material-icons prefix">access_time</i>
                                <input id="cupo" name="cupo" type="number" class="validate">
                                <label for="cupo">Cupo(opcional)</label>
                            </div>
                        </div>
                        <div class="center-align">
                            <button class="btn waves-effect waves-light rojo" type="submit" name="action" onclick="crearEdicion()">Crear
                                <i class="material-icons right">send</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
 <%@include  file="footer.jsp" %>
 <script>
	$(document).ready(function () {
    	$('.datepicker').datepicker();
        $('#instituto').formSelect();
        $('#curso').formSelect();
        $('#docentes').formSelect();
     });

    function crearEdicion() {
        const nombre = document.querySelector("#nombre").value;
        const fechaI = document.querySelector("#fechaInicio").value;
        f1 = new Date(fechaI);
        const fechaF = document.querySelector("#fechaFin").value;
        f2 = new Date(fechaF);
        const instituto = document.querySelector("#instituto").value;
        const cursos = document.querySelector("#curso").value;
        const docentes = document.querySelector("#docentes").value;
        const cupo = document.querySelector("#cupo").value;

        const fetchUrl = 'altaEdicion?nombre=' + nombre +
            '&fechaI=' + f1 +
            '&fechaF=' + f2 +
            '&instituto=' + instituto +
            '&cursos=' + cursos +
            '&docentes=' + docentes +
            '&cupo=' + cupo;

        fetch(fetchUrl, {
            method: 'POST'
        }).then((res) => {
            console.log(`que me devolviste papei `, res);

        }).catch((err) => {
            console.error(' paso algo: ', err);
        });
    }
 </script>