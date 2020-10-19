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
                	<form class="col s12 left-align">
                    	<div class="card-panel">
                        	<h5 class="header2 center-align"> <span style="color: #81054b">></span>Tu sesion ha sido cerrada con exito</h5>
                        	<div class="row">
                            	<h6 class="header2 center-align"> <span style="color: #81054b"></span>Gracias por pasar tiempo de calidad con nuestra pagina web. Te esperamos de vuelta! <3 </h6>
                        	</div>
                    	</div>
                    	<div class="right-align">
                        	<a href="index.jsp" class="btn waves-effect waves-light rojo">Menu</a>
                        </div>
                	</form>
 				</div>            
 			</div>
       </div>
 
 <%@include  file="footer.jsp" %>
 <script>
 	
 </script>
 