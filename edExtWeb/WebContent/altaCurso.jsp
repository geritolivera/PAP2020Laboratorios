<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include  file="defaultHeader.jsp" %>
 <%@page import="java.util.ArrayList"%>
 <div class="main">
        <br><br>
   <%
	//ArrayList<String> categorias = (ArrayList<String>) request.getAttribute("categorias");
	%>
        <div class="container">
            <!-- FORM-->
            <div class="row">
                <form class="col s12 ">
                    <div class="card-panel">
                        <h4 class="header2"> <span style="color: #81054b">></span>Alta de Curso</h4>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="nombre" id="nombre">
                                <label for="nombre">Nombre de Curso</label>
                            </div>

                            <div class="input-field col s6">
                                <select name="instituto" id="instituto">
                                    <option value="" disabled selected>Seleccione uno</option>
                                   
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
                                <label for="creditoss">Creditos</label>
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
                                    <option value="1">Option 1</option>
                                    <option value="2">Option 2</option>
                                    <option value="3">Option 3</option>
                                </select>
                                <label>Previas</label>
                            </div>
                            <div class="input-field col s6">
                                <select multiple name="categorias" id="categorias">
                                    <option value="" disabled selected>Seleccionar categorias</option>
                                    
                                </select>
                                <label>Categorias</label>
                            </div>
                        </div>
                        <div class="center-align">
                            <button class="btn waves-effect waves-light rojo" type="submit" name="action">Crear
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
	 $.ajax({
         type: "POST",
         url: "GetListas",
         data: 'tipo= categorias',
         success: function(html){
        	 $('#categorias').html(html);
        	 $('#categorias').formSelect();
             var element = document.getElementById('#categorias');
             var event = new Event('change');
             element.dispatchEvent(event);
         }
     });
	 $('#categorias').formSelect();
	 
	 $.ajax({
         type: "POST",
         url: "GetListas",
         data: 'tipo= institutos',
         success: function(html){
        	 $('#institutos').html(html);
        	 $('#institutos').formSelect();
             var element = document.getElementById('#institutos');
             var event = new Event('change');
             element.dispatchEvent(event);
         }
     });
     $('#instituto').formSelect();
     
     $.ajax({
         type: "POST",
         url: "GetListas",
         data: 'tipo= previas',
         success: function(html){
        	 $('#previas').html(html);
        	 $('#previas').formSelect();
             var element = document.getElementById('#previas');
             var event = new Event('change');
             element.dispatchEvent(event);
         }
     });
     $('#previas').formSelect();
 });
</script>