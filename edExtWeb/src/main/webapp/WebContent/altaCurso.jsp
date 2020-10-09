<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include  file="defaultHeader.jsp" %>
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
                                    <option value="" disabled selected>Seleccione uno</option>
                                    <c:forEach var="inst" items="${institutos}">
                                        <option value="${inst}">${inst}</option>
                                    </c:forEach>

                                </select>
                                <label>Instituto</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="duracion" name="duracion" type="number" class="validate">
                                <label for="duracion">Duracion</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="cantHoras" name="cantHoras" type="number" class="validate">
                                <label for="cantHoras">Cantidad de Horas</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="creditos" name="creditos" type="number" class="validate">
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
                            <div class="input-field col s12">
                                <input id="url" type="text" name="url" class="validate">
                                <label for="url">URL</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <select multiple name="previas" id="previas">
                                    <option value="" disabled selected>Seleccionar previas</option>
                                    <c:forEach var="pre" items="${previas}">
                                        <option value="${pre}">${pre}</option>
                                    </c:forEach>
                                </select>
                                <label>Previas</label>
                            </div>
                            <div class="input-field col s6">
                                <select multiple name="categorias" id="categorias">
                                    <option value="" disabled selected>Seleccionar categorias</option>
                                    <c:forEach var="cat" items="${categorias}">
                                        <option value="${cat}">${cat}</option>
                                    </c:forEach>
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

<script>
    $(document).ready(function () {
    $('#previas').formSelect();
    $('#institutos').formSelect();
    $('#categorias').formSelect();
    });

    function crearCurso() {
        const nombre = document.querySelector("#nombre").value;
        const desc = document.querySelector("#desc").value;
        const duracion = document.querySelector("#duracion").value;
        const cantHoras =  document.querySelector("#cantHoras").value;
        const creditos =  document.querySelector("#creditos").value;
        const url =  document.querySelector("#url").value;
        const instituto =  document.querySelector("#institutos").value;
        const previas =  document.querySelector("#previas").value;
        const categorias =  document.querySelector("#categorias").value;

        console.log('canthoras: ', cantHoras);
        console.log('creditos: ', creditos);
        console.log('duracion: ', duracion);
        const fetchUrl = 'altaCurso?nombre=' + nombre +
                '&desc=' + desc +
                '&duracion=' + duracion +
                '&cantHoras=' + cantHoras +
                '&creditos=' + creditos +
                '&url=' + url +
                '&instituto=' + instituto +
                '&instituto=' + instituto +
                '&previas=' + previas +
                '&categorias=' + categorias;

        fetch(fetchUrl, {
            method: 'POST'
        }).then( ( res ) => {
            console.log(`que me devolviste papei `, res);

        }).catch((err) => {
            console.error(' paso algo: ', err); } )
    }
</script>