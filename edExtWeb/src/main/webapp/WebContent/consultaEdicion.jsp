<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
 
  <!-- Section: Search -->
  <section id="search" class="section section-search  rojo white-text center scrollspy">
    <div class="container">
      <div class="row">
        <div class="col s12">
          <h3>Buscar Ediciones</h3>
          <div class="input-field">
            <form action="consultaEdicionCurso" method="GET">
              <input class="white grey-text autocomplete" placeholder="Edicion 1, EdiProgramacion, etc..." type="text"
                id="autocomplete-input" name="edicion" >
                 <div class="center-align">
                            <button class="btn waves-effect waves-light rojo" type="submit">Buscar
                                <i class="material-icons right">send</i>
                            </button>
                 </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>


  <%@include  file="footer.jsp" %>