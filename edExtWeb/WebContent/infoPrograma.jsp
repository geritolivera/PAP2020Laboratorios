<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="defaultHeader.jsp"%>
<%@page import="java.util.ArrayList"%>

    <div class="main">
        <br><br>

        <div class="container">
            <div class="row">
                <!-- CARD PROGRAMA-->
                <div class="col s12 m7">
                    <div class="card">
                        <div class="card-image">
                        	<%
                        		String nombre = (String) request.getAttribute("nombre");
                        	%>
                            <img src="images/asd.jpg">
                            <span class="card-title" id="tituloPrograma"><%=nombre%></span>
                            <a class="btn-floating halfway-fab waves-effect waves-light rojo"><i
                                    class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                        	<%
								String descripcion = (String) request.getAttribute("descripcion");
								out.print("<p>" + descripcion + "</p>");
							%>
                        </div>
                        <ul id="dataPrograma" class="collection">
                            <li class="collection-item">
                                <div class="row">
                                <%
                                	String fechaInicio = (String) request.getAttribute("fechaI");
                                %>
                                    <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>
                                        Fecha Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaInicio%></div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                <%
                                	String fechaFin = (String) request.getAttribute("fechaF");
                                %>
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaFin%></div>
                                </div>
                            </li>
                           
                        </ul>
                    </div>
                </div>
                <%
					ArrayList<String> cats = (java.util.ArrayList)request.getAttribute("categorias");
					if(cats.size()>0){
				%>
	                <div class="col s12 m5">
	                    <div class="card teal darken-4">
	                        <div class="card-content white-text">
	                            <span class="card-title">Categorias</span>
	                        </div>
	                        <ul class="collection">
	                        	<%
								 for (String s : cats){ 
									out.print("<li class='collection-item'>>"+s+"</li>");
								 }
								%>
	                        </ul>
	                    </div>
	
	                </div>
                <%}%>
                <%
                	ArrayList<String> cursos = (java.util.ArrayList) request.getAttribute("cursos");
                	if(cursos.size()>0){
                %>
	                <div class="col s12 m5">
	                    <div class="card verde">
	                        <div class="card-content white-text">
	                            <span class="card-title">Cursos</span>
	                        </div>
	                        <div class="collection">
	                            <%
	                            	for(String s: cursos){
	                            		out.print("<li class='collection-item'>>"+s+"</li>");
	                            	}
	                            %>
	                        </div>
	                    </div>
	                </div>
                <%}%>
            </div>

        </div>
    </div>
    </div>
 <%@ include file="footer.jsp" %>

