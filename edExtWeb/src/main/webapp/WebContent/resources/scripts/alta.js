var baseURL = 'http://localhost:8081/edExtWeb/';
function crearPrograma(){
    debugger
    const nombre = document.querySelector("#nombre").value;
    const fechaI = document.querySelector("#fechaInicio").value;
    const fechaF = document.querySelector("#fechaFin").value;
    const desc = document.querySelector("#desc").value;
    const url = document.querySelector("#url").value;
    console.log (url)
    const fetchUrl = 'altaProgramaFormacion?nombre=' + nombre +
        '&desc=' + desc +
        '&fechaI=' + fechaI +
        '&fechaF=' + fechaF +
        '&url=' + url;

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
            mensajeConfirmacion("Programa dado de alta!", respuesta.mensaje).then(() => {
                // rediraccinar a otro jsp.
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err); } )

}



function crearCurso() {
    const nombre = document.querySelector("#nombre").value;
    const desc = document.querySelector("#desc").value;
    const duracion = document.querySelector("#duracion").value;
    const cantHoras =  document.querySelector("#cantHoras").value;
    const creditos =  document.querySelector("#creditos").value;
    const url =  document.querySelector("#url").value;
    const instituto =  document.querySelector("#institutos").value;
    const imagen = document.querySelector("#imagen").value;

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
        '&categorias=' + categoria +
        '&imagen=' + imagen;

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
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err); } )
}

function usuario() {
    const nick = document.querySelector("#nickName").value;
    const nombre = document.querySelector("#nombre").value;
    const apellido = document.querySelector("#apellido").value;
    const correo = document.querySelector("#email").value;
    const passwd = document.querySelector("#password").value;
    const fechan = document.querySelector("#fechaNacimiento").value;
    const tipoUser = document.querySelector("#tipo").value;
    const instituto = document.querySelector("#institutos").value;
    const url = document.querySelector("#url").value;
    let fetchUrl;
    if(tipoUser == 'estudiante') {
        fetchUrl = 'crearUsuario?nickName=' + nick +
            '&nombre=' + nombre +
            '&apellido=' + apellido +
            '&correo=' + correo +
            '&password=' + passwd +
            '&fechaN=' + fechan +
            '&tipoUser=' + tipoUser +
            '&imagen='+ url;

        fetch(fetchUrl, {
            method: 'POST'
        }).then((res) => {
            return res.json();
        }).then((respuesta) => {
            respuesta.codigo //1 o 0
            respuesta.mensaje //mensaje de error o success
            if (respuesta.codigo == 0) {
                mensajeConfirmacion("Estudiante dado de alta!", respuesta.mensaje).then(() => {
                    // rediraccinar a otro jsp.
                    window.location = baseURL + 'index.jsp';
                })
            } else {
                mensajeError("Error en alta", respuesta.mensaje).then(() => {
                    if(respuesta.elemento != null)
                        document.getElementById(respuesta.elemento).focus();
                })
            }
        }).catch((err) => {
            console.error(' paso algo: ', err);
        });
    }else{
        fetchUrl = 'crearUsuario?nickName=' + nick +
            '&nombre=' + nombre +
            '&apellido=' + apellido +
            '&correo=' + correo +
            '&password=' + passwd +
            '&fechaN=' + fechan +
            '&tipoUser=' + tipoUser +
            '&imagen='+ url +
            '&institutos=' + instituto;
        fetch(fetchUrl, {
            method: 'POST'
        }).then((res) => {
            return res.json();
        }).then((respuesta) => {
            respuesta.codigo //1 o 0
            respuesta.mensaje //mensaje de error o success
            if (respuesta.codigo == 0) {
                mensajeConfirmacion("Docente dado de alta!", respuesta.mensaje).then(() => {
                    // rediraccinar a otro jsp.
                    window.location = baseURL + 'index.jsp';
                })
            } else {
                mensajeError("Error en alta", respuesta.mensaje).then(() => {
                    if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                })
            }
        }).catch((err) => {
            console.error(' paso algo: ', err);
        });
    }
}

