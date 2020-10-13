<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include  file="defaultHeader.jsp" %>
 
  <!-- Section: Search -->
  <section id="search" class="section section-search  rojo white-text center scrollspy">
    <div class="container">
      <div class="row">
        <div class="col s12">
          <h3>Buscar Cursos</h3>
          <div class="input-field">
            <form action="consultaCurso" method="GET">
              <input class="white grey-text autocomplete" placeholder="Programacion 1, matematica, etc..." type="text"
                id="autocomplete-input" name="curso" >
                 <div class="center-align">
                            <button class="btn waves-effect waves-light rojo" type="submit" name="action">Buscar
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