var baseURL = 'http://localhost:8080/edExtWeb/';

$(document).ready(function (){
    var url = baseURL +`GetListas`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
            return res.json();
        }).then((institutos) => {
        var institutoHtml = document.getElementById("institutos");
        institutoHtml.innerHTML= "";
        institutoHtml.innerHTML = `<option value="" disabled selected>Seleccione un instituto</option>`;
        if (institutos.length > 0){
            institutos.forEach((item, index) => {
                console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                institutoHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#institutos').formSelect();
        }else{
            console.log('no hay institutos');
        }
    })

    url = baseURL +`GetUsuarios`

    fetch(url)
        .then((res)=>{
            return res.json();
        }).then((usuarios) => {
        var usuariosHtml = document.getElementById("listaUsuarios");
        usuariosHtml.innerHTML= "";

        if (usuarios.length > 0){
            usuariosHtml.innerHTML = `<option value="" disabled selected>Seleccione el usuario</option>`;
            usuarios.forEach((item, index) => {
                usuariosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#listaUsuarios').formSelect();
        }else{
            console.log('no hay institutos');
        }
    })

    url = baseURL +`Categorias`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
        return res.json();
    }).then((categorias) => {
        var categoriasHtml = document.getElementById("categorias");
        categoriasHtml.innerHTML= "";
        categoriasHtml.innerHTML = `<option value="" disabled>Seleccione las categorias</option>`;
        if (categorias.length > 0){
            categorias.forEach((item, index) => {
                categoriasHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#categorias').formSelect();
        }else{
            console.log('no hay categorias');
        }
    })

    url = baseURL +`Previas`

    fetch(url, {
        method: 'GET',
    }).then((res)=>{
            return res.json();
        }).then((previas) => {
        var previasHtml = document.getElementById("previas");
        previasHtml.innerHTML= "";
        if (previas.length > 0){
            previasHtml.innerHTML = `<option value="" disabled>Seleccione las previas</option>`
            previas.forEach((item, index) => {
                previasHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#previas').formSelect();
        }else{
            console.log('no hay previas');
        }
    })

    url = baseURL +`GetCursos`
    fetch(url, {
        method: 'GET',
    }).then((res)=>{
            console.log(res + " " + res.json);
            return res.json();
        }).then((cursos) => {
        var cursosagHtml = document.getElementById("cursosagregar");
        cursosagHtml.innerHTML= "";

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
})

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
        })
        .then(cursos => {
            console.log("cursos:", cursos);
            var cursosHtml = document.getElementById("curso");

            cursosHtml.innerHTML= ``;

            if (cursos.length > 0){
                cursosHtml.innerHTML = `<option value="" disabled selected>Seleccione el curso</option>`;
                cursos.forEach((item, index) => {
                    cursosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                    });
                $('#curso').formSelect();
            }else{
                console.log('no hay cursos');
            }
        }).catch(error => console.log(' 1) eerr ', error));
     //obtenerDocentesPorInstituto(instituto);

}

function obtenerCursosPorCategoria(categoria){
// Parametro:

var url = baseURL + `GetCursoCat?categoria=${categoria}`

    fetch(fetchUrl, {
        method: 'GET',
    }).then( (res) => {
        return res.json();
    })
    .then(cursos => {
        console.log("cursos:", cursos);
        var cursosHtml = document.getElementById("curso");

        cursosHtml.innerHTML= ``;

        if (cursos.length > 0){
            cursosHtml.innerHTML = `<option value="" disabled selected>Seleccione el curso</option>`;
            cursos.forEach((item, index) => {
                cursosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
            console.log(cursos);    
            $('#curso').formSelect();
        }else{
            console.log('no hay cursos');
        }
    }).catch(error => console.log(' 1) eerr ', error));
    //obtenerDocentesPorInstituto(instituto);

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

            docentesHtml.innerHTML= ``;

            if (docentes.length > 0){
                docentesHtml.innerHTML = `<option disabled>Seleccione los docentes</option>`;
                docentes.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    docentesHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#docentes').formSelect();
            }else{
                console.log('no hay docentes');
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

        var usuarioHtml = document.getElementById("detallesU");
        usuarioHtml.innerHTML='';

        usuarioHtml.innerHTML += `<label value="${dtu.nick}" style="color:black"><b>NickName:</b>${dtu.nick}<br></label>`
        usuarioHtml.innerHTML += `<label value="${dtu.nombre}" style="color:black"><b>Nombre:</b>${dtu.nombre}<br></label>`
        usuarioHtml.innerHTML += `<label value="${dtu.apellido}" style="color:black"><b>Apellido:</b>${dtu.apellido}<br></label>`
        usuarioHtml.innerHTML += `<label value="${dtu.correo}" style="color:black"><b>Correo:</b>${dtu.correo}</label>`

        if (dtu.ediciones.length > 0){
            dtu.cursos.forEach((item, index) => {
                console.log(" Re item: " + JSON.stringify(dtu.ediciones.nombre) + " index: " + index);
                //usuarioHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
            });
            $('#listaCursosE').formSelect();
        }else {
            console.log('no hay cursos');
            usuarioHtml.innerHTML
        }
        }).catch(error => console.log(' 1) eerr ', error));
}
function listaEdicionesUsuario(nickname){
    var url = baseURL + `GetCursoUsu?nickname=${nickname}`


    fetch(url)
        .then( (res) => {
            return res.json();
        })
        .then(cursos => {
            console.log("cursos:", cursos);
            var cursosHtml = document.getElementById("listaCursos");

            cursosHtml.innerHTML= ``;

            if (cursos.length > 0){
                cursos.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    cursosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#listaCursos').formSelect();
            }else{
                console.log('no hay tipos de recursos');
                cursosHtml.innerHTML += `<h5>No hay tipos de recursos en el sistema.}</h5>`;
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
            cursosHtml.innerHTML= ``;
            console.log(cursos);
            if (cursos.length > 0){
                cursos.forEach((item, index) => {
                    cursosHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaCurso?curso=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
                    });
            }else{
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
            cursosHtml.innerHTML= ``;
    
            if (cursos.length > 0){
                cursos.forEach((item, index) => {
                    cursosHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaCurso?curso=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
                    });
            }else{
                console.log('no hay categorias');
            }
        }).catch(error => console.log(' 1) eerr ', error));
        //obtenerDocentesPorInstituto(instituto);    
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
            programasHtml.innerHTML= ``;
    
            if (programas.length > 0){
                programas.forEach((item, index) => {
                    programasHtml.innerHTML += `<li class="collection-item"><div>${item}<a href="consultaProgramaFormacion?programa=${item}" class="secondary-content"><i class="material-icons">send</i></a></div></li>`;
                    });
            }else{
                console.log('no hay programas');
            }
        }).catch(error => console.log(' 1) eerr ', error));
        //obtenerDocentesPorInstituto(instituto);    
}