function inscribirUsuario(edicion) {
    debugger;
    //const edicion = document.querySelector("#nombre").value;

    const fetchUrl = 'inscripcionUE?edicion=' + edicion;
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
            mensajeConfirmacion("Usuario inscripto a edicion!", respuesta.mensaje).then(() => {
                // rediraccinar a otro jsp.
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}

function crearEdicion() {
    const nombre = document.querySelector("#nombre").value;
    const fechaI = document.querySelector("#fechaInicio").value;
    const fechaF = document.querySelector("#fechaFin").value;
    const instituto = document.querySelector("#institutos").value;
    const cursos = document.querySelector("#curso").value;
    const doc = document.querySelector("#docentes").value;
    docen = Array.from(docentes.selectedOptions).map( doc => doc.value);
    const cupo = document.querySelector("#cupo").value;
    const url = document.querySelector("#url").value;

    const fetchUrl = 'altaEdicion?nombre=' + nombre +
        '&fechaI=' + fechaI +
        '&fechaF=' + fechaF +
        '&instituto=' + instituto +
        '&cursos=' + cursos +
        '&docentes=' + docen +
        '&cupo=' + cupo +
        '&imagen=' + url;

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
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}

function inscribirUsuario(nombreEdi) {

    const fetchUrl = 'inscripcionUE?edicion=' + nombreEdi;
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
            mensajeConfirmacion("Usuario inscripto a edicion!", respuesta.mensaje).then(() => {
                // rediraccinar a otro jsp.
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error en alta", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}

function agregarCursoPrograma(nomCurso, nomPrograma) {

    console.log("nombreCurso " + nomCurso + ", " + "nombrePrograma " + nomPrograma);
    const fetchUrl = 'agregarCursoPrograma?curso=' + nomCurso +
        '&programa=' + nomPrograma;
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
            mensajeConfirmacion("Curso agregado a programa!", respuesta.mensaje).then(() => {
                // rediraccinar a otro jsp.
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error al agregar curso a programa", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}
function inscribirUsuarioProg(nombreProg) {

    console.log(nombreProg);
    const fetchUrl = 'inscripcionPrograma?programa=' + nombreProg;
    fetch(fetchUrl, {
        method: 'POST'
    }).then((res) => {
        return res.json();
    }).then((respuesta) => {
        respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Usuario inscripto al Programa!", respuesta.mensaje).then(() => {

                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error en inscripcion", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}

function seguirUsuario(nickname) {
    console.log(nickname);
    const fetchUrl = 'seguirUsuario?nicknameSeguir=' + nickname;
    fetch(fetchUrl, {
        method: 'POST'
    }).then((res) => {
        return res.json();
    }).then((respuesta) => {
        respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Usuario seguido!", respuesta.mensaje).then(() => {

                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error al seguir usuario", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                });
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}

function dejarSeguirUsuario(nickname) {
    console.log("quiere dejar de seguir a =" + nickname);
    const fetchUrl = 'dejarSeguirUsuario?nicknameDejarSeguir=' + nickname;
    fetch(fetchUrl, {
        method: 'POST'
    }).then((res) => {
        return res.json();
    }).then((respuesta) => {
        respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Usuario dejado de seguir!", respuesta.mensaje).then(() => {

                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error al dejar de seguir usuario", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
                    document.getElementById(respuesta.elemento).focus();
                }
            )
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    });
}

function confirmarInscripcion(edicion, usuario, action) {
    debugger;
    console.log("la edicion es= " + edicion);
    console.log("el usuario es= " + usuario);
    console.log("la action es= " + action);
    const fetchUrl = 'inscripcionConfirmar?edicion=' + edicion +
        '&usuario=' + usuario +
        '&action=' + action;
    fetch(fetchUrl, {
        method: 'POST'
    }).then((res) => {
        return res.json();
    }).then((respuesta) => {
        respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Inscripcion cambiada!", respuesta.mensaje).then(() => {

                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error al cambiar inscripcion", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null)
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