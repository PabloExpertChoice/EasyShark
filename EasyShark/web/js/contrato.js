/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ver(id_empresa){
    alert(id_empresa);
}

function swal_procces(mensaje, titulo, type) {
    swal({
        title: titulo || "Procesando",
        text: (mensaje || "Un momento por favor") + "<br><br><i class='fa fa-spinner fa-pulse fa-3x fa-fw'></i><span class='sr-only'>Loading...</span>",
        html: true,
        type: type || null,
        showConfirmButton: false

    });
}

function swal_unprocces() {
    sweetAlert.close();
}
$(function () {
    $("#contrato1").scroll(function () {
        if ($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
            $('#btnContrato1').prop('disabled', false);
        }
    });
    $("#contrato2").scroll(function () {
        if ($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
            $('#btnContrato2').prop('disabled', false);
        }
    });
    $("#contrato3").scroll(function () {
        if ($(this).scrollTop() + $(this).innerHeight() >= $(this)[0].scrollHeight) {
            $('#btnContrato3').prop('disabled', false);
        }
    });
    setTextToggle('chkSinacofi');
    setTextToggle('chkEquifax');
    setTextToggle('chkTransunion');
});


function setTextToggle(id) {
    $('#' + id).bootstrapToggle(
            {
                on: "SI",
                off: "NO"
            }
    )
}
function abrirModalContrato(id, id_empresa) {
    if ($('#' + id).prop('checked') == false) {
        $('#' + id).prop('checked', true).change();
        $('#modal' + id).modal({backdrop: 'static'});
    } else {
        updateContratacion(id_empresa, id, 0);
    }
}

function updateContratacion(_id_empresa, _tipocontratacion, estadotemp) {
    swal_procces();

    var id_empresa = _id_empresa;
    var tipocontratacion = 0;
    var estado = 0;

    if (_tipocontratacion == "chkSinacofi") {
        tipocontratacion = 1;
    } else if (_tipocontratacion == "chkEquifax") {
        tipocontratacion = 2;
    } else {
        tipocontratacion = 3;
    }

    if (estadotemp == 1) {
        if ($('#' + _tipocontratacion).prop('checked') == true) {
            estado = 1;
        }
    }
    $.ajax({
        url: 'Svl_Contratacion',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'updateContratacion',
            id_empresa: id_empresa,
            id_tipocontratacion: tipocontratacion,
            estado: estado
        },
        success: function (data) {
            if (data == true) {
                swal({
                    title: "OPERACIÓN EXITOSA",
                    text: "Comentario registrado correctamente",
                    type: "success",
                    confirmButtonText: "Bien"
                });
            } else {
                swal({
                    title: "OPERACIÓN FALLIDA",
                    text: "Ha ocurrido un error, intente mas tarde",
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });


}

function setChecked(id, estado) {
    if (estado == 1) {
        $('#' + id).prop('checked', true).change();
    } else {
        $('#' + id).prop('checked', false).change();
    }
}

function confirmarContrato(id) {
    swal_procces();
    $('#' + id).prop('checked', true).change();
    updateContratacion(id_empresa, id, 1);
}

function get_File(id_file) {
    swal({
        title: "Preparando",
        text: "Preparando archivo<br><div class='fall-ball-load la-2x'><div></div><div></div><div></div><div></div><div></div><div></div></div>",
        type: "info",
        html: true,
        showConfirmButton: false
    });
    swal_unprocces();
    get_File_PDF(id_file);
}
var get_File_PDF = function (id_file, boton, funcion, isl) {
    $("#ALERTVIEW .modal-dialog").addClass('modal-lg');
    if (isl) {
        $("#ALERTVIEW .modal-dialog").removeClass('modal-lg');
    }
    $("#ALERTVIEW iframe[name='modalVisualizacionDocFrame']").attr("src", "Svl_Contrato?accion=get-pdf-by-id");
    $("#ALERTVIEW #boton-fun").html(boton || "Cerrar");
    $("#ALERTVIEW #boton-fun").unbind("click");
    $("#ALERTVIEW #boton-fun").on("click", funcion == undefined || funcion == null ? function () {
        return;
    } : funcion);
    $("#ALERTVIEW").modal("show");
};
