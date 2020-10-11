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
                            <img src="images/asd.jpg">
                            <span class="card-title" id="tituloPrograma">Programa</span>
                            <a class="btn-floating halfway-fab waves-effect waves-light rojo"><i
                                    class="material-icons">add</i></a>
                        </div>
                        <div class="card-content">
                            <p id="desc">I am a very simple card. I am good at containing small bits of information. I am
                                convenient because I require little markup to use effectively.</p>

                        </div>
                        <ul id="dataPrograma" class="collection">
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>
                                        Fecha Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">01/12/2010</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">01/01/2021</div>
                                </div>
                            </li>
                           
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Categorias</span>
                        </div>
                        <ul class="collection">
                        	<%
							 ArrayList<String> cats = (java.util.ArrayList)request.getAttribute("categorias");
							 for (String s : cats)
							 { 
								out.print("<li class='collection-item'>>"+s+"</li>");
							 }
							%>
                        </ul>
                    </div>

                </div>
                <div class="col s12 m5">
                    <div class="card verde">
                        <div class="card-content white-text">
                            <span class="card-title">Cursos</span>
                        </div>
                        <div class="collection">
                            <a href="#!" class="collection-item">P1</a>
                            <a href="#!" class="collection-item ">P2</a>
                            <a href="#!" class="collection-item">P3</a>
                            <a href="#!" class="collection-item">Logica</a>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
 <%@ include file="footer.jsp" %>

