function crearCurso() {
    const nombre = document.querySelector("#nombre").value;
    const desc = document.querySelector("#desc").value;
    const duracion = document.querySelector("#duracion").value;
    const cantHoras =  document.querySelector("#cantHoras").value;
    const creditos =  document.querySelector("#creditos").value;
    const url =  document.querySelector("#url").value;
    const instituto =  document.querySelector("#institutos").value;


    cursosprevios = Array.from(previas.selectedOptions).map( previa => previa.value);
    console.log( "previas: " , cursosprevios);
    categoria = Array.from(categorias.selectedOptions).map( cate => cate.value);

    console.log('canthoras: ', cantHoras);
    console.log('creditos: ', creditos);
    console.log('duracion: ', duracion);

    const fetchUrl = 'altaCurso?nombre=' + nombre +
        '&desc=' + desc +
        '&duracion=' + duracion +
        '&cantHoras=' + cantHoras +
        '&creditos=' + creditos +
        '&url=' + url +
        '&instituto=' + instituto +
        '&previas=' + cursosprevios +
        '&categorias=' + categoria;

    fetch(fetchUrl, {
        method: 'POST',
    }).then( ( res ) => {
        return res.json();
        console.log(`que me devolviste papei `, res);
    }).then((respuesta) => {
        console.log(`respuesta: `, respuesta);
        respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Curso dado de alta!", respuesta.mensaje).then(() => {
                // rediraccinar a otro jsp.
                window.location = baseURL+ '/index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err); } )
}

function crearEdicion() {
    const nombre = document.querySelector("#nombre").value;
    const fechaI = document.querySelector("#fechaInicio").value;
    const fechaF = document.querySelector("#fechaFin").value;
    const instituto = document.querySelector("#instituto").value;
    const cursos = document.querySelector("#curso").value;
    const doc = document.querySelector("#docentes").value;
    docen = Array.from(docentes.selectedOptions).map( doc => doc.value);
    const cupo = document.querySelector("#cupo").value;

    const fetchUrl = 'altaEdicion?nombre=' + nombre +
        '&fechaI=' + fechaI +
        '&fechaF=' + fechaF +
        '&instituto=' + instituto +
        '&cursos=' + cursos +
        '&docentes=' + docen +
        '&cupo=' + cupo;

    fetch(fetchUrl, {
        method: 'POST'
    }).then((res) => {
        return res.json();
        console.log(`que me devolviste papei `, res);
    }).then((respuesta) => {
        console.log(`respuesta: `, respuesta);
        respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Edicion dado de alta!", respuesta.mensaje).then(() => {
                // rediraccinar a otro jsp.
                window.location = baseURL+ '/index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}


function testAlert(){
    swal({
        title: "¿Desea confirmar el alta?",
        text: "Are you very very sure?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((willDelete) => {
            if (willDelete) {
                swal("El curso se ha dado de alta correctamente", {
                    icon: "success",
                });

            } else {
                swal("El alta de curso ha sido cancelada!");
            }
        });
}

function mensajeConfirmacion(titulo, mensaje) {
    return swal({
        title: titulo,
        text: mensaje,
        icon: "success"
    });

}
function mensajeError(titulo, mensaje) {
    return swal({
        title: titulo,
        text: mensaje,
        icon: "error"
    });

}