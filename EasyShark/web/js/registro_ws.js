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
var IdPerfil;

$(function () {
    //cargar todos los Perfiles
    $.ajax({
        url: 'Svl_Perfiles',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'ListarPerfiles'
        },
        success: function (data) {
            $('#ListaDePerfiles').DataTable().destroy();
            $('#ListaDePerfiles').DataTable({
                "data": data,
                "bSort": true,
                "columns": [
                    {data: 'nombre', class: 'txt-center'},
                    {data: 'id', "render": function (data, type, row) {
                            return '<button class="btn btn-sm btn-default icono" title="Menu" onclick="CargarRecursos(' + data + ')"><i class="fa fa-list"></i></button>'
                                    + '<button class="btn btn-sm btn-default icono" title="Menu" onclick="dlgEliminarPerfil(this)"><i class="fa fa-times-circle"></i></button>';
                        }
                    }
                ]
            });
        }
    });

});

function CargarRecursos(id) {
    //capturo la id del perfil
    IdPerfil = id;
    //listo todos los recursos
    $.ajax({
        url: 'Svl_Recursos',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'ListarRecursos'
        },
        success: function (data) {
            $('#ListaRecursos').DataTable().destroy();
            $('#ListaRecursos').DataTable({
                "data": data,
                "bSort": true,
                "columns": [
                    {data: 'id', "render": function (data, type, row) {
                            return '<input type="checkbox" id="' + data + '" value="' + data + '">';
                        }
                    },
                    {data: 'titulo', class: 'txt-center'}
                ]
            });
            marcarRecursos(id);
        }
    });

}
function marcarRecursos(id) {
    $.ajax({
        url: 'Svl_Recursos',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'ListarRecursosDelPerfil',
            idPerfil: id
        },
        success: function (data) {
            var ListaPerfilesYRecursos = data;
            for (var i = 0; i < ListaPerfilesYRecursos.length; i++) {
                $('#' + ListaPerfilesYRecursos[i].idRecurso).prop('checked', true).change();
            }
        }
    });
    //muestro el modal
    $('#ModalRecursos').modal({'backdrop': 'static'});
}

//codigo Asignar Recursos
function Asignar() {
    var arrPermisos = [];
    $('#ListaRecursos tbody tr').each(function () {
        var input = $(this).find('td:eq(0)').find('input:eq(0)');
        if ($(input).is(':checked')) {
            var id = $(input).attr('id');
            arrPermisos.push(id);
        }
    });

    swal({
        title: "Esta seguro?",
        text: "",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Asignar",
        closeOnConfirm: false
    }, function (isConfirm) {
        if (!isConfirm)
            return;

        $.ajax({
            url: 'Svl_Recursos',
            type: 'POST',
            dataType: 'json',
            beforeSend: function (xhr) {
                swal("Done!", "It was succesfully deleted!", "success");
                $('#ModalRecursos').modal('toggle');
            },
            data: {
                accion: 'AsignarRecursosDelPerfil',
                idPerfil: IdPerfil,
                perfiles: JSON.stringify(arrPermisos)
            },
            success: function (data) {
                swal("Done!", "It was succesfully deleted!", "success");
            }
        });

    });

//    $.ajax({
//        url: 'Svl_Recursos',
//        type: 'POST',
//        dataType: 'json',
//        beforeSend: function (xhr) {
//            swal_procces();
//
//            $('#ModalRecursos').modal('toggle');
//        },
//        data: {
//            accion: 'AsignarRecursosDelPerfil',
//            idPerfil: IdPerfil,
//            perfiles: JSON.stringify(arrPermisos)
//        },
//        success: function (data) {
//            //hacer una ventana de respuesta
//            swal_unprocces();
//        }
//    });
}



