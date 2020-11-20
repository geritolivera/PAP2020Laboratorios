<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main">
    <br><br>

    <div class="container">
        <!-- FORM-->
        <div class="row">
            <form class="col s12 ">
                <div class="card-panel">
                    <h5 class="header2"> <span style="color: #81054b">></span>Alta de Edicion</h5>

                    <div class="row">
                        <div class="input-field col s12 m6" >
                            <select name="institutos" id="institutos" >

                            </select>
                            <label>Instituto</label>
                        </div>

                        <div class="input-field col s12 m6">
                            <select name="curso" id="curso">

                            </select>
                            <label>Curso</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <input type="text" name="nombre" id="nombre">
                            <label for="nombre">Nombre de la Edicion</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <select multiple name="docentes" id="docentes">

                            </select>
                            <label>Docentes</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field s12 m6 col">
                            <i class="material-icons prefix">date_range</i>
                            <input type="text" name="fechaInicio" id="fechaInicio" class="datepicker">
                            <label for="fechaInicio">Fecha de Inicio</label>
                        </div>
                        <div class="input-field s12 m6 col">
                            <i class="material-icons prefix">date_range</i>
                            <input type="text" name="fechaFin" id="fechaFin" class="datepicker">
                            <label for="fechaFin">Fecha de Fin</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12 m6">
                            <i class="material-icons prefix">access_time</i>
                            <input id="cupo" name="cupo" type="number" class="validate" value = "0">
                            <label for="cupo">Cupo(opcional)</label>
                        </div>
                        <div class="input-field col s12 m6">
                            <i class="material-icons prefix">image</i>
                            <input type="text" id="url">
                            <label for="url">Imagen de la edicion</label>
                        </div>

                    </div>
                    <div class="center-align">
                        <button class="btn waves-effect waves-light rojo" type="button" name="action" onclick="crearEdicion()">Crear
                            <i class="material-icons right">send</i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include  file="footer.jsp" %>
<script src="resources/scripts/listas.js"> </script>
<script src="resources/scripts/listas.js"> </script>
<script>
    $(document).ready(function () {
        getInstitutos();
        $('.datepicker').datepicker();
        $('#institutos').formSelect();
        $('#curso').formSelect();
        $('#docentes').formSelect();
    });
    $("#institutos").change( function() {
        obtenerCursosPorInstituto(document.querySelector("#institutos").value);
    });
    $('#url').change(function (){
        document.getElementById('download')
        var link = document.createElement('a');
        link.href = document.querySelector("#url").value;
        link.download = document.querySelector("#url").value;
        document.body.appendChild(link);
        document.body.removeChild(link);
    });
</script>
