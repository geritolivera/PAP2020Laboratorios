$(document).ready(function (){
    $('#institutos').change(function (){
        $.ajax({
            url: '/src/GetListas',
            type: 'post',
            data: "tipo = 'institutos'",
            success: function (response){
                var len = response.length;
                $('institutos').empty();
                for(var i=0; i<len ; i++){
                    var inst = response[i];

                    $("#institutos").append("<option value='"+inst+"'>"+inst+"</option>")
                }
            }
        })
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
var xhr;
var baseURL = '/edExtWeb_war/';

function ejecutarAlert(){
    Swal.fire(
        'Good job!',
        'You clicked the button!',
        'success'
    )
}

function cerrarMensaje(){
    console.log("Elimino mensaje...")
    document.getElementById("mensaje").style.display = "none";
}


function obtenerCursosPorInstituto(instituto){
    // Parametro:

    console.log("instituto: ", instituto);
    var url = `GetCursoInst?instituto=${instituto}`

    fetch(url)
        .then( (res) => {
            return res.json();
        })
        .then(cursos => {
            console.log("cursos:", cursos);
            var cursosHtml = document.getElementById("curso");

            cursosHtml.innerHTML = '';

            if (cursos.length > 0){
                cursos.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    cursosHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                    });
                $('#curso').formSelect();
            }else{
                console.log('no hay tipos de recursos');
                cursosHtml.innerHTML += `<h5>No hay tipos de recursos en el sistema.}</h5>`;
            }


        }).catch(error => console.log(' 1) eerr ', error));
     //obtenerDocentesPorInstituto(instituto);

}

function obtenerDocentesPorInstituto(instituto){

    console.log("instituto: ", instituto
    );
    var url = `GetDocInst?instituto=${instituto}`

    fetch(url)
        .then( (responsed) => {
            console.log(" docentes: ", responsed);
            return responsed.json();
        })
        .then(docentes => {
            console.log("docentes:", docentes);
            var docentesHtml = document.getElementById("docentes");

            docentesHtml.innerHTML = '';

            if (docentes.length > 0){
                docentes.forEach((item, index) => {
                    console.log(" Re item: " + JSON.stringify(item) + " index: " + index);
                    docentesHtml.innerHTML += `<option value="${item}"> ${item}</option>`;
                });
                $('#docentes').formSelect();
            }else{
                console.log('no hay docentes');
                docentesHtml.innerHTML += `<h5>No hay docentes en el sistema.}</h5>`;
            }


        }).catch(error => console.log(' 2) eerr ', error));
}