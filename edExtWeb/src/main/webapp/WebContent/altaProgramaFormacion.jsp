<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
  <div class="main">
        <br><br>

        <div class="container">
            <!-- FORM-->
            <div class="row">
                <form class="col s12 ">
                    <div class="card-panel">
                        <h4 class="header2"> <span style="color: #81054b">></span>Alta de Programa de Formacion</h4>

                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="nombre" id="nombre">
                                <label for="nombre">Nombre del Programa</label>
                            </div>
                            <div class="input-field col s6">
                                <i class="material-icons prefix">image</i>
                                <input type="text" id="url">
                                <label for="url">Imagen del programa</label>
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
                            <div class="input-field col s12">
                                <i class="material-icons prefix">description</i>
                                <textarea id="desc" name="desc" class="materialize-textarea"></textarea>
                                <label for="desc">Descripcion</label>
                            </div>
                        </div>
                        <div class="center-align">
                            <button class="btn waves-effect waves-light rojo" type="button" onclick="crearPrograma()">Crear
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
<script src="resources/scripts/alta.js"> </script>
