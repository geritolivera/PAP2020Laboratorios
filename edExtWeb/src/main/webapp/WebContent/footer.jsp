<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!-- Footer -->
  <footer class="section rojo white-text center">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="resources/scripts/script.js"> </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <p>Siguenos en redes sociales para enterarte de todas las novedades</p>
    <p class="flow-text">edExt &copy; 2020</p>
    <script>
        $(".dropdown-trigger").dropdown({
          coverTrigger: false,
          hover: true
        });
        jQuery(document).ready(function ($) {
          $('.collapsible').collapsible();
        });
      <% System.out.println(session.getAttribute("tipoUser"));%>
    </script>
  </footer>
</body>
</html>