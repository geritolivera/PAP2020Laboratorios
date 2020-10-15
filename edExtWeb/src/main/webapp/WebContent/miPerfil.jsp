<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="datatypes.DTEdicionCurso" %>
<%@ page import="interfaces.fabrica" %>
<%@ page import="interfaces.IcontroladorUsuario" %>

<%@ page import="controladores.controladorCurso" %>
<%@ page import="datatypes.DTUsuario" %>
<%@ page import="org.apache.taglibs.standard.tei.DeclareTEI" %>
<%@ page import="datatypes.DTEstudiante" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Mi Perfil</title>
    <% if (session.getAttribute("tipoUser")=="docente"){ %>
    <%@include file="defaultHeader.jsp"%>
    <%}else{ %>
    <%@include file="headerEstVis.jsp"%>
    <%}%>
</head>

<body>
    <!--GET-ATRIBUTOS USUARIO-->
    <%
      //ver la imagen\
        HttpSession ses = request.getSession();
      String nickname = (String) ses.getAttribute("nickname");
      String nombre = (String) ses.getAttribute("nombre");
      String apellido = (String) ses.getAttribute("apellido");
      String correo = (String) ses.getAttribute("correo");
      Date fechaNac = (Date) ses.getAttribute("fechaNac");
  	  String tipo = (String) ses.getAttribute("tipoUser");
//      ArrayList<String> programas = (ArrayList<String>) ses.getAttribute("programas");
      fabrica fab = fabrica.getInstancia();
      IcontroladorUsuario icon = fab.getIcontroladorUsuario();

        DTUsuario dtu = icon.verInfoUsuario(nickname);
        List<DTEdicionCurso> ediciones = ((DTEstudiante)dtu).getEdiciones();
        System.out.println("ediciones = " + ediciones);
        String selectedEdi = new String();
    %>
    <div class="main">
        <br><br>
        <div class="container">
            <div class="row">
                <!-- CARD USUARIO-->
                <div class="col s12 m3">
                    <div class="card">
                        <div class="card-image">
                        	 <!-- IMAGEN DEL USUARIO-->
                            <img src="resources/images/img4.jpg">
                        </div>
                        <!-- COLLAPSIBLE USUARIO -->
                        <ul class="collapsible">
                            <%if (tipo.equals("estudiante")){%>
                            <li>
                                <div class="collapsible-header  yellow darken-4"><i
                                        class="material-icons">account_circle</i>Mi Perfil
                                </div>
                                <div class="collapsible-body">
                                    <p><a href="modificarDatosUsuario.jsp">Modificar Datos</a></p>
                                </div>
                            </li>
                            <li>
                                <div class="collapsible-header lime"><i class="material-icons">book</i>Inscribirme</div>
                                <div class="collapsible-body">
                                    <div class="row">
                                        <p><a href="<%//InscripcionEdicion.jsp%>">Inscribirme a Edicion de curso</a></p>
                                        <p><a href="<%//InscripcionPrograma.jsp%>">Inscribirme a Programa de
                                                Formacion</a></p>
                                    </div>
                                </div>
                            </li>
                            <%}else if(tipo.equals("docente")){%>
                            <li>
                                <div class="collapsible-header  yellow darken-4"><i
                                        class="material-icons">account_circle</i>Mi Perfil
                                </div>
                                <div class="collapsible-body">
                                    <p><a href="modificarDatosUsuario.jsp">Modificar Datos</a></p>
                                </div>
                            </li>
                            <li>
                                <div class="collapsible-header lime"><i class="material-icons">book</i>Ediciones</div>
                                <div class="collapsible-body">
                                    <div class="row">
                                        <p><a href="<%//listarAceptadosEdicionesdecurso.jsp%>">Ver Resultados</a></p>
                                    </div>
                                </div>
                            </li>
                            </div>
                            <%}%>
                        </ul>
                    </div>
                </div>
                <div class="col s12 m9">
                	<!-- TAB DE INFORMACION-->
                    <div id="cardInfo" class="card">
                        <div class="card-content">
                            <p>I am a very simple card. I am good at containing small bits of information. I am
                                convenient because I require little markup to use effectively.</p>
                        </div>
                        <div class="card-tabs">
                            <ul class="tabs tabs-fixed-width">
                                <li class="tab" class="active"><a href="#test1">Datos</a></li>
                                <li class="tab"><a href="#test2">Social</a></li>
                                <li class="tab"><a href="#test3">Cursos</a></li>
                                <%if(tipo.equals("docente")){ %>
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
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=nickname%></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=nombre%></div>
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
                                        <select id="edicion" name="edicion" onchange="getDatosEdicion(edicion.value)" >
                                            <option value="" disabled selected >Seleccionar una edicion</option>
                                            <c:forEach var="ed" items="${edicionesNombres}">
                                                <option value="${ed}">${ed}</option>
                                            </c:forEach>
                                        </select>
                                        <%if(tipo.equals("estudiante")){ %>
                                        <label>Inscripciones a Ediciones de Cursos</label>
                                        <%}else if(tipo.equals("docente")){%>
                                        <label>Ediciones de Cursos Asociados</label>
                                        <%} %>
                                    </div>
                                </div>
                                <%
                                    	//DTEdicionCurso edicion = null ;
                                        DTEdicionCurso dtSelected = new DTEdicionCurso();
                                    for (DTEdicionCurso dte:ediciones) {
                                        if(dte.getNombre().equals(selectedEdi)){
                                            dtSelected = dte;
                                        }

                                    }
										String nombreEdicion = dtSelected.getNombre();
                                    	Date fechaI = dtSelected.getFechaI();
                                    	Date fechaF = dtSelected.getFechaF();
                                    	Date fechaPub = dtSelected.getFechaPub();
                                    	Integer cupo = dtSelected.getCupo();
                                    	String curso = dtSelected.getNomCurso();
                                 %>

                                <div id="infoSelecEdi">
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=selectedEdi %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Inicio</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaI %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin
                                    </div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaF %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de
                                        Publicacion</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=fechaPub %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=cupo %></div>
                                </div>
                                <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Curso</div>
                                    <div class="col s7 grey-text text-darken-4 right-align"><%=curso %></div>
                                </div>
                            </div>
                            </div>
							<!--GET- PROGRAMAS DE FORMACION-->
                            <div id="test4">
                                <%if (tipo.equals("estudiante")){%>
                                <div class="row">
                                    <div class="input-field col s12">
                                        <!--GET-PROGRAMAS-->
                                        <select id="programas">
                                            <option value="" disabled selected>Seleccionar un programa</option>
                                            <c:forEach var="pro" items="${programas}">
                                                <option value="${pro}">${pro}</option>
                                            </c:forEach>
                                        </select>

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
                                    <img src="resources/images/asd.jpg" sizes="[class]= card-content" style="width: 400px;height: 300px;padding-left: 100px;">
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
    <script>
        function getDatosEdicion(nombre){
            var baseURL = 'http://localhost:8080/edExtWeb/';

            var url = baseURL +`GetDatosEdicion?nombre=`+ nombre;

            fetch(url)
                .then((res)=>{
                    return res.json();
                }).then((ediSelected) => {
                var edicionHtml = document.getElementById("infoSelecEdi");
                console.log(ediSelected)
                edicionHtml.innerHTML= ``;
                <%--institutoHtml.innerHTML = `<option value="" disabled selected>Seleccione un instituto</option>`;--%>
                <%--if (institutos.length > 0){--%>
                <%--    institutos.forEach((item, index) => {--%>
                <%--        console.log(" Re item: " + JSON.stringify(item) + " index: " + index);--%>
                <%--        institutoHtml.innerHTML += `<option value="${item}"> ${item}</option>`;--%>
                <%--    });--%>
                <%--    $('#institutos').formSelect();--%>
                <%--}else{--%>
                <%--    console.log('no hay institutos');--%>
                <%--}--%>
                JSON.stringify(ediSelected);
                Date.parse(ediSelected.fechaI)

                edicionHtml.innerHTML = `<div class="row">`;
                    edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Nombre</div>`;
                    edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + ediSelected.nombre +`</div>`;
                    edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                    edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Inicio</div>`;
                    edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">`+ Date.parse(ediSelected.fechaI).toLocaleDateString() +`</div>`;
                    edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                    edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Fin`;
                    edicionHtml.innerHTML +=`</div>`;
                    edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` +Date.parse(ediSelected.fechaF).toLocaleDateString()+ `</div>`;
                    edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                    edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Fecha de Publicacion</div>`;
                    edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + new Date(ediSelected.fechaPub).toLocaleDateString() +`</div>`;
                    edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                    edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Cupo</div>`;
                    edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` + ediSelected.cupo +`</div>`;
                    edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`<div class="row">`;
                    edicionHtml.innerHTML +=`<div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i> Curso</div>`;
                    edicionHtml.innerHTML +=`<div class="col s7 grey-text text-darken-4 right-align">` +ediSelected.nomCurso + `</div>`;
                    edicionHtml.innerHTML +=`</div>`;
                edicionHtml.innerHTML +=`</div>`;
            })
        }
    </script>
</body>

</html>