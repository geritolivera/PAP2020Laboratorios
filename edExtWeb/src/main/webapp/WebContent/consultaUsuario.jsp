<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Consulta de Usuario</title>
    <%@include file="defaultHeader.jsp" %>
</head>

<body>
    <!--GET-ATRIBUTOS USUARIO-->
    <%
      //ver la imagen
      String nickname = (String) request.getAttribute("nickname");
      String nombre = (String) request.getAttribute("nombre");
      String apellido = (String) request.getAttribute("apellido");
      String correo = (String) request.getAttribute("correo");
      String fechaNac = (String) request.getAttribute("fechaNac");
  	  //String tipo = (String) request.getAttribute("tipo");                          	
     String tipo = "docente";
     %>
    <div class="main">
        <br><br>
        <div class="container">
            <div class="row">
                <!-- CARD USUARIO-->
                <div class="col s12 m3">
					<div class="card">
                            <div class="card-image">
                                <img src="images/img1.jpg">
                                <span class="card-title">Usuarios</span>
                            </div>
                            <div class="card-content">
                                <p>Aqui puedes encontrar la informacion de todos los usuarios.</p>
                            </div>
                        </div>
                </div>

                <div class="col s12 m9">
                	<!-- TAB DE INFORMACION-->

                    <div id="cardInfo" class="card">
                        <div class="card-content">
                        <div class="row">
                        <label>Lista de usuarios</label>
                                            	<select id="listaUsuarios">
                        <option value="" disabled selected>Seleccionar un usuario</option>
                        <option value="1">estudiante</option>
                        <option value="1">docente</option>
                    </select>
                    </div>
                        </div>
                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width">
                                <li class="tab" class="active"><a href="#test1">Datos</a></li>
                                <li class="tab"><a href="#test2">Social</a></li>
                                <li class="tab"><a href="#test3">Cursos</a></li>
                                <%if(tipo.equals("estudiante")){ %>
                                <li class="tab"><a href="#test4">Programas</a></li>
                                <%} %>
                            </ul>
                        </div>
                        <div class="card-content ">
                        <!-- DATOS USUARIO -->
                            <div id="test1">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nickname
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=nickname %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=nombre %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Apellido
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=apellido %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Email</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=correo %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Nacimiento</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaNac %></div>
                                </div>

                            </div>
                            <!-- SEGUIDORES Y SEGUIDOS -->
                            <div id="test2">
                                <%
										//ArrayList<DTUsuario> seguidos = (java.util.ArrayList)request.getAttribute("seguidos");
										//if(seguidos.size()>0){
									%>
                                <ul class="collection with-header">
                                    <li class="collection-header">
                                        <h10>Seguidos</h10>
                                    </li>
                                    <li class='collection-item'>
                                        <a class="btn-floating btn-small "><i class="material-icons">delete</i></a>
                                        Alvin
                                    </li>
                                    <%
											//for (DTUsuario s : seguidos){
											//out.print("<li class='collection-item'>>"+s.getNick()+"</li>");
											//}
										%>
                                </ul>
                                <%//}%>
                                <% 
                                   		//ArrayList<DTUsuario> seguidores = (java.util.ArrayList)request.getAttribute("seguidores");
										//if(seguidores.size()>0){
									%>
                                <ul class="collection with-header">
                                    <li class="collection-header">
                                        <h10>Seguidores</h10>
                                    </li>
                                    <li class='collection-item'>
                                        <a class="btn-floating btn-small "><i class="material-icons">person_add</i></a>
                                        Alvin
                                    </li>
                                    <%
											//for (DTUsuario s : seguidores){ 
											//out.print("<li class='collection-item'>>"+s.getNick()+"</li>");
								 			//}
										%>
                                </ul>
                                <%//}%>
                            </div>
                            <!--GET-EDICIONES-->
                            <div id="test3">
                                <div class="row">
                                    <div class="input-field col s12">
                                        <%
											//ArrayList<DTEdicionCurso> ediciones = (ArrayList<DTEdicionCurso>) request.getAttribute("ediciones");
                                			//if(ediciones.size()>0){
										%>
                                        <select id="ediciones">
                                            <option value="" >Seleccionar una edicion</option>
                                            <%
											//for (DTEdicionCurso e : ediciones){ %>
                                            <option value="<%//=ediciones.indexOf(e)%>"><%//=e.getNombre()%></option>
                                            <%//}%>
                                        </select>
                                        <%if(tipo.equals("estudiante")){ %>
                                        <label>Inscripciones a Ediciones de Cursos</label>
                                        <%}else if(tipo.equals("docente")){%>
                                        <label>Ediciones de Cursos Asociados</label>
                                        <%} %>
                                        <%//}%>
                                    </div>
                                </div>
                                <%
                                    	//DTEdicionCurso edicion = null ;
										String nombreEdicion = "edicion.getNombre()";
                                    	String fechaI = "edicion.getFechaI()";
                                    	String fechaF = "edicion.getFechaF()";
                                    	String fechaPub = "edicion.getFechaPub()";
                                    	int cupo = 3;
                                    	String curso = "edicion.getNomCurso()";
                                 %>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">nombreEdicion</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">fechaI</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">fechaF</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Publicacion</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">fechaPub</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">cupo</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Curso</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">curso</div>
                                </div>
                            </div>
							<!--GET- PROGRAMAS DE FORMACION-->
                            <div id="test4">
                                <%if (tipo.equals("estudiante")){%>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <!--GET-PROGRAMAS-->
                                        <%
											//ArrayList<DTProgramaFormacion> programas = (ArrayList<DTProgramaFormacion>) request.getAttribute("programas");
                                			//if(programas.size()>0){
										%>
                                        <select id="programas">
                                            <option value="" disabled selected>Seleccionar un programa</option>
                                            <%
											//for (DTProgramaFormacion p : programas){ %>
                                            <option value="<%//=programas.indexOf(p)%>"><%//=p.getNombre()%></option>
                                            <%//}%>
                                        </select>
                                        <%//} %>
                                        <label>Inscripciones a Programas de Formacion</label>
                                    </div>
                                </div>
                                <%
                                        	//DTProgramaFormacion programa = ; 
											String nombreProg = "programa.getNombre()";
                                         	String descripcion = "programa.getDescripcion()";
	                                    	String fechaInicio = "programa.getFechaI()";
	                                    	String fechaFin = "programa.getFechaF()";
	                                    	String fechaA = "programa.fechaA()";
	                                    	String imagen = "programa.getImagenURL()";
                                    	
                                 %>
                                <div class="row">
                                    <!--imagen del programa-->
                                    <img src="images/img4.jpg">
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">nombreProg</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Descripcion
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">descripcion</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align">fechaInicio</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">fechaFin</div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Alta
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align">fechaA</div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="footer.jsp" %>
                            <script type="text/javascript">
                                document.addEventListener('DOMContentLoaded', function () {
                                    var elems = document.querySelectorAll('.collapsible');
                                    var instances = M.Collapsible.init(elems);
                                });
                            </script>
                            <script>
                                document.addEventListener('DOMContentLoaded', function () {
                                    var elems = document.querySelectorAll('select');
                                    var instances = M.FormSelect.init(elems);
                                });
                            </script>
                            <script type="text/javascript">
                                $(document).ready(function () {
                                    $('.tabs').tabs();
                                });
                            </script>
</body>
</html>