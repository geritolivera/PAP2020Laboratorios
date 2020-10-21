var url = 'http://localhost:8081/edExtWeb/'
function inicioSesion(){
    Swal.fire({
        title: 'Inicia Sesion',
        html: '<input type="text" id="username" class="swal2-input" placeholder="Enter your username"></input>' +
            '<input type="password" id="password" class="swal2-input" placeholder="Enter your password"></input>',
        confirmButtonText: 'Ingresar',
        preConfirm: () => {
            let username = Swal.getPopup().querySelector('#username').value
            let password = Swal.getPopup().querySelector('#password').value
            if (username === '' || password === '') {
                Swal.showValidationMessage(`Nickname/Password vacios`)
            }
        }
    }).then((result) => {
        let username = Swal.getPopup().querySelector('#username').value
        let password = Swal.getPopup().querySelector('#password').value
        var urlLogin = url + 'login?nickname='+ username +'&password=' + password;
        fetch(urlLogin, {
            method: 'POST',
        }).then((res) => {
            return res.json();
        }).then((respuesta) => {respuesta.codigo //1 o 0
            respuesta.mensaje //mensaje de error o success
            if (respuesta.codigo == 0) {
                mensajeConfirmacion("Bienvenido!", respuesta.mensaje).then(() => {
                    window.location = baseURL+ 'index.jsp';
                })
            } else {
                mensajeError("Error al iniciar sesion", respuesta.mensaje).then(() => {
                    if(respuesta.elemento != null) {
                        document.getElementById(respuesta.elemento).focus();
                    }
                });
            }
        }).catch((err) => {
            console.error(' paso algo: ', err);
        })
    })}


function logout(){
    var urlLogout = url + 'logout';
    fetch(urlLogout, {
        method: 'GET',
    }).then((res) => {
        return res.json();
    }).then((respuesta) => {respuesta.codigo //1 o 0
        respuesta.mensaje //mensaje de error o success
        if (respuesta.codigo == 0) {
            mensajeConfirmacion("Su sesion ha sido cerrada con exito!", respuesta.mensaje).then(() => {
                window.location = baseURL+ 'index.jsp';
            })
        } else {
            mensajeError("Error al cerrar sesion", respuesta.mensaje).then(() => {
                if(respuesta.elemento != null) {
                    document.getElementById(respuesta.elemento).focus();
                }
            });
        }
    }).catch((err) => {
        console.error(' paso algo: ', err);
    })

}