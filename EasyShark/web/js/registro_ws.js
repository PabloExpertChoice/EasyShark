var leido = false;
$(function () {
    $('#chboxTerminos').attr('checked', false);
    if (!leido) {
        $('#contrato').scroll(function () {
            if ($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
                leido = true;
                $('#btnContrato').prop('disabled', false);
            }
        });
    }

    var Fn = {
        validaRut: function (rutCompleto) {
            if (!/^[0-9]+[-|‐]{1}[0-9kK]{1}$/.test(rutCompleto))
                return false;
            var tmp = rutCompleto.split('-');
            var digv = tmp[1];
            var rut = tmp[0];
            if (digv == 'K')
                digv = 'k';
            return (Fn.dv(rut) == digv);
        },
        dv: function (T) {
            var M = 0, S = 1;
            for (; T; T = Math.floor(T / 10))
                S = (S + T % 10 * (9 - M++ % 6)) % 11;
            return S ? S - 1 : 'k';
        }
    }

    $('#btnEnviar').click(function () {
        var rut = $('#txtRutEmpresa').val();
        var dv = $('#txtDvEmpresa').val();
        var nombre = $('#txtNomUsuario').val();
        var apellido = $('#txtApeUsuario').val();
        var email = $('#txtEmailCorporativo').val();
        var email2 = $('#txtEmailCorporativo2').val();
        var terminos = $('#chboxTerminos').val();

        rut = rut.replace(/\./g, '');

        var regex = /[\w-\.]{2,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;
        if (rut.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar el rut de la empresa.');
        } else if (dv.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar el dígito verificador.');
        } else if (!Fn.validaRut(rut + '-' + dv)) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('El rut ingresado no es válido.');
        } else if (nombre.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar su nombre.');
        } else if (apellido.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar su apellido.');
        } else if (email.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar su correo corporativo.');
        } else if (email2.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe repetir su correo corporativo.');
        } else if (email != email2) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Los correos no coinciden');
        } else if (!regex.test($('#txtEmailCorporativo').val().trim())) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('El correo ingresado no es válido.');
        } else if (!$('#chboxTerminos').is(':checked')) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe aceptar las condiciones de uso para finalizar la operación.');
        } else {
            $.ajax({
                url: 'Svl_Usuarios',
                type: 'POST',
                dataType: 'json',
                data: {
                    accion: 'crear-empresa',
                    rut: rut,
                    dv: dv,
                    nombre: nombre,
                    apellido: apellido,
                    email: email,
                    terminos: terminos
                }, beforeSend: function (xhr) {
                    $('#btnEnviar').prop('disabled', true);
                    $('#btnEnviar').html('Registrando... <i class="fa fa-spinner fa-spin"></i>');
                }, success: function (data, textStatus, jqXHR) {
                    $('#btnEnviar').prop('disabled', false);
                    $('#btnEnviar').html('Registrar');

                    if (data.estado == 200) {
                        go('Svl_Usuarios', [{id: 'accion', val: 'respuesta-crear-empresa'}, {id: 'msgTipo', val: '1'}], undefined, 'Svl_Usuarios');
                    } else {
                        $('#modalError').modal({backdrop: 'static'});
                        $('#msgError').html(data.descripcion);
                    }
                }
            });
        }
    });
    //codigo de usuario comun
    $('#btnRegistrarUsuComun').click(function () {
        var nombre = $('#txtNomUsuarioComun').val();
        var apellidoPaterno = $('#txtApeUsuarioComun').val();
        var apellidoMaterno = $('#txtAmaUsuarioComun').val();
        var email = $('#txtEmailCorporativoComun').val();
        var email2 = $('#txtEmailCorporativo2Comun').val();
        var status = $('#selectSTATUS').val();
        var perfil = $('#selectPERFIL').val();
        var usuAdmin = $('#usuAdmin').val();
        var regex = /[\w-\.]{2,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;

        if (nombre.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un nombre.');
        } else if (apellidoPaterno.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un apellido paterno.');
        } else if (apellidoMaterno.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un apellido materno.');
        } else if (email.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un correo corporativo.');
        } else if (email2.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe repetir un correo corporativo.');
        } else if (email != email2) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Los correos no coinciden');
        } else if (!regex.test($('#txtEmailCorporativoComun').val().trim())) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('El correo ingresado no es válido.');
        } else {
            $.ajax({
                url: 'Svl_Usuarios',
                type: 'POST',
                dataType: 'json',
                data: {
                    accion: 'crear-usuario-comun',
                    nombre: nombre,
                    apellidoPaterno: apellidoPaterno,
                    apellidoMaterno: apellidoMaterno,
                    email: email,
                    status: status,
                    perfil: perfil,
                    usuAdmin: usuAdmin
                }, beforeSend: function (xhr) {
                    $('#btnRegistrarUsuComun').prop('disabled', true);
                    $('#btnRegistrarUsuComun').html('Registrando... <i class="fa fa-spinner fa-spin"></i>');
                }, success: function (data, textStatus, jqXHR) {
                    $('#btnRegistrarUsuComun').prop('disabled', false);
                    $('#btnRegistrarUsuComun').html('Registrar');

                    if (data.estado == 100) {
                        //aqui va codigo para refrescar la lista de usuarios
                        go('cmd', [{id: 'code', val: 'usuario'}], undefined, 'cmd');
                    } else {
                        $('#modalError').modal({backdrop: 'static'});
                        $('#msgError').html(data.descripcion);
                    }
                }
            });
        }
    });

    //codigo editar usuario comun
    $('#btnEditarUsuComun').click(function () {
        var id = $('#idUsuarioComun').val();
        var nombre = $('#txtEditarNomUsuarioComun').val();
        var apellidoPaterno = $('#txtEditarApeUsuarioComun').val();
        var apellidoMaterno = $('#txtEditarAmaUsuarioComun').val();
        var email = $('#txtEditarEmailCorporativoComun').val();
        var email2 = $('#txtEditarEmailCorporativo2Comun').val();
        var status = $('#selectEditarSTATUS').val();
        var regex = /[\w-\.]{2,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;

        if (nombre.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un nombre.');
        } else if (apellidoPaterno.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un apellido paterno.');
        } else if (apellidoMaterno.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un apellido materno.');
        } else if (email.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe ingresar un correo corporativo.');
        } else if (email2.length === 0) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Debe repetir un correo corporativo.');
        } else if (email != email2) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('Los correos no coinciden');
        } else if (!regex.test($('#txtEditarEmailCorporativoComun').val().trim())) {
            $('#modalError').modal({backdrop: 'static'});
            $('#msgError').html('El correo ingresado no es válido.');
        } else {
            $.ajax({
                url: 'Svl_Usuarios',
                type: 'POST',
                dataType: 'json',
                data: {
                    accion: 'editar-usuario-comun',
                    id: id,
                    nombre: nombre,
                    apellidoPaterno: apellidoPaterno,
                    apellidoMaterno: apellidoMaterno,
                    email: email,
                    status: status,
                }, beforeSend: function (xhr) {
                    $('#btnRegistrarUsuComun').prop('disabled', true);
                    $('#btnRegistrarUsuComun').html('Registrando... <i class="fa fa-spinner fa-spin"></i>');
                }, success: function (data, textStatus, jqXHR) {
                    $('#btnRegistrarUsuComun').prop('disabled', false);
                    $('#btnRegistrarUsuComun').html('Registrar');

                    if (data.estado == 100) {
                        //aqui va codigo para refrescar la lista de usuarios
                        go('cmd', [{id: 'code', val: 'usuario'}], undefined, 'cmd');
                    } else {
                        $('#modalError').modal({backdrop: 'static'});
                        $('#msgError').html(data.descripcion);
                    }
                }
            });
        }
    });
});



function verTerminos() {
    $('#modalTerminos').modal({backdrop: 'static'});
}

function validarContrato(check) {
    if (!leido) {
        $(check).attr('checked', false);
        $('#modalError').modal({backdrop: 'static'});
        $('#msgError').html('Debe leer las condiciones de uso.');
    }

}

