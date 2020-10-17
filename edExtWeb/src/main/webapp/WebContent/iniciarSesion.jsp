<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>

	<div class="main">
        <br><br>
        <br><br>
        <br><br>
		<div class="container center" >
            	<!-- FORM-->
            	<div class="row">
                	<form class="col s12 center-align" method="POST" action="login">
                    	<div class="card-panel s12 m12">
                        	<h4 class="header2 center-align"> <span style="color: #81054b">></span>Iniciar Sesion</h4>
                        	<div class="row">
                            	<div class="input-field col s12 center-align">
                            		<i class="material-icons prefix">account_box</i>
                                	<input class='validate' type="text" name='nickname' id='nickname' required />
                					<label for='nickname'>Nickname</label>
                            	</div>
                        	</div>
                        	<div class="row">
                            	<div class="input-field col s12 center-align">
                             		<i class="material-icons prefix">lock_outline</i>
                                	<input class='validate' type='password' name='password' id='password' required />
                					<label for='password'>Contraseña</label>
                            	</div>
                            </div>
                            <div class="row">
                        		<div class="center-align">
                            		<button class="btn waves-effect waves-light rojo" type="submit" name="action">Iniciar Sesion
                            		</button>
                        		</div>
                       		</div>
                    	</div>
                	</form>
 				</div>
		</div>
       </div>
       
<%@include  file="footer.jsp" %>