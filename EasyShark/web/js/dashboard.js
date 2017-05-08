var QUIEBRA = undefined;
var nombre = '';
var apePaterno = '';
var apeMaterno = '';
var rut = '';
var dv = '';
var idUsuario = 0;
var idCliente = 0;
var tblPjud;
var arrPjud;
var renta = 0;
var datosFormCaptcha = {};
var iframeCargado = false;

function verModalPJUD() {
    $('#modalPJUD .modal-dialog .modal-content .modal-body object').remove();
    $('#modalPJUD').modal({'backdrop': 'static'});
    $('#tblPjudCont').show();
    $('#modalPJUD .modal-dialog .modal-content .modal-header .modal-title').html(nombre + ' ' + apePaterno + ' ' + apeMaterno);
}




function verPdfPjud(icono) {
    $('#tblPjudCont').hide();
    var ob = tblPjud.row($(icono).parents('tr')).data();
    var objbuilder = '';
    objbuilder = ' <object width="100%" height="500px" data="' + ob.documentoDemanda + '"></object> ';
    $('#modalPJUD .modal-dialog .modal-content .modal-body').append(objbuilder);
}

function format(d) {
    return '<center><table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td>Archivo</td>' +
            '<td><i class="' + d.icono + '"></i></td>' +
            '</tr>' +
            '<tr>' +
            '<td>Extension number:</td>' +
            '<td>' + d.extn + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>Extra info:</td>' +
            '<td>And any further details here (images etc)...</td>' +
            '</tr>' +
            '</table></center>';
}

$('#tblPJUD tbody').on('click', 'td.details-control', function () {
    var tr = $(this).closest('tr');
    var row = tblPjud.row(tr);
    if (row.child.isShown()) {
        row.child.hide();
        tr.removeClass('shown');
    } else {
        row.child(format(row.data())).show();
        tr.addClass('shown');
    }
});


/**
 * 
 * @param {type} _rut
 * @param {type} _dv
 * @returns {undefined}
 */
function getScore(_rut, _dv) {
    $.ajax({
        url: 'Svl_Scoring',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'scoring',
            rut: _rut,
            dv: _dv
        },
        success: function (data, textStatus, jqXHR) {
            if (data.estado === 200) {
                var point = $('#contenedor').highcharts().series[0].points[0];
                var new_value = data.datos.mes1;
                point.update(new_value);
                var _mes1 = parseInt(data.datos.mes2);
                if (_mes1 < 999 & _mes1 > 500) {
                }

                $('#grafico1').data('easyPieChart').update(40);

                $('#gauge1').html(parseInt(data.datos.mes2));
                $('#gauge2').html((data.datos.mes3));
                $('#gauge3').html((data.datos.mes4));
            }
        }
    });
}

/**
 * 
 * @param {type} _rut
 * @param {type} _dv
 * @returns {undefined}
 */
function getScoreValue(_rut, _dv) {

    var resultado = 0;
    $.ajax({
        url: 'Svl_Scoring',
        type: 'POST',
        async: false,
        dataType: 'json',
        data: {
            accion: 'scoring',
            rut: _rut,
            dv: _dv
        },
        success: function (data, textStatus, jqXHR) {
            if (data.estado === 200) {
                resultado = data.datos.mes1;
            }
        }
    });

    return resultado;
}

/**
 * Va al servlert Svl_Cliente y se traen los datos de SANCTION SEARCH OFACT TREAS
 * 
 * @param {type} _nombre
 * @param {type} _apePaterno
 * @param {type} _apeMaterno
 * @returns {undefined}
 */
function buscarDatosOfac(_nombre, _apePaterno, _apeMaterno) {
    $.ajax({
        url: 'Svl_Cliente',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'getDatosOfac',
            nombre: _nombre + ' ' + _apePaterno + ' ' + _apeMaterno,
        },
        beforeSend: function (xhr) {
            $('#boxOfac .info-box-content .info-box-number').html('<i class="fa fa-spinner fa-spin"></i>');
        },
        success: function (data, textStatus, jqXHR) {
            if (data.estado === 200) {
                var datos = data.datos;
                if (datos.length > 0) {
                    $('#boxOfac .info-box-content .info-box-number').html('Yes');
                } else {
                    $('#boxOfac .info-box-content .info-box-number').html('No');
                }
                $('#tblResultadosOfac').DataTable().rows.add(datos).draw(false);
            }
        }
    });
}
function verModalOfac() {
    $('#modalOfac').modal({backdrop: 'static'});
    $('#modalOfac .modal-dialog .modal-content .modal-header .modal-title').html(nombre + ' ' + apePaterno + ' ' + apeMaterno);
}

/**
 * Carga las acticidades comerciales del cliente (si los tiene)
 * 
 * @param {type} _rut
 * @param {type} _dv
 * @returns {undefined}
 */
function buscarActividadComercial(_rut, _dv) {
    $.ajax({
        url: 'Svl_Cliente',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'getActividadComercial',
            rut: _rut,
            dv: _dv,
        },
        beforeSend: function (xhr) {
            $('#boxActividadComercial .info-box-content .info-box-number').html('<i class="fa fa-spinner fa-spin"></i>');
        },
        success: function (data, textStatus, jqXHR) {
            $('#boxActividadComercial .info-box-content .info-box-number').html('-');
            if (data.estado === 200) {
                var datos = data.datos;
                $('#siiNroDoc').attr('data-value', datos.numDocTimbrados);

                $('#boxActividadComercial .info-box-content .info-box-number').html(datos.inicioActividades);
                $('#tblActComercial').DataTable().rows.add(datos.actividadEconomica).draw(false);
                $('#tblActComercial1 tr:eq(0) td').html(new Date().toLocaleDateString());
                $('#tblActComercial1 tr:eq(1) td').html(datos.inicioActividades);
                $('#tblActComercial1 tr:eq(2) td').html(datos.autorizadoPagarMonedaExtrangera);
                $('#tblActComercial1 tr:eq(3) td').html(datos.empresaMenorTamano);
                $('#tblActComercial1 tr:eq(4) td').html(datos.numDocTimbrados);
                $('#tblActComercial1 tr:eq(5) td').html(datos.numObs);
            }
        }
    });
}

/**
 * Ver modal actividad comercial
 * @returns {undefined}
 */
function verModalAC() {
    $('#modalActividadComercial').modal({backdrop: 'static'});
    $('#modalActividadComercial .modal-dialog .modal-content .modal-header .modal-title').html(nombre + ' ' + apePaterno + ' ' + apeMaterno);
}

//////////////////////////////Informacion previsional(AFP)/////////////////////////////////
function cargaIframe(_rut, _dv, _nombre, _apePaterno, _apeMaterno, _idCliente) {
    $('#modalAfp .modal-dialog .modal-content .modal-header .modal-title').html(_nombre + ' ' + _apePaterno + ' ' + _apeMaterno);
    $('#modalAfp .modal-dialog .modal-content .modal-footer .btn-primary').show();
    swal_procces();
    if (!iframeCargado) {
        $.ajax({
            url: 'Svl_Cliente',
            type: 'POST',
            dataType: 'json',
            data: {
                accion: 'cargaIframe',
                rut: _rut,
                dv: _dv,
                apePat: _apePaterno,
                idCliente: _idCliente
            }, beforeSend: function (xhr) {
                $('#boxAfp .info-box-content .info-box-number').html('<i class="fa fa-spinner fa-spin"></i>');
                $('#modalAfp .modal-dialog .modal-content .modal-body').html('Cargando datos<i class="fa fa-spinner fa-spin"></i>');
            }, success: function (data, textStatus, jqXHR) {
                $('#boxAfp .info-box-content .info-box-number').html('&nbsp;');
                if (data.estado == 200) {
                    datosFormCaptcha = data.datos;
                    iframeCargado = true;
                    if (data.datos.enCache) {
                        var objbuilder = '';
                        objbuilder += ('<object width="100%" height="500px" data="data:application/pdf;base64,');
                        objbuilder += (data.datos.basePdf);
                        objbuilder += ('" type="application/pdf" class="internal">');
                        objbuilder += ('<embed src="data:application/pdf;base64,');
                        objbuilder += (data.datos.basePdf);
                        objbuilder += ('" type="application/pdf" />');
                        objbuilder += ('</object>');

                        $('#modalAfp .modal-dialog .modal-content .modal-body').html(objbuilder);
                        $('#modalAfp .modal-dialog .modal-content .modal-footer .btn-primary').hide();

                        var nro = data.datos.afp;
                        console.log(nro);
                        $('#nombreAfp').attr('data-value', data.datos.afp);
                    } else {
                        var form = '<form role="form">' +
                                '    <div class="row">' +
                                '        <div class="form-group col-xs-10 col-md-3">' +
                                '            <label>RUT:</label>' +
                                '            <input type="text" class="form-control" disabled value="' + datosFormCaptcha.rut + '">' +
                                '        </div>' +
                                '        <div class="form-group col-xs-2 col-md-1">' +
                                '            <label>&nbsp;</label>' +
                                '            <input style="padding: 0px; text-align: center;" type="text" class="form-control" disabled value="' + datosFormCaptcha.dv + '">' +
                                '        </div>' +
                                '    </div>' +
                                '    <div class="row">' +
                                '        <div class="form-group col-md-4">' +
                                '            <label>Apellido Paterno</label>' +
                                '            <input type="text" class="form-control" value="' + datosFormCaptcha.apePat + '" id="apePat" >' +
                                '        </div>' +
                                '    </div>' +
                                '    <div class="row">' +
                                '        <div class="form-group col-md-4">' +
                                '            <label>Resolver Captcha</label><br/>' +
                                '            <div id="imgimg"></div><br/>' +
                                '            <input type="text" class="form-control" id="imagenCaptcha">' +
                                '        </div>' +
                                '    </div>' +
                                '</form>';
                        $('#modalAfp .modal-dialog .modal-content .modal-body').html(form);


                        var img = document.createElement("img");
                        img.src = "data:image/png;base64," + datosFormCaptcha.base;
                        document.getElementById('imgimg').appendChild(img);
                    }
                }
            }
        });
    } else {
        if (datosFormCaptcha.datos.enCache) {
            var objbuilder = '';
            objbuilder += ('<object width="100%" height="500px" data="data:application/pdf;base64,');
            objbuilder += (data.datos.basePdf);
            objbuilder += ('" type="application/pdf" class="internal">');
            objbuilder += ('<embed src="data:application/pdf;base64,');
            objbuilder += (data.datos.basePdf);
            objbuilder += ('" type="application/pdf" />');
            objbuilder += ('</object>');

            $('#modalAfp .modal-dialog .modal-content .modal-body').html(objbuilder);
            $('#modalAfp .modal-dialog .modal-content .modal-footer .btn-primary').hide();
        } else {
            var form = '<form role="form">' +
                    '    <div class="row">' +
                    '        <div class="form-group col-xs-10 col-md-3">' +
                    '            <label>RUT:</label>' +
                    '            <input type="text" class="form-control" disabled value="' + datosFormCaptcha.rut + '">' +
                    '        </div>' +
                    '        <div class="form-group col-xs-2 col-md-1">' +
                    '            <label>&nbsp;</label>' +
                    '            <input style="padding: 0px; text-align: center;" type="text" class="form-control" disabled value="' + datosFormCaptcha.dv + '">' +
                    '        </div>' +
                    '    </div>' +
                    '    <div class="row">' +
                    '        <div class="form-group col-md-4">' +
                    '            <label>Apellido Paterno</label>' +
                    '            <input type="text" class="form-control" value="' + datosFormCaptcha.apePat + '" id="apePat" >' +
                    '        </div>' +
                    '    </div>' +
                    '    <div class="row">' +
                    '        <div class="form-group col-md-4">' +
                    '            <label>Resolver Captcha</label><br/>' +
                    '            <img id="imgimg" src="' + datosFormCaptcha.urlImagen.replace('http:/', 'https:/') + '&fecha=1asdasdasd"/><br/>' +
                    '            <input type="text" class="form-control" id="imagenCaptcha">' +
                    '        </div>' +
                    '    </div>' +
                    '</form>';
            $('#modalAfp .modal-dialog .modal-content .modal-body').html(form);
            var img = document.createElement("img");
            img.src = "data:image/png;base64," + datosFormCaptcha.base;
            document.getElementById('imgimg').appendChild(img);
        }
    }
    swal_unprocces();
}




function enviarDatosAfp(button) {
    var htmlButton = $(button).html();
    $.ajax({
        url: 'Svl_Cliente',
        type: 'post',
        dataType: 'json',
        data: {
            accion: 'enviarFormulario',
            imagen: $('#imagenCaptcha').val(),
            apePat: $('#apePat').val()
        },
        beforeSend: function (xhr) {
            $(button).prop('disabled', true);
            $(button).html('Cargando datos... <i class="fa fa-spinner fa-spin"></i>');
        }, success: function (data) {
            $(button).prop('disabled', false);
            $(button).html(htmlButton);
            if (data.estado == 200) {
                var objbuilder = '';
                objbuilder += ('<object width="100%" height="500px" data="data:application/pdf;base64,');
                objbuilder += (data.datos.basePdf);
                objbuilder += ('" type="application/pdf" class="internal">');
                objbuilder += ('<embed src="data:application/pdf;base64,');
                objbuilder += (data.datos.basePdf);
                objbuilder += ('" type="application/pdf" />');
                objbuilder += ('</object>');

                $('#modalAfp .modal-dialog .modal-content .modal-body').html(objbuilder);
                $('#modalAfp .modal-dialog .modal-content .modal-footer .btn-primary').hide();
            } else {
                $('#modalAfp .modal-dialog .modal-content .modal-body').html('No registra datos asociados');
            }
        }
    });
    return false;
}

function verInfoPrevisional() {
    $('#modalAfp').modal({backdrop: 'static'});
}

/**
 * 
 * @param {type} _rut
 * @param {type} _dv
 * @returns {undefined}
 */
function validarQuiebra(_rut, _dv) {
    $.ajax({
        url: 'Svl_Cliente',
        type: 'POST',
        dataType: 'json',
        data: {
            accion: 'validarQuiebra',
            rut: _rut,
            dv: _dv
        }, beforeSend: function (xhr) {
            $('#boxQuiebras .info-box-number').html('<i class="fa fa-spinner fa-spin"></i>');
        }, success: function (data, textStatus, jqXHR) {
            if (data.estado == 200) {
                QUIEBRA = data.datos;
                $('#boxQuiebras .progress .progress-bar').css({width: '50%'});
                $('#boxQuiebras .info-box-number').html(data.datos.fechaPublicacion);
            } else {
                $('#boxQuiebras .info-box-number').css({'font-size': '15px'});
                $('#boxQuiebras .info-box-number').html('No registra datos asociados');
            }
        }
    });
}

function verListadoQuiebras() {
    $('#modalQuiebras .modal-dialog .modal-content .modal-header .modal-title').html(nombre + ' ' + apePaterno + ' ' + apeMaterno);
    $('#modalQuiebras .modal-dialog .modal-content .msgTbl').html('');
    $('#modalQuiebras .modal-dialog .modal-content table').hide();

    if (QUIEBRA != undefined) {
        $('#modalQuiebras .modal-dialog .modal-content table').show();
//        $('#tdDomicilio').html();
//        $('#tdRegion').html();
        $('#tdFechaDeclaratoria').html(QUIEBRA.fechaDeclaratoria);
        $('#tdFechaPublicacion').html(QUIEBRA.fechaPublicacion);
        $('#tdTribunal').html(QUIEBRA.tribunal);
        $('#tdRolCausa').html(QUIEBRA.rolCausa);
        $('#tdSindico').html(QUIEBRA.sindico);
    } else {
        $('#modalQuiebras .modal-dialog .modal-content .msgTbl').html('No registra datos asociados');
    }

    $('#modalQuiebras').modal();
}
