<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!-- Footer -->
  <footer class="section rojo white-text center">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script src="resources/scripts/script.js"> </script>
    <script src="resources/scripts/listas.js"> </script>
    <script src="resources/scripts/alta.js"> </script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <p class="flow-text">edExt &copy; 2020</p>
    <script>
        $(".dropdown-trigger").dropdown({
          coverTrigger: false,
          hover: true
        });
        jQuery(document).ready(function ($) {
          $('.collapsible').collapsible();
        });
      
    </script>
  </footer>
</body>
</html>