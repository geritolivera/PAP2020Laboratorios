<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include  file="defaultHeader.jsp" %>
    <div class="main">
        <br><br>

        <div class="container">

            <div class="row">
                <!-- CARD PROGRAMA-->
                <div class="col s12 m7">
                    <div class="card">
                        <div class="card-image">
                            <img src="images/asd.jpg">
                            <span class="card-title" id="tituloPrograma">Nombre Edicion</span>
                            <!-- -Aca se pone el a si es vigente -->
                            <a class="btn-floating halfway-fab waves-effect waves-light rojo" href="linkInscripcion"><i
                                    class="material-icons">add</i></a>
                        </div>
                        <ul id="dataPrograma" class="collection">
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha Publicacion
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">01/01/2021</div>
                                </div>
                            </li>
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">200</div>
                                </div>
                            </li>
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
                            <li class="collection-item">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-help_outline"></i> Vigente
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">Si</div>
                                </div>
                            </li>
                            
                        </ul>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card teal darken-4">
                        <div class="card-content white-text">
                            <span class="card-title">Docentes</span>
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
    </div>
    
    <%@include  file="footer.jsp" %>