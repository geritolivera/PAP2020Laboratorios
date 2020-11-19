<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" href="resources/styles/style.css">

<div class="main">
    <br><br>
    <div class="container">
        <div class="row">
            <h5 class="header2"> <span style="color: #81054b">></span>Consulta de Edicion</h5>
            <div class="input-field col s12 m6">
                <div>
                    <label>Instituto</label>
                    <select name="institutos" id="institutos" >

                    </select>
                </div>
                <div>
                    <label>Cursos</label>
                    <select name="curso" id="curso">

                    </select>
                </div>
            </div>

            <!-- CARD CONSULTA EDICIONES xd-->
            <div>
                <div class="col s12 m6">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Ediciones</span>
                        </div>
                        <ul class="collection" name="ediciones" id="ediciones">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    $(document).ready(function () {
        $('#institutos').formSelect();
        $('#curso').formSelect();
    });
    $("#institutos").on("change", function() {
        obtenerCursosPorInstituto(document.querySelector("#institutos").value);
    });
    $("#curso").on("change", function() {
        collectionEdicionPorCursos(document.querySelector("#curso").value);
    });


    window.onload = function(){
    	getInstitutos();
    }

</script>
<script src="resources/scripts/listas.js"> </script>
<%@include  file="footer.jsp" %>