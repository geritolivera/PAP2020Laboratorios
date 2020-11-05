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
                <h4 class="header2"> <span style="color: #81054b">></span>Seleccione uno de los programas...</h4>
	            <!-- CARD CONSULTA PROGRAMA-->
                <div>
					<div class="col s12">
	                    <div class="card teal darken-4">
	                        <div class="card-content white-text">
	                            <span class="card-title">Programas Formacion</span>
	                        </div>
	                        <ul class="collection" name="programa" id="programa">
	                        </ul>
	                    </div>
	                </div>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">

	window.onload = function(){
		collectionProgramas();		
	}
	
</script>
    
   <script src="resources/scripts/listas.js"> </script>
    <%@include  file="footer.jsp" %>
   