var baseURL = 'http://localhost:8081/edExtWeb/';

function getInstitutos(){

    var url = baseURL +`GetListas`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        return res.json();
    }).then((institutos) => {
        var institutoHtml = document.getElementById("institutos");
        institutoHtml.innerHTML = `<option value="" disabled selected>Seleccione un instituto</option>`;
        if (institutos.length > 0){
            institutos.forEach((item, index) => {
                console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                institutoHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#institutos').formSelect();
            $('#categorias').formSelect();
        }else{
            console.log('no hay institutos');
        }
    });
}


function getCategorias(){
    var url = baseURL +`GetCategorias`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        return res.json();
    }).then((categorias) => {
        var categoriasHtml = document.getElementById("categorias");
        categoriasHtml.innerHTML = `<option value="" disabled>Seleccione las categorias</option>`;
        if (categorias.length > 0){
            categorias.forEach((item, index) => {
                categoriasHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#institutos').formSelect();
            $('#categorias').formSelect();
        }else{
            console.log('no hay categorias');
        }
    });
}



function getInstitutosAlta(){

    var url = baseURL +`GetListas`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        return res.json();
    }).then((institutos) => {
        var institutoHtml = document.getElementById("institutos");
        institutoHtml.innerHTML = `<option value="" disabled selected>Seleccione un instituto</option>`;
        if (institutos.length > 0){
            institutos.forEach((item, index) => {
                console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                institutoHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#institutos').formSelect();
            $('#categorias').formSelect();
            $('#previas').formSelect();
        }else{
            console.log('no hay institutos');
        }
    });
}


function getCategoriasAlta(){
    var url = baseURL +`GetCategorias`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        return res.json();
    }).then((categorias) => {
        var categoriasHtml = document.getElementById("categorias");
        categoriasHtml.innerHTML = `<option value="" disabled>Seleccione las categorias</option>`;
        if (categorias.length > 0){
            categorias.forEach((item, index) => {
                categoriasHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#institutos').formSelect();
            $('#categorias').formSelect();
            $('#previas').formSelect();
        }else{
            console.log('no hay categorias');
        }
    });
}

function getPrevias(){
    var url = baseURL +`GetPrevias`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        return res.json();
    }).then((previas) => {
        var previasHtml = document.getElementById("previas");
        if (previas.length > 0){
            previasHtml.innerHTML = `<option value="" disabled>Seleccione las previas</option>`
            previas.forEach((item, index) => {
                previasHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#institutos').formSelect();
            $('#categorias').formSelect();
            $('#previas').formSelect();
        }else{
            console.log('no hay previas');
        }
    });
}


function getCursos(){

    var url = baseURL +`GetCursos`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        console.log(res + " " + res.json);
        return res.json();
    }).then((cursos) => {
        var cursosagHtml = document.getElementById("cursosagregar");
        if (cursos.length > 0){
            cursosagHtml.innerHTML = `<option value="" disabled selected>Seleccione los cursos</option>`
            cursos.forEach((item, index) => {
                cursosagHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#cursosagregar').formSelect();
        }else{
            console.log('no hay cursos');
        }
    })
}

/** FUNCIONES GENERALES PARA CONSUMIR AJAX **/
//declao variables globales para
var READY_STATE_UNITIALIZED = 0;
var READY_STATE_LOADING     = 1;
var READY_STATE_LOADED      = 2;
var READY_STATE_INTERACTIVE = 3;
var READY_STATE_COMPLETE    = 4;
var STATUS_OK               = 200;

function obtenerCursosPorInstituto(instituto){
    // Parametro:

    var url = baseURL + `GetCursoInst?instituto=${instituto}`

    fetch(url, {
        method: 'GET',
    }).then( (res) => {
        return res.json();
    }).then(cursos => {
            console.log("cursos:", cursos);
            var cursosHtml = document.getElementById("curso");

            cursosHtml.innerHTML = `<option value="" disabled selected>Seleccione el curso</option>`;
            if (cursos.length > 0){
                cursos.forEach((item, index) => {
                    cursosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#curso').formSelect();
            }else{
                cursosHtml.innerHTML = `<option value="" disabled selected>No existen cursos para este Instituto</option>`;
                console.log('no hay cursos');
            }
        }).catch(error => console.log(' 1) eerr ', error));

    url = baseURL +`GetDocInst?instituto=${instituto}`

    fetch(url, {
        method: 'GET',
    }).then( (response) => {
        return response.json();
    })
        .then(docentes => {
            console.log("docentes:", docentes);
            var docentesHtml = document.getElementById("docentes");

            if (docentes.length > 0){
                docentesHtml.innerHTML = `<option value="" disabled>Seleccione los docentes</option>`;
                docentes.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    docentesHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#docentes').formSelect();
            }else{
                docentesHtml.innerHTML = `<option value="" disabled>No existen docentes en este instituto</option>`;;
            }


        }).catch(error => console.log(' 2) eerr ', error));


}

function obtenerDocentesPorInstituto(instituto){
    debugger;
    var url = baseURL +`GetDocInst?instituto=${instituto}`
    fetch(url, {
        method: 'GET',
    }).then( (response) => {
        return response.json();
    })
        .then(docentes => {
            console.log("docentes:", docentes);
            var docentesHtml = document.getElementById("docentes");

            if (docentes.length > 0){
                docentesHtml.innerHTML = `<option value="" disabled>Seleccione los docentes</option>`;
                docentes.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    docentesHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#docentes').formSelect();
            }else{
                docentesHtml.innerHTML = `<option value="" disabled>No existen docentes en este instituto</option>`;;
            }


        }).catch(error => console.log(' 2) eerr ', error));
}
function obtenerDatosUsuario(nickname){
    var url = baseURL + `consultaUsuario?nickname=${nickname}`

    fetch(url, {
        method: 'GET'
    }).then( (res) => {
        return res.json();
    }).then(dtu => {

        JSON.stringify(dtu);
        console.log(dtu)
        var usuarioHtml = document.getElementById("detallesUE");
        var seleccionadoHtml = document.getElementById("nicknameSelected");
        seleccionadoHtml.innerHTML = dtu.nick;
        var fechaN = new Date(dtu.fechaNac).toLocaleDateString();


        usuarioHtml.innerHTML=`<li class="collection-item">
                                 <div class="row">
                                    <div class="col s5 grey-text darken-1"><i class="mdi-action-wallet-travel"></i>Nickname</div>
                                    <div class="col s7 grey-text text-darken-4 right-align" id="nicknamee">` + dtu.nick +`</div>
                                 </div>
                               </li>`;
        usuarioHtml.innerHTML+=`<li class="collection-item">
                                    <div class="row">
                                        <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Nombre</div>
                                        <div class="col s7 grey-text text-darken-4 right-align" id="nombree">`+dtu.nombre+`</div>
                                    </div>
                                </li>`;
        usuarioHtml.innerHTML+=`<li class="collection-item">
                                    <div class="row">
                                        <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Apellido</div>
                                        <div class="col s7 grey-text text-darken-4 right-align" id="apellidoe">`+ dtu.apellido +`</div>
                                    </div>
                                </li>`;
        usuarioHtml.innerHTML+=`<li class="collection-item">
                                    <div class="row">
                                        <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Correo</div>
                                        <div class="col s7 grey-text text-darken-4 right-align" id="correoe">` + dtu.correo +`</div>
                                    </div>
                                </li>`;
        usuarioHtml.innerHTML+=`<li class="collection-item">
                                    <div class="row">
                                        <div class="col s5 grey-text darken-1"><i class="mdi-social-poll"></i>Fecha de Nacimiento</div>
                                        <div class="col s7 grey-text text-darken-4 right-align" id="fechaNace">` + fechaN +`</div>
                                    </div>
                                </li>`;
    }).catch(error => console.log(' 1) eerr ', error));
}

function listaEdicionesUsuario(nickname){
    var url = baseURL + `GetCursoUsu?nickname=${nickname}`


    fetch(url, {
        method: 'GET',
    }).then( (res) => {
            return res.json();
    }).then(cursos => {
            console.log("cursos:", cursos);
            var cursosHtml = document.getElementById("listaCursos");
            cursosHtml.innerHTML =`<option value="" disabled selected>Seleccione la edicion</option>`;
            if (cursos.length > 0){
                cursos.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    cursosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#listaCursos').formSelect();
            }else{
                console.log('no hay tipos de recursos');
            }


        }).catch(error => console.log(' 1) eerr ', error));
}


function listaEdicionesUsuarioEstudiante(nickname){
    var url = baseURL + `GetEdicionesUsu?nickname=${nickname}`

    fetch(url, {
        method: 'GET',
    }).then( (res) => {
        return res.json();
    }).then(ediciones => {
        console.log("ediciones:", ediciones);
        var edicionesHtml = document.getElementById("edicionese");
        edicionesHtml.innerHTML =  `<li></li>`;
        if (ediciones.length > 0){
            ediciones.forEach((item, index) => {
                console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                edicionesHtml.innerHTML += `<li class="collection-item">
                                                <div>${item}<a href="consultaEdicionCurso?edicion=${item}" class="secondary-content"><i class="material-icons">send</i></a></div>
                                            </li>`;
            });
        }else{
            console.log('no hay tipos de recursos');
        }
    }).catch(error => console.log(' 1) eerr ', error));
}


function collectionCursosPorInstituto(instituto){
    // Parametro:
    //debugger;
    var url = baseURL + `GetCursoInst?instituto=${instituto}`

    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(cursos => {
        console.log("cursos:", cursos);
        var cursosHtml = document.getElementById("curso");
        cursosHtml.innerHTML = '';
        if (cursos.length > 0){
            cursos.forEach((item, index) => {
                cursosHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaCurso?curso=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
            });
        }else{
            cursosHtml.innerHTML += `<li class="collection-item">No existen cursos en este instituto.</li>`;
            console.log('no hay cursos');
        }
    }).catch(error => console.log(' 1) eerr ', error));
    //obtenerDocentesPorInstituto(instituto);
}

function collectionCursosPorCategoria(categoria){
    // Parametro:
    //debugger;
    var url = baseURL + `GetCursoCat?categoria=${categoria}`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(cursos => {
        console.log("cursos:", cursos);
        var cursosHtml = document.getElementById("curso");
        cursosHtml.innerHTML = '';
        if (cursos.length > 0){
            cursos.forEach((item, index) => {
                cursosHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaCurso?curso=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
            });
        }else{
            cursosHtml.innerHTML += `<li class="collection-item">No existen cursos en esta categoria.</li>`;
            console.log('no hay categorias');
        }
    }).catch(error => console.log(' 1) eerr ', error));

}

function collectionEdicionPorCursos(curso){
    // Parametro:
    //debugger;
    var url = baseURL + `GetEdicionesCurso?curso=${curso}`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(ediciones => {
        console.log("ediciones:", ediciones);
        JSON.stringify(ediciones);
        var edicionesHtml = document.getElementById("ediciones");
        edicionesHtml.innerHTML = '';
        if (ediciones.length > 0){
            ediciones.forEach((item, index) => {
                edicionesHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaEdicionCurso?edicion=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
            });
        }else{
            edicionesHtml.innerHTML += `<li class="collection-item">No existen ediciones para este curso.</li>`
        }
    }).catch(error => console.log(' 1) eerr ', error));

}


function collectionProgramas(){
    // Parametro:
    //debugger;
    var url = baseURL + `GetProgramasFormacion`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(programas => {
        console.log("programas:", programas);
        var programasHtml = document.getElementById("programa");
        programasHtml.innerHTML = '';
        if (programas.length > 0){
            programas.forEach((item, index) => {
                programasHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaProgramaFormacion?programa=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
            });
        }else{
            programasHtml.innerHTML += `<li class="collection-item">No existen programas.</li>`;
            console.log('no hay programas');
        }
    }).catch(error => console.log(' 1) eerr ', error));
    //obtenerDocentesPorInstituto(instituto);
}

function collectionUsuarios(){
    // Parametro:
    debugger;
    var url = baseURL + `GetUsuarios`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(usuarios => {
        console.log("seguidos:", usuarios);
        var usuariosHtml = document.getElementById("usuario");
        usuariosHtml.innerHTML = '';
        if (usuarios.length > 0){
            usuarios.forEach((item, index) => {
                usuariosHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaUsuario?nickname=${item}" class="secondary-content"><i class="material-icons" type="button">send</i></a></div></li>`;
            });
        }else{
            usuariosHtml.innerHTML += `<li class="collection-item">No existen usuarios.</li>`;
            console.log('no hay usuarios');
        }
    }).catch(error => console.log(' 1) eerr ', error));
    //obtenerDocentesPorInstituto(instituto);
}

function collectionSeguidores(){
    // Parametro:
    debugger;
    var url = baseURL + `GetSeguidores`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(seguidores => {
        console.log("seguidores:", seguidores);
    }).catch(error => console.log(' 1) eerr ', error));
    //obtenerDocentesPorInstituto(instituto);
}

function collectionSeguidos(){
    // Parametro:
    debugger;
    var url = baseURL + `GetSeguidos`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(seguidos => {
        console.log("seguidos:", seguidos);

    }).catch(error => console.log(' 1) eerr ', error));
}

function tableInscripciones(edicion){
    // Parametro:
    //debugger;
    var url = baseURL + `GetInscripcionesED?edicion=` + edicion;
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(dti => {
        JSON.stringify(dti);
        var inscripcionesHtml = document.getElementById("detallesIns");
        //console.log("inscripciones:", dti);
        inscripcionesHtml.innerHTML = '';
        if (dti.length > 0){
            dti.forEach((item, index) => {
                //console.log("estado: ", item.estado);
                if(item.estado == "PENDIENTE"){
                    inscripcionesHtml.innerHTML += `<tr>
                                                        <td><button type="button" onclick="confirmarInscripcion('${item.edicion}', '${item.usuario}', 'aceptar')">Aceptar</button>
                                                        <button type="button" onclick="confirmarInscripcion('${item.edicion}', '${item.usuario}', 'rechazar')">Rechazar</button></td>
                                                        <td> ${item.edicion} <input type="hidden" name="edicion" value="${item.edicion}"/></td>
                                                        <td> ${item.usuario} </td>
                                                        <td> ${item.estado} </td>
                                                        <td> ${item.fecha}</td>
                                                        <th> ${item.prioridad} </th>
                                                </tr>`;
                }
                else{
                    inscripcionesHtml.innerHTML += `<tr>
                                                        <td><button disabled>Aceptar</button>
                                                        <button disabled>Rechazar</button></td>
                                                        <td> ${item.edicion} <input type="hidden" name="edicion" value="${item.edicion}"/></td>
                                                        <td> ${item.usuario} </td>
                                                        <td> ${item.estado} </td>
                                                        <td> ${item.fecha}</td>
                                                        <th>` + index + `</th>
                                                    </tr>`;
                }
            });
        }else{
            inscripcionesHtml.innerHTML += `<tr>
                                                <th>No hay inscripciones para esta edicion.</th>
                                            </tr>`;
            console.log('no hay inscripciones');
        }
    }).catch(error => console.log(' 1) eerr ', error));
}

function tableInscripcionesAjax(){
    // Parametro:
    debugger;
    var url = baseURL + `GetInscripcionesED`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(dti => {
        var inscripcionesHtml = document.getElementById("detallesIns");
        console.log("inscripciones:", dti);
        data = [];
        inscripcionesHtml.innerHTML = '';
        if (dti.length > 0){
            dti.forEach((item, index) => {
                data[index] = [index, item.edicion, item.usuario, item.estado, item.fecha, 0.5];
            })
            $(document).ready(function() {
                var tabla = $('#tablaInscripciones').DataTable( {
                    data: data,
                    columns: [
                        { title: ""},
                        { title: "Edicion" },
                        { title: "Usuario" },
                        { title: "Estado" },
                        { title: "Fecha" },
                        { title: "Prioridad" }
                    ]
                });
            });
            console.log(data);
        }else{
            console.log('no hay inscripciones');
        }
    }).catch(error => console.log(' 1) eerr ', error));
}

function tableInscripcionesCheckbox(){
    // Parametro:
    debugger;
    var url = baseURL + `GetInscripcionesED`
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(dti => {
        debugger;
        var inscripcionesHtml = document.getElementById("detallesIns");
        console.log("inscripciones:", dti);
        data = [];
        var cont = 1;
        inscripcionesHtml.innerHTML = '';
        if (dti.length > 0){
            dti.forEach((item, index) => {
                data[index] = [cont, item.edicion, item.usuario, item.estado, item.fecha, 0.5];
                cont++;
            })
            $(document).ready(function() {
                debugger;
                var tabla = $('#tablaInscripciones').DataTable( {
                    data: data,
                    columns: [
                        { title: ""},
                        { title: "Edicion" },
                        { title: "Usuario" },
                        { title: "Estado" },
                        { title: "Fecha" },
                        { title: "Prioridad" },
                    ],
                    'columnDefs': [
                        {
                            'targets': 0,
                            'checkboxes': {
                                'selectRow': true
                            }
                        }
                    ],
                    'select':{
                        'style': 'multi'
                    },
                    'order': [[1, 'asc']]
                })
                $("#tableForm").on('submit', function(e){
                    var form = this
                    var rowsel = tabla.column(0).checkboxes.selected();
                    $.each(rowsel, function(index, rowId){
                        $(form).append(
                            $('<input>').attr('type','hidden').attr('name','id[]').val(rowId)
                        )
                    })
                    $("#view-rows").text(rowsel.join(","))
                    $("#view-form").text($(form).serialize())
                    $('input[name="id\[\]"]', form).remove()
                    e.preventDefault()
                })
            });
            console.log(data);
        }else{
            console.log('no hay inscripciones');
        }
    }).catch(error => console.log(' 1) eerr ', error));
}

function tableInscripcionesAceptados(edicion){
    // Parametro:
    debugger;
    var url = baseURL + `GetInscripcionesED?edicion=` + edicion;
    fetch(url, {
        method: 'GET',
    }).then(res => res.json()
    ).then(dti => {
        JSON.stringify(dti);
        var inscripcionesHtml = document.getElementById("detallesAceptados");
        console.log("inscripcionesAceptados:", dti);
        inscripcionesHtml.innerHTML = '';
        console.log("length",dti.length );
        if (dti.length > 0){
            dti.forEach((item, index) => {
                console.log("estado: ", item.estado);
                if(item.estado == "ACEPTADO"){
                    inscripcionesHtml.innerHTML += `<tr>
                                                        <td> ${item.edicion}</td>
                                                        <td> ${item.usuario} </td>
                                                        <td> ${item.estado} </td>
                                                        <td> ${item.fecha}</td>
                                                        <th> ${item.prioridad} </th>
                                                </tr>`;
                console.log("inscripcionesAceptados:", inscripcionesHtml.innerHTML);
                }
            });
        }else{
            inscripcionesHtml.innerHTML += `<tr>
                                                <th>No hay inscripciones para esta edicion.</th>
                                            </tr>`;
            console.log('no hay inscripciones');
        }
    }).catch(error => console.log(' 1) eerr ', error));
}