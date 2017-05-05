<%@page import="cl.expertchoice.clases.Subsidiary"%>
<%@page import="soporte.D"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->

<%@page import="cl.expertchoice.clases.Usuario"%>
<%@page import="org.json.JSONObject"%>

<%
    if (!D.isSesionActiva(request)) {
        response.sendRedirect("cmd");
        return;
    }

%>
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <!-- Mirrored from keenthemes.com/preview/metronic/theme/admin_4/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Mar 2017 15:40:53 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8" />
        <title>Usuarios</title>
        <link rel="shortcut icon" href="images/logo1.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #4 for statistics, charts, recent events and reports" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <!--css alert-->
        <link rel="stylesheet" type="text/css" href="dist/css/sweetalert.css">
        <link rel="stylesheet" type="text/css" href="css/loading.css">

        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css" />
        <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <link href="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css" />
        <!-- END PAGE LEVEL PLUGINS -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="assets/layouts/layout4/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/layouts/layout4/css/themes/default.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/layouts/layout4/css/custom.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="favicon.ico" /> 

        <style>
            html {
                position: relative;
                min-height: 100%;
            }
            body {
                /* Margin bottom by footer height */
                margin-bottom: 60px;
            }
            .footer {
                position: absolute;
                bottom: 0;
                width: 100%;
                height: 30px;
                background-color: #f5f5f5;
            }

            /* centered columns styles */
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                width: 100%;
                /* reset the text-align */
                text-align:left;
                /* inline-block space fix */
                margin-right:-4px;
            }

        </style>

    </head>
    <!-- END HEAD -->

    <body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
        <!-- BEGIN HEADER -->
        <jsp:include page="seccion/head.jsp"></jsp:include>


            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <!-- BEGIN SIDEBAR -->
            <jsp:include page="seccion/sidebar.jsp"></jsp:include>
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <!-- BEGIN CONTENT BODY -->
                    <div class="page-content">
                        <!-- BEGIN PAGE HEAD-->
                        <div class="page-head">
                            <!-- BEGIN PAGE TITLE -->
                            <div class="page-title">
                                <h1>Usuarios</h1>
                            </div>
                            <!-- END PAGE TITLE -->
                        </div>
                        <!-- END PAGE HEAD-->

                        <!-- Ruta-->
                        <ul class="page-breadcrumb breadcrumb">
                            <li>
                                <a href="index.jsp">Inicio</a>
                            </li>
                            <i class="fa fa-circle"></i>
                            <li>
                                Usuarios
                            </li>
                        </ul>
                        <!-- Fin ruta -->

                        <!-- BEGIN PAGE BASE CONTENT -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="portlet light">
                                    <div class="portlet-title">
                                        <div class="caption">
                                        </div>
                                        <div class="tools">
                                            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div style="margin-bottom: 0.1cm;">
                                                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Nuevo Usuario</button>
                                                </div>
                                                <div id="tblUsuarios_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <div class="portlet box blue">
                                                                <div class="portlet-body">
                                                                    <div class="table-scrollable">

                                                                    <%-- comienza la tabla --%>

                                                                    <table id="ListaDeUsuarios" class="table table-bordered dataTable no-footer" style="width: 1581px;">
                                                                        <thead>
                                                                            <tr>
                                                                                <th >Email</th>
                                                                                <th >Nombre</th>
                                                                                <th >Apellido Paterno</th>
                                                                                <th >Apellido Materno</th>
                                                                                <th >Estado</th>
                                                                                <th >Perfil</th>
                                                                                <th >Opción</th>
                                                                            </tr>
                                                                        </thead>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END CONTENT BODY -->
                    </div>
                    <!-- END CONTENT -->
                </div>
                <!-- END CONTAINER -->
                <div id="myModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Crear Nuevo Usuario</h4>
                            </div>

                            <div class="modal-body">
                                <div class="row row-centered" style="padding: 10px;">
                                    <div class="col-md-3 col-xs-12 col-centered" style="margin: 0 auto;">
                                        <form role="form" action="javascript:;">
                                            <div class="form-group">
                                                <label for="txtNomUsuarioComun">Nombre usuario</label>
                                                <input type="text" class="form-control" id="txtNomUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtApeUsuarioComun">Apellido Paterno</label>
                                                <input type="text" class="form-control" id="txtApeUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtAmaUsuarioComun">Apellido Materno</label>
                                                <input type="text" class="form-control" id="txtAmaUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEmailCorporativoComun">Correo corporativo</label>
                                                <input type="email" class="form-control" id="txtEmailCorporativoComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEmailCorporativo2Comun">Repetir correo corporativo</label>
                                                <input type="email" class="form-control" id="txtEmailCorporativo2Comun" >
                                            </div>

                                            <div class="form-group">
                                                <label for="txtEstado">Estado</label>
                                                <select id="selectSTATUS"></select>
                                            </div>
                                            <div class="form-group">
                                                <label for="txtPerfil">Perfil</label>
                                                <select id="selectPERFIL"></select>
                                            </div>

                                            <button type="submit" class="btn btn-primary" id="btnRegistrarUsuComun">Registrar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            </form>
                        </div>

                    </div>
                </div>

                <%-- EDITAR USUARIO COMUN --%>
                <div id="ModalUsuarioComun" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                                <h4 class="modal-title">Editar Nuevo Usuario</h4>
                            </div>

                            <div class="modal-body">
                                <div class="row row-centered" style="padding: 10px;">
                                    <div class="col-md-3 col-xs-12 col-centered" style="margin: 0 auto;">
                                        <form role="form" action="javascript:;">
                                            <div class="form-group">
                                                <label for="txtEditarNomUsuarioComun">Nombre usuario</label>
                                                <input type="text" class="form-control" id="txtEditarNomUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEditarApeUsuarioComun">Apellido Paterno</label>
                                                <input type="text" class="form-control" id="txtEditarApeUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEditarAmaUsuarioComun">Apellido Materno</label>
                                                <input type="text" class="form-control" id="txtEditarAmaUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEditarEmailCorporativoComun">Correo corporativo</label>
                                                <input type="email" class="form-control" id="txtEditarEmailCorporativoComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEditarEmailCorporativo2Comun">Repetir correo corporativo</label>
                                                <input type="email" class="form-control" id="txtEditarEmailCorporativo2Comun" >
                                                <input type="hidden" class="form-control" id="idUsuarioComun" >
                                            </div>
                                            <div class="form-group">
                                                <label for="txtEstado">Estado</label>
                                                <select id="selectEditarSTATUS"></select>
                                            </div>
                                            <button type="submit" class="btn btn-primary" id="btnEditarUsuComun">Editar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            </form>
                        </div>

                    </div>
                </div>

                <div class="modal" id="modalError">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body">
                                <p id="msgError" style="font-size: 15px;"></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- BEGIN FOOTER -->
                <div class="page-footer">
                    <jsp:include page="seccion/footer.jsp"></jsp:include>
                </div>
                <!-- END FOOTER -->


                <!-- BEGIN CORE PLUGINS -->
                <script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
                <script src="js/funciones.js"></script>
                <script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/moment.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/bootstrap-daterangepicker/daterangepicker.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/counterup/jquery.counterup.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/pie.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/radar.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/themes/light.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/themes/patterns.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amcharts/themes/chalk.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/ammap/ammap.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/ammap/maps/js/worldLow.js" type="text/javascript"></script>
                <script src="assets/global/plugins/amcharts/amstockcharts/amstock.js" type="text/javascript"></script>
                <script src="assets/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/horizontal-timeline/horizontal-timeline.js" type="text/javascript"></script>
                <script src="assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
                <script src="assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
                <!-- END PAGE LEVEL PLUGINS -->
                <!-- BEGIN THEME GLOBAL SCRIPTS -->
                <script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
                <!-- END THEME GLOBAL SCRIPTS -->
                <!-- BEGIN PAGE LEVEL SCRIPTS -->
                <script src="assets/pages/scripts/dashboard.min.js" type="text/javascript"></script>
                <!-- END PAGE LEVEL SCRIPTS -->
                <!-- BEGIN THEME LAYOUT SCRIPTS -->
                <script src="assets/layouts/layout4/scripts/layout.min.js" type="text/javascript"></script>
                <script src="assets/layouts/layout4/scripts/demo.min.js" type="text/javascript"></script>
                <script src="assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
                <script src="assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
                <!-- END THEME LAYOUT SCRIPTS -->
                <!-- Google Code for Universal Analytics -->
                <!-- End -->

                <script src="js/sidebar.js"></script>
                <script src="plugins/jsPlumb/lib/jsBezier-0.8.js"></script>
                <script src="plugins/jsPlumb/lib/mottle-0.7.4.js"></script>
                <script src="plugins/jsPlumb/lib/biltong-0.3.js"></script>
                <script src="plugins/jsPlumb/lib/katavorio-0.18.0.js"></script>
                <script src="plugins/jsPlumb/src/util.js"></script>
                <script src="plugins/jsPlumb/src/browser-util.js"></script>
                <script src="plugins/jsPlumb/jsPlumb.js"></script>
                <script src="plugins/jsPlumb/src/dom-adapter.js"></script>
                <script src="plugins/jsPlumb/src/overlay-component.js"></script>
                <script src="plugins/jsPlumb/src/endpoint.js"></script>
                <script src="plugins/jsPlumb/src/connection.js"></script>
                <script src="plugins/jsPlumb/src/anchors.js"></script>
                <script src="plugins/jsPlumb/src/defaults.js"></script>
                <script src="plugins/jsPlumb/src/connectors-bezier.js"></script>
                <script src="plugins/jsPlumb/src/connectors-statemachine.js"></script>
                <script src="plugins/jsPlumb/src/connectors-flowchart.js"></script>
                <script src="plugins/jsPlumb/src/connectors-straight.js"></script>
                <script src="plugins/jsPlumb/src/renderers-svg.js"></script>
                <script src="plugins/jsPlumb/src/base-library-adapter.js"></script>
                <script src="plugins/jsPlumb/src/dom.jsPlumb.js"></script>  
                <!--Script alert-->
                <script src="dist/js/sweetalert.min.js"></script>
                <script src="js/swall.js"></script>
                <!--            <script src="plugins/jsplumb.js"></script>  -->
                <script src="js/politicas.js"></script>

                <script src="js/jquery-2.1.3.min.js"></script>
                <script src="js/number_format.js"></script>
                <script src="js/bootstrap.min.js"></script>
                <script src="dist/js/app.min.js"></script>
                <script src="DataTables/datatables.min.js" type="text/javascript"></script>
                <script type="text/javascript"></script>
                <script src="js/registro_ws.js"></script>

                <script>
                    $(function () {

                        swal_procces();
                        $.ajax({
                            url: 'Svl_Usuarios',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: 'ListaEstado'
                            },
                            success: function (data) {
                                for (var i = 0; i < data.length; i++) {
                                    $('#selectSTATUS').append('<option value=' + data[i]['id'] + '>' + data[i]['nombre'] + '</option>');
                                    $('#selectEditarSTATUS').append('<option value=' + data[i]['id'] + '>' + data[i]['nombre'] + '</option>');
                                }

                            }
                        });
                        $.ajax({
                            url: 'Svl_Usuarios',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: 'ListaPerfil'
                            },
                            success: function (data) {
                                for (var i = 2; i < data.length; i++) {
                                    $('#selectPERFIL').append('<option value=' + data[i]['id'] + '>' + data[i]['nombre'] + '</option>');

                                }

                            }
                        });
                        //cargar todos los usuarios del administrador
                        $.ajax({
                            url: 'Svl_Usuarios',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: 'ListarUsuarios'
                            },
                            success: function (data) {
                                $('#ListaDeUsuarios').DataTable().destroy();
                                $('#ListaDeUsuarios').DataTable({
                                    "data": data,
                                    "bSort": true,
                                    "columns": [
                                        {data: 'email', class: 'txt-center'},
                                        {data: 'nombre', class: 'txt-center'},
                                        {data: 'apePaterno', "render": function (data, type, row) {
                                                if (data == null) {
                                                    return '';
                                                } else {
                                                    return data;
                                                }
                                            }},
                                        {data: 'apeMaterno', "render": function (data, type, row) {
                                                if (data == null) {
                                                    return '';
                                                } else {
                                                    return data;
                                                }
                                            }},
                                        {data: 'estado', "render": function (data, type, row) {

                                                return data.nombre;
                                            }},
                                        {data: 'perfil', "render": function (data, type, row) {
                                                return data.nombre;
                                            }
                                        },
                                        {data: 'id', "render": function (data, type, row) {
                                                return '<button class="btn btn-default" onclick="CargarDatosUsuComun(' + data + ')"><i class="fa fa-pencil-square-o icono"></i></button>'
                                                        + '<button class="btn btn-default" onclick="desBloquear(' + data + ')"><i class="fa fa-undo icono"></i></button>'
                                                        + '<button class="btn btn-default" onclick="bloquear(' + data + ')" id="btnBloquear"><i class="fa fa-lock"></i></button>';
                                            }
                                        }
                                    ]
                                });
                            }
                        });
                        swal_unprocces();
                    });

                    function CargarDatosUsuComun(id) {
                        var obUsuario = $('#ListaDeUsuarios').DataTable().row(1).data();
                        for (var i = 0; i < $('#ListaDeUsuarios').length+1; i++) {
                            var usuActual = $('#ListaDeUsuarios').DataTable().row(i).data();
                            if (usuActual.id == id) {
                                var obUsuario = usuActual;
                            }
                        }
                        $('#ModalUsuarioComun').modal({'backdrop': 'static'});
                        $('#idUsuarioComun').val(obUsuario.id);
                        $('#txtEditarNomUsuarioComun').val(obUsuario.nombre);
                        $('#txtEditarApeUsuarioComun').val(obUsuario.apePaterno);
                        $('#txtEditarAmaUsuarioComun').val(obUsuario.apeMaterno);
                        $('#txtEditarEmailCorporativoComun').val(obUsuario.email);
                        $('#txtEditarEmailCorporativo2Comun').val(obUsuario.email);
                        $('#selectEditarSTATUS').val(obUsuario.estado.id);
                        if (obUsuario.perfil.id == 2) {
                            $('#selectEditarSTATUS').prop('disabled', 'disabled');
                        } else {
                            $('#selectEditarSTATUS').prop('disabled', false);
                        }
                    }

                    function bloquear(id) {
                        $.ajax({
                            url: 'Svl_Usuarios',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: 'Bloquear',
                                id: id
                            }, success: function (data, textStatus, jqXHR) {
                                if (data.estado === 100) {
                                    // aqui va codigo para refrescar la lista de usuarios
                                    go('cmd', [{id: 'code', val: 'usuario'}], undefined, 'cmd');
                                } else {
                                    $('#modalError').modal({backdrop: 'static'});
                                    $('#msgError').html(data.descripcion);
                                }
                            }
                        });
                    }

                    function desBloquear(id) {
                        $.ajax({
                            url: 'Svl_Usuarios',
                            type: 'POST',
                            dataType: 'json',
                            data: {
                                accion: 'desBloquear',
                                id: id
                            }, success: function (data, textStatus, jqXHR) {
                                if (data.estado === 100) {
                                    // aqui va codigo para refrescar la lista de usuarios
                                    go('cmd', [{id: 'code', val: 'usuario'}], undefined, 'cmd');
                                } else {
                                    $('#modalError').modal({backdrop: 'static'});
                                    $('#msgError').html(data.descripcion);
                                }
                            }
                        });
                    }
                </script>
                </body>


                <!-- Mirrored from keenthemes.com/preview/metronic/theme/admin_4/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Mar 2017 15:44:48 GMT -->
                </html>
