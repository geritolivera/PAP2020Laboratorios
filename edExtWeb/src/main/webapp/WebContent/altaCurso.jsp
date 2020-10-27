<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.PrintWriter" %>


<div class="main">
    <br><br>
    <div class="container">
        <!-- FORM-->
        <div class="row">
            <form class="col s12" > <%-- action="altaCurso" method="post">--%>
                <div class="card-panel">
                    <h4 class="header2"> <span style="color: #81054b">></span>Alta de Curso</h4>
                    <div class="row">
                        <div class="input-field col s6">
                            <input type="text" name="nombre" id="nombre">
                            <label for="nombre">Nombre de Curso</label>
                        </div>

                        <div class="input-field col s6">
                            <select name="instituto" id="institutos">
                            </select>
                            <label>Instituto</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s4">
                            <input id="duracion" name="duracion" type="number" class="validate" value="0">
                            <label for="duracion">Duracion</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="cantHoras" name="cantHoras" type="number" class="validate" value="0">
                            <label for="cantHoras">Cantidad de Horas</label>
                        </div>
                        <div class="input-field col s4">
                            <input id="creditos" name="creditos" type="number" class="validate" value="0">
                            <label for="creditos">Creditos</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <textarea id="desc" name="desc" class="materialize-textarea"></textarea>
                            <label for="desc">Descripcion</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input id="url" type="text" name="url" class="validate">
                            <label for="url">URL</label>
                        </div>
                        <div class="input-field col s6">
                            <i class="material-icons prefix">image</i>
                            <input type="text" id="imagen">
                            <label for="imagen">Imagen del curso</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <select multiple name="previas" id="previas">
                            </select>
                            <label>Previas</label>
                        </div>
                        <div class="input-field col s6">
                            <select multiple name="categorias" id="categorias">
                            </select>
                            <label>Categorias</label>
                        </div>
                    </div>
                    <div class="center-align">
                        <button class="btn waves-effect waves-light rojo" type="button" onclick="crearCurso()" >Crear
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
<script src="resources/scripts/alta.js"> </script>
<script>
    $(document).ready(function () {
        getPreviasAlta();
        getInstitutosAlta();
        getCategoriasAlta();

    });
    $('#imagen').change(function (){
        document.getElementById('download')
        var link = document.createElement('a');
        link.href = document.querySelector("#imagen").value;
        link.download = document.querySelector("#imagen").value;
        document.body.appendChild(link);
        document.body.removeChild(link);
    });

</script>
