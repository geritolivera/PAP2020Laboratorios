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
                        <th>link atr</th>
                    </tr>
                    </thead>
                    <tbody id="datatablebody">

                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

<script>


    $(document).ready(function() {
        $('#datatable').dataTable({
            "oLanguage": {
                "sSearch": "",
                "sSearchPlaceholder": "Pesquisar",
                "sInfo": "_START_ -_END_ of _TOTAL_",
                "sLengthMenu": '<span>Rows per page:</span><select class="browser-default">' +
                    '<option value="10">10</option>' +
                    '<option value="20">20</option>' +
                    '<option value="30">30</option>' +
                    '<option value="40">40</option>' +
                    '<option value="50">50</option>' +
                    '<option value="-1">All</option>' +
                    '</select></div>'
            },
            bAutoWidth: false,

            buttons: [
                {
                    text: '<span style="color:#4d4d4d; margin-right:15px">Print<span>',
                    extend: 'print',
                    className: '',
                    title: '',
//  autoPrint: false,
                    customize: function ( win ) {
                        $(win.document.body)
                            .css( 'font-size', '10pt' )
                            .prepend(
                                '<h4>Title Test</h4>',
//  Background table picture in print version is here
                                '<img src="http://i.imgur.com/w931ov4.png" style="position: fixed;  top: 50%;  left: 50%;  transform: translate(-50%, -50%);" />'
                            );

                        $(win.document.body).find( 'table' )
                            .addClass( 'compact' )
                            .css( 'font-size', 'inherit',  );
                    }
                },
                {
                    text: '<span style="color:#4d4d4d; margin-right:15px">Excel<span>',
                    extend: 'excelHtml5',
                },
                {
                    text: '<span style="color:#4d4d4d; margin-right:15px">Csv<span>',
                    extend: 'csvHtml5',
                },
                {

                    text: '<span style="color:#4d4d4d; margin-right:15px">Copy<span>',
                    extend: 'copyHtml5',

                },
            ]
        });
    });
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.0/js/materialize.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/buttons.print.min.js"></script>
<script src="https://cdn.datatables.net/buttons/1.3.1/js/dataTables.buttons.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="resources/scripts/busqueda.js"></script>


<%@ include file="footer.jsp"%>
