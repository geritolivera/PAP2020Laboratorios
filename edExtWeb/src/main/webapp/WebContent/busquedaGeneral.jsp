<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("tipoUser")=="docente"){ %>
<%@include file="defaultHeader.jsp"%>
<%}else{ %>
<%@include file="headerEstVis.jsp"%>
<%}%>
<link rel="stylesheet" href="resources/styles/styleTable.css">
<div class="main">
    <br><br>
    <div class="container">
    <div class="row">
        <div id="admin" class="col s12">
            <div class="card material-table">
                <div class="table-header">
                    <span class="table-title">Busqueda General</span>
                    <div class="actions">
                        <a href="#" class="search-toggle btn-flat nopadding" name="input"><i class="material-icons prefix">search</i></a>
                    </div>
                </div>
                <table id="datatable">
                    <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Nombre</th>
                        <th>Descripcion</th>
                        <th>Link</th>
                    </tr>
                    </thead>
                    <tbody id="datatablebody">
                    <tr>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="resources/scripts/busqueda.js"></script>


<%@ include file="footer.jsp"%>
