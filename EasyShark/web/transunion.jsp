<%-- 
    Document   : index
    Created on : 13-03-2017, 15:22:02
    Author     : ignacio
--%>
<%@page import="soporte.D"%>
<%@page import="cl.expertchoice.clases.Usuario"%>
<%@page import="org.json.JSONObject"%>
<%
    if (!D.isSesionActiva(request)) {
        response.sendRedirect("cmd");
        return;
    }

    JSONObject datos = (JSONObject) request.getAttribute("datos");
    String r = datos.get("rut").toString();
    int rut = Integer.parseInt(r);
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->
    <!-- Mirrored from keenthemes.com/preview/metronic/theme/admin_4/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Mar 2017 15:40:53 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8" />
        <title>Transunion</title>
        <link rel="shortcut icon" href="images/logo1.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #4 for statistics, charts, recent events and reports" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
        <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />


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
                        <!-- Ruta-->
                        <div>
                            <ul class="page-breadcrumb breadcrumb">
                                <li>
                                    <a href="javascript:;" onclick="go('cmd', undefined, 'cmd');">
                                        Inicio</a>
                                </li>
                                <i class="fa fa-circle"></i>
                                <li>
                                    <!--<a href="dashboard.jsp">-->
                                    <a href="javascript:;" onclick="goHome();">
                                        Home</a>
                                </li>
                                <i class="fa fa-circle"></i>
                                <li>
                                    Informaci&#243;n Bureau
                                </li>
                            </ul>
                        </div>
                        <!-- Fin ruta -->
                        <div class="page-head">
                            <!-- BEGIN PAGE TITLE -->
                            <div class="page-title">
                                <h1>Informaci&#243;n Bureau</h1>
                            </div>
                        </div>
                        <!-- END PAGE TITLE -->
                        <!-- END PAGE HEAD-->


                        <div class="row">
                            <div class="col-md-12">
                                <!-- BEGIN TAB PORTLET-->
                                <div class="portlet light bordered">
                                    <div class="portlet-title">

                                        <div class="caption">
                                            <i class="icon-anchor"></i>
                                            <span class="caption-subject bold uppercase">Informaci&#243;n detallada del Cliente</span>
                                        </div>

                                    </div>
                                    <div class="page-head">
                                        <!-- BEGIN PAGE TITLE -->
                                        <div class="page-title">
                                            <h1><small class="small" style="display: inline-block;width: 155px; color: #697882;">Nombre o razon social </small><small>: <%= datos.get("nombre")%></small></h1>
                                        <h1><small class="small" style="display: inline-block;width: 155px; color: #697882;">Rut </small><small>: <%= datos.get("rut")%>-<%= datos.get("dv")%></small></h1>
                                        <!--                                            <span class="small" style="display: inline-block;width: 155px; color: #5b9bd1">Razon Social</span>: <span class="small" style="color: #5b9bd1">Pedro Pablo Perez</span><br>
                                                                                    <span class="small" style="display: inline-block;width: 155px; color: #5b9bd1">Rut</span>: <span class="small" style="color: #5b9bd1">10.497.521-9</span>-->
                                    </div>
                                </div>
                                <!-- END PAGE TITLE -->
                                <%
                                    if (rut < 50000000) {
                                %> 
                                <div class="portlet-body">
                                    <div class="tabbable tabbable-tabdrop">
                                        <ul class="nav nav-tabs">
                                            <li class="active">
                                                <a href="#tab1" data-toggle="tab" aria-expanded="true">Vista resumen</a>
                                            </li>
                                            <li class="">
                                                <a href="#tab2" data-toggle="tab" aria-expanded="false">Antecedentes particulares</a>
                                            </li>
                                            <li class="">
                                                <a href="#tab3" data-toggle="tab" aria-expanded="false">Antecedentes laborales</a>
                                            </li>
                                            <li class="">
                                                <a href="#tab4" data-toggle="tab" aria-expanded="false">Antecedentes financieros</a>
                                            </li>
                                            <li class="">
                                                <a href="#tab5" data-toggle="tab" aria-expanded="false">Consultas al RUT</a>
                                            </li>
                                        </ul>

                                        <div class="tab-content" style="height: 800px">
                                            <div class="tab-pane active" id="tab1">
                                                <div class="col-md-12" style="border: 0; margin: 0;">
                                                    <!-- BEGIN SAMPLE TABLE PORTLET-->
                                                    <div class="portlet box blue">
                                                        <div class="portlet-title">
                                                            <div class="caption">
                                                                <i class="fa fa-comments"></i>
                                                                <!--Contextual Rows--> 
                                                            </div>
                                                            <div class="tools">
                                                                <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                            </div>
                                                        </div>
                                                        <div class="portlet-body">
                                                            <div class="table-scrollable">
                                                                <table class="table table-bordered table-hover">
                                                                    <thead>
                                                                        <tr class="uppercase"></tr>

                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>Score</td>
                                                                            <td><%= datos.get("score")%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Estado C&eacute;dula</td>
                                                                            <td><%= datos.get("estado_cedula")%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>N&uacute;m Serie</td>
                                                                            <td><%= datos.get("numero_serie")%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Defunci&oacute;n</td>
                                                                            <td><%= datos.get("defuncion")%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Consultas al RUT (&uacute;lt. 6 meses)</td>
                                                                            <td><%= datos.get("num_consultas6Meses")%></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END SAMPLE TABLE PORTLET-->

                                                    <!-- BEGIN SAMPLE TABLE PORTLET-->
                                                    <div class="portlet box blue">
                                                        <div class="portlet-title">
                                                            <div class="caption">
                                                                <i class="fa fa-comments"></i>
                                                                <!--Contextual Rows--> 
                                                            </div>
                                                            <div class="tools">
                                                                <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                            </div>
                                                        </div>
                                                        <div class="portlet-body">
                                                            <div class="table-scrollable">
                                                                <table class="table table-bordered table-hover">
                                                                    <thead>
                                                                        <tr class="uppercase">
                                                                            <td>Producto</td>
                                                                            <td>Total Documentos</td>
                                                                            <td>Acreedores</td>
                                                                            <td>Fecha M&aacute;s Reciente</td>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>Anotaciones vigentes</td>
                                                                            <td><%= datos.get("dct_resumen_anotacion_vigente/nro_documentos")%></td>
                                                                            <td><%= datos.get("dct_resumen_anotacion_vigente/nro_acreedores")%></td>
                                                                            <td><%= datos.get("dct_resumen_anotacion_vigente/fecha_mas_reciente")%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Bolet&iacute;n Impagos Laboral y Previsional</td>
                                                                            <td><%= datos.get("dct_resumen_boletin_laboral/total_documentos")%></td>
                                                                            <td><%= datos.get("dct_resumen_boletin_laboral/acreedores")%></td>
                                                                            <td><%= datos.get("dct_resumen_boletin_laboral/fecha_mas_reciente")%></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END SAMPLE TABLE PORTLET-->
                                                    <!-- BEGIN SAMPLE TABLE PORTLET-->
                                                    <div class="portlet box blue">
                                                        <div class="portlet-title">
                                                            <div class="caption">
                                                                <i class="fa fa-comments"></i>
                                                                Antecedentes Protestos y Morosidades (Informaci&oacute;n para Evaluaci&oacute;n)
                                                            </div>
                                                            <div class="tools">
                                                                <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                            </div>
                                                        </div>
                                                        <div class="portlet-body">
                                                            <div class="table-scrollable">
                                                                <table class="table table-bordered table-hover">
                                                                    <thead>
                                                                        <tr class="uppercase">

                                                                            <td>Producto</td>
                                                                            <td>Total Documentos</td>
                                                                            <td>Acreedores</td>
                                                                            <td>Fecha M&aacute;s Reciente</td>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>Protestos vigentes</td>
                                                                            <td><%= datos.get("protestos_vigentes/nro_documentos")%></td>
                                                                            <td><%= datos.get("protestos_vigentes/nro_acreedores")%></td>
                                                                            <td><%= datos.get("protestos_vigentes/fecha_mas_reciente")%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Morosidad Consolidada</td>
                                                                            <td><%= datos.get("morosidad_consolidada/nro_documentos")%></td>
                                                                            <td><%= datos.get("morosidad_consolidada/nro_acreedores")%></td>
                                                                            <td><%= datos.get("morosidad_consolidada/fecha_mas_reciente")%></td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <!-- END SAMPLE TABLE PORTLET-->
                                                </div>

                                            </div>
                                            <div class="tab-pane" id="tab2">
                                                <div class="portlet box blue">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-comments"></i>
                                                            <!--Contextual Rows--> 
                                                        </div>
                                                        <div class="tools">
                                                            <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                            <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                        <div class="table-scrollable">
                                                            <table class="table table-bordered table-striped">
                                                                <thead>
                                                                    <tr class="uppercase">

                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>Fecha Nacimiento</td>
                                                                        <td><%= datos.get("fecha_de_nacimiento")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Edad</td>
                                                                        <td><%= datos.get("edad")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Sexo</td>
                                                                        <td><%= datos.get("sexo")%></td>
                                                                    <tr>
                                                                        <td>Nacionalidad</td>
                                                                        <td><%= datos.get("nacionalidad")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Estado Civil</td>
                                                                        <td><%= datos.get("estado_civil")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Fecha Matrimonio</td>
                                                                        <td><%= datos.get("fecha_civil")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Direcci&oacute;n</td>
                                                                        <td><%= datos.get("direccion")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Informadas</td>
                                                                        <td><%= datos.get("nro_direcciones_informadas")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Tel&eacute;fono(s)</td>
                                                                        <td colspan="3"><%= datos.get("telefono")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>E-mail</td>
                                                                        <td colspan="3"><%= datos.get("email")%></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab3">
                                                <div class="portlet box blue">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-comments"></i>
                                                            <!--Contextual Rows--> 
                                                        </div>
                                                        <div class="tools">
                                                            <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                            <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                        <div class="table-scrollable">
                                                            <table class="table table-bordered table-hover">
                                                                <thead>

                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>Actividad o Profesi&oacute;n</td>
                                                                        <td><%= datos.get("actividad_profesion")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Actividad Econ&oacute;mica</td>
                                                                        <%
                                                                            int largo = datos.getJSONArray("dct_detalle_antecedentes_laborales").length();
                                                                            if (largo == 0) {
                                                                                out.write("<td> No se registra informaci&oacute;n</td>");
                                                                            } else {
                                                                                for (int i = 0; i < largo; i++) {
                                                                                    JSONObject consulta = datos.getJSONArray("dct_detalle_antecedentes_laborales").getJSONObject(i);
                                                                                    out.write("<td>" + consulta.get("glosa") + "</td>");
                                                                                }
                                                                            }
                                                                        %>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab4">
                                                <div class="portlet box blue">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-comments"></i>
                                                            <!--Contextual Rows--> 
                                                        </div>
                                                        <div class="tools">
                                                            <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                            <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                        <div class="table-scrollable">
                                                            <table class="table table-bordered table-hover">
                                                                <thead>
                                                                    <tr class="uppercase"></tr>

                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>Movimientos en bancos</td>
                                                                        <td><%= datos.get("movimientos_de_bancos").toString()%></td>
                                                                        <td>Esto no significa que la cuenta corriente est&eacute; vigente</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Cantidad de Veh&iacute;culos</td>
                                                                        <td><%= datos.get("numero_vehiculos").toString()%></td>
                                                                        <td></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="portlet box blue">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-comments"></i>
                                                            Protestos
                                                        </div>
                                                        <div class="tools">
                                                            <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                            <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                        <div class="table-scrollable">
                                                            <table class="table table-bordered table-hover">
                                                                <thead>
                                                                    <tr class="uppercase">
                                                                        <td>&nbsp;</td>
                                                                        <td>N° Documentos</td>
                                                                        <td>N° Acreedores</td>
                                                                        <td>Fecha m&aacute;s reciente</td>
                                                                        <td>Monto Total</td>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <td>Protestos</td>
                                                                        <td><%= datos.get("protestos_vigentes/nro_documentos")%></td>
                                                                        <td><%= datos.get("protestos_vigentes/nro_acreedores")%></td>
                                                                        <td><%= datos.get("protestos_vigentes/fecha_mas_reciente")%></td>
                                                                        <td><%= datos.get("protestos_vigentes/monto_total")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Morosidad</td>
                                                                        <td><%= datos.get("morosidad_consolidada/nro_documentos")%></td>
                                                                        <td><%= datos.get("morosidad_consolidada/nro_acreedores")%></td>
                                                                        <td><%= datos.get("morosidad_consolidada/fecha_mas_reciente")%></td>
                                                                        <td><%= datos.get("morosidad_consolidada/monto_total")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Bolet&iacute;n Laboral</td>
                                                                        <td><%= datos.get("boletin_laboral/nro_documentos")%></td>
                                                                        <td><%= datos.get("boletin_laboral/nro_acreedores")%></td>
                                                                        <td><%= datos.get("boletin_laboral/fecha_mas_reciente")%></td>
                                                                        <td><%= datos.get("boletin_laboral/monto_total")%></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Totales</td>
                                                                        <td><%= datos.get("totales/nro_documentos")%></td>
                                                                        <td><%= datos.get("totales/nro_acreedores")%></td>
                                                                        <td>-</td>
                                                                        <td><%= datos.get("totales/monto_total")%></td>
                                                                    </tr>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="portlet box blue">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-comments"></i>
                                                            Antecedentes Protestos y Morosidades (Informaci&oacute;n para Evaluaci&oacute;n)
                                                        </div>
                                                        <div class="tools">
                                                            <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                            <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                        <div class="table-scrollable">
                                                            <table class="table table-bordered table-hover">
                                                                <thead>
                                                                    <tr class="uppercase">
                                                                    <tr class="uppercase">
                                                                        <td>Fecha Venc.</td>
                                                                        <td>Tipo Documento</td>
                                                                        <td>Librador</td>
                                                                        <td>Localidad</td>
                                                                        <td>Tipo de Deuda</td>
                                                                        <td>Moneda</td>
                                                                        <td>Monto</td>
                                                                        <td>Motivo</td>
                                                                        <td>Fecha Prot.</td>
                                                                        <td>Tipo Cr&eacute;dito</td>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%
                                                                        int largo1 = datos.getJSONArray("dct_detalle_individual_de_registros_de_morosidad_y_protestos").length();
                                                                        if (largo1 == 0) {
                                                                            out.write("<tr>");
                                                                            out.write("<td> No se registra informaci&oacute;n</td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("</tr>");
                                                                        } else {
                                                                            for (int i = 0; i < largo1; i++) {
                                                                                JSONObject prot = datos.getJSONArray("dct_detalle_individual_de_registros_de_morosidad_y_protestos").getJSONObject(i);
                                                                                out.write("<tr>");
                                                                                out.write("<td>" + prot.get("fecha_vencimiento") + "</td>");
                                                                                out.write("<td>" + prot.get("tipo_documento") + "</td>");
                                                                                out.write("<td>" + prot.get("emisor_librador") + "</td>");
                                                                                out.write("<td>" + prot.get("localidad") + "</td>");
                                                                                out.write("<td>" + prot.get("tipo_deuda") + "</td>");
                                                                                out.write("<td>" + prot.get("moneda") + "</td>");
                                                                                out.write("<td>" + prot.get("monto") + "</td>");
                                                                                out.write("<td>" + prot.get("motivo") + "</td>");
                                                                                out.write("<td>" + prot.get("fecha_protesto") + "</td>");
                                                                                out.write("<td>" + prot.get("tipo_credito") + "</td>");
                                                                                out.write("</tr>");
                                                                            }
                                                                        }
                                                                    %>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="tab-pane" id="tab5">
                                                <div class="portlet box blue">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <i class="fa fa-comments"></i>
                                                        </div>
                                                        <div class="tools">
                                                            <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                            <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                        <div class="table-scrollable">
                                                            <table class="table table-bordered table-hover">
                                                                <thead>
                                                                    <tr class="uppercase">
                                                                        <td>Fecha</td>
                                                                        <td>Empresa</td>
                                                                        <td>Tipo de informe</td>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <%
                                                                        int largo2 = datos.getJSONArray("dct_detalle_consultas_al_rut").length();
                                                                        if (largo2 == 0) {
                                                                            out.write("<tr>");
                                                                            out.write("<td> No se registra informaci&oacute;n</td>");
                                                                            out.write("<td></td>");
                                                                            out.write("<td></td>");
                                                                            out.write("</tr>");
                                                                        } else {
                                                                            for (int i = 0; i < largo2; i++) {
                                                                                JSONObject consulta = datos.getJSONArray("dct_detalle_consultas_al_rut").getJSONObject(i);
                                                                                out.write("<tr>");
                                                                                out.write("<td>" + consulta.get("fecha_consulta") + "</td>");
                                                                                out.write("<td>" + consulta.get("empresa") + "</td>");
                                                                                out.write("<td>" + consulta.get("informe_solicitado") + "</td>");
                                                                                out.write("</tr>");
                                                                            }
                                                                        }
                                                                    %>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <%
                                } else {
                                %>
                                <div class="row">
                                    <!--Cuerpo de la pagina-->
                                    <div style="" class="col-lg-12">
                                        <div class="hpanel">
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a data-toggle="tab" href="#tab-1"><i class="fa fa-laptop"></i> Vista resumen</a></li>
                                                <li class=""><a data-toggle="tab" href="#tab-2"><i class="fa fa-desktop"></i> Antecedentes particulares</a></li>
                                                <li class=""><a data-toggle="tab" href="#tab-3"><i class="fa fa-database"></i> Antecedentes financieros</a></li>
                                                <li class=""><a data-toggle="tab" href="#tab-4"><i class="fa fa-database"></i> Consultas al RUT</a></li>
                                            </ul>
                                            <!--Contenido de los tab -->
                                            <div class="tab-content">
                                                <!-- Tab antecedentes generales-->
                                                <div id="tab-1" class="tab-pane active">
                                                    <div class="panel-body">
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <tr>
                                                                            <th>Score</th>
                                                                            <td><%= datos.get("score")%></td>
                                                                        <tr>
                                                                        </tr>
                                                                        <tr>
                                                                            <th>Disoluci&oacute;n Vigente</th>
                                                                            <td>
                                                                                <%= datos.get("disolucion_vigente").toString()%>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th>Fecha disoluci&oacute;n</th>
                                                                            <td>
                                                                                <%= datos.get("fecha_disolucion").toString()%>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <th>Consultas al RUT (&uacute;lt. 6 meses)</th>
                                                                            <td><%= datos.get("num_consultas6Meses").toString()%></td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Producto</th>
                                                                                <th>Total Documentos</th>
                                                                                <th>Acreedores</th>
                                                                                <th>Fecha M&aacute;s Reciente</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Anotaciones vigentes</th>
                                                                                <td><%= datos.get("anota_vigentes_nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("anotacion_vigente/nro_acreedores").toString()%></td>
                                                                                <td><%= datos.get("anota_vigentes_fecha_mas_reciente").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Bolet&iacute;n Impagos Laboral y Previsional</th>
                                                                                <td><%= datos.get("boletin_laboral/nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/nro_acreedores").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/fecha_mas_reciente").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Antecedentes Protestos y Morosidades (Informaci&oacute;n para Evaluaci&oacute;n)
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Producto</th>
                                                                                <th>Total Documentos</th>
                                                                                <th>Acreedores</th>
                                                                                <th>Fecha M&aacute;s Reciente</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Anotaciones vigentes</th>
                                                                                <td><%= datos.get("anota_vigentes_nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("anotacion_vigente/nro_acreedores").toString()%></td>
                                                                                <td><%= datos.get("anota_vigentes_fecha_mas_reciente").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Bolet&iacute;n Impagos Laboral y Previsional</th>
                                                                                <td><%= datos.get("boletin_laboral/nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/nro_acreedores").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/fecha_mas_reciente").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Distribuci&oacute;n de Impagos</th>
                                                                                <th>Documentos Per&iacute;odo</th>
                                                                                <th>Montos Per&iacute;odo M$</th>
                                                                                <th>Documentos Acumulados</th>
                                                                                <th>Montos Acumulados M$</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>&Uacute;ltimos 6 meses</th>
                                                                                <td><%= datos.get("ultimos_6_meses/periodo_documentos").toString()%></td>
                                                                                <td><%= datos.get("ultimos_6_meses/periodo_montos").toString()%></td>
                                                                                <td><%= datos.get("ultimos_6_meses/acumulado_documentos").toString()%></td>
                                                                                <td><%= datos.get("ultimos_6_meses/acumulado_montos").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>6 a 12 meses</th>
                                                                                <td><%= datos.get("mes_6_a_12/periodo_documentos").toString()%></td>
                                                                                <td><%= datos.get("mes_6_a_12/periodo_montos").toString()%></td>
                                                                                <td><%= datos.get("mes_6_a_12/acumulado_documentos").toString()%></td>
                                                                                <td><%= datos.get("mes_6_a_12/acumulado_montos").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>12 a 24 meses<i class="icon-ok" style="color: #3C0; float:right"></i></th>
                                                                                <td><%= datos.get("mes_12_a_24/periodo_documentos").toString()%></td>
                                                                                <td><%= datos.get("mes_12_a_24/periodo_montos").toString()%></td>
                                                                                <td><%= datos.get("mes_12_a_24/acumulado_documentos").toString()%></td>
                                                                                <td><%= datos.get("mes_12_a_24/acumulado_montos").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>M&aacute;s de 24 meses</th>
                                                                                <td><%= datos.get("mas_de_24/periodo_documentos").toString()%></td>
                                                                                <td><%= datos.get("mas_de_24/periodo_montos").toString()%></td>
                                                                                <td><%= datos.get("mas_de_24/acumulado_documentos").toString()%></td>
                                                                                <td><%= datos.get("mas_de_24/acumulado_montos").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- inicio de tab 2 -->
                                                <!-- Tab antecedentes particulares -->
                                                <div id="tab-2" class="tab-pane">
                                                    <div class="panel-body">
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Nombre</th>
                                                                                <td><%= datos.get("nombre").toString()%>  </td>
                                                                                <th>Actividad</td>
                                                                                <td><%= datos.get("actividad").toString()%>  </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Nombre de fantas&iacute;a</th>
                                                                                <td><%= datos.get("nombre_fantasia").toString()%>  </td>
                                                                                <th>Fecha Constituci&oacute;n</th>
                                                                                <td><%= datos.get("fecha_constitucion").toString()%>  </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <!--                                                <th>Registro comercio</th>
                                                                                                                                <td>--</td>-->
                                                                                <th>Fojas</th>
                                                                                <td><%= datos.get("fojas").toString()%> </td>
                                                                                <th>N&uacute;mero</th>
                                                                                <td><%= datos.get("numero").toString()%> </td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>A&ntilde;o</th>
                                                                                <td><%= datos.get("ano").toString()%></td>
                                                                                <th>C&oacute;digo Postal</th>
                                                                                <td><%= datos.get("codigo_postal").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Disoluci&oacute;n vigente</th>
                                                                                <td><%= datos.get("disolucion_vigente").toString()%></td>
                                                                                <th>Fecha disoluci&oacute;n</th>
                                                                                <td><%= datos.get("fecha_disolucion").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Rubro</th>
                                                                                <td><%= datos.get("rubro").toString()%></td>

                                                                            </tr>
                                                                            <tr>
                                                                                <th>Direcci&oacute;n</th>
                                                                                <td><%= datos.get("direccion").toString()%></td>
                                                                                <th>N&uacute;m Direcciones Informadas</th>
                                                                                <td><%= datos.get("nro_direcciones_informadas").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>C&oacute;digo de &Aacute;rea</th>
                                                                                <td><%= datos.get("cod_area").toString()%></td>
                                                                                <th>Tel&eacute;fono</th>
                                                                                <td><%= datos.get("telefono").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>C&oacute;digo de &Aacute;rea 2</th>
                                                                                <td><%= datos.get("cod_area_2").toString()%></td>
                                                                                <th>Tel&eacute;fono 2</th>
                                                                                <td><%= datos.get("telefono_2").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>e-mail</th>
                                                                                <td><%= datos.get("email").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Detalle de contactos de la empresa
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>RUT</th>
                                                                                <th>Nombre o Raz&oacute;n Social</th>
                                                                                <th>Cargo</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <%
                                                                                //se valida que el arraylist contenga infotmacion
                                                                                int largo1 = datos.getJSONArray("dct_detalle_contactos_empresa").length();
                                                                                if (largo1 == 0) {
                                                                                    out.write("<tr>");
                                                                                    out.write("<td> No se registra informaci&oacute;n</td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("</tr>");
                                                                                } else {
                                                                                    for (int i = 0; i < largo1; i++) {
                                                                                        JSONObject contacto = datos.getJSONArray("dct_detalle_contactos_empresa").getJSONObject(i);
                                                                                        out.write("<tr>");
                                                                                        out.write("<td>" + contacto.get("rut") + "</td>");
                                                                                        out.write("<td>" + contacto.get("nombre_razon") + "</td>");
                                                                                        out.write("<td>" + contacto.get("cargo") + "</td>");
                                                                                        out.write("</tr>");

                                                                                    }
                                                                                }
                                                                            %>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- inicio de tab 3 -->
                                                <!-- Tab antecedentes financieros -->
                                                <div id="tab-3" class="tab-pane">
                                                    <div class="panel-body">
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Acreditaciones
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>

                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Movimientos en bancos</th>
                                                                                <td><%= datos.get("movimientos_de_bancos").toString()%></td>
                                                                                <td>Esto no significa que la cuenta corriente est&eacute; vigente</td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>N&uacute;mero de veh&iacute;culos</th>
                                                                                <td><%= datos.get("numero_vehiculos").toString()%></td>
                                                                                <th>&Uacute;ltima verificaci&oacute;n de domicilio</th>
                                                                                <td><%= datos.get("ultima_verificacion_de_domicilio").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Publicaciones como sociedad</th>
                                                                                <td><%= datos.get("publicaciones_como_sociedad").toString()%></td>
                                                                                <th>Publicaciones como socio</th>
                                                                                <td><%= datos.get("publicaciones_como_socio").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Comercio exterior: importaciones al a&ntilde;o</th>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/operaciones").toString()%></td>
                                                                                <th>Comercio exterior: exportaciones al a&ntilde;o</th>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/operaciones").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Comercio exterior: importaciones CIF US$</th>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/us").toString()%></td>
                                                                                <th>Comercio exterior: exportaciones FOB US$</th>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/us").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Bienes ra&iacute;ces: num propiedades</th>
                                                                                <td><%= datos.get("bienes_raices_nro_propiedades").toString()%></td>
                                                                                <th>Bienes ra&iacute;ces: aval&uacute;o fiscal total</th>
                                                                                <td><%= datos.get("bienes_raices_avaluo_fiscal_total").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Prendas: n&uacute;mero</th>
                                                                                <td><%= datos.get("prendas_nro_prendas").toString()%></td>
                                                                                <th>Prendas: fecha m&aacute;s reciente</th>
                                                                                <td><%= datos.get("prendas_fecha_mas_reciente").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Prendas: num acreedores</th>
                                                                                <td><%= datos.get("prendas_nro_acreedores").toString()%></td>
                                                                                <td></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br> 
                                                        <label class="">Detalle de comercio exterior</label> <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Per&iacute;odo actual
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <td>&nbsp;</td>
                                                                                <th>US$</th>
                                                                                <th># Ops</th>
                                                                                <th>Ene</th>
                                                                                <th>Feb</th>
                                                                                <th>Mar</th>
                                                                                <th>Abr</th>
                                                                                <th>May</th>
                                                                                <th>Jun</th>
                                                                                <th>Jul</th>
                                                                                <th>Ago</th>
                                                                                <th>Sep</th>
                                                                                <th>Oct</th>
                                                                                <th>Nov</th>
                                                                                <th>Dic</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Import</th>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/us").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/operaciones").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/ENE").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/FEB").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/MAR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/ABR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/MAY").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/JUN").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/JUL").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/AGO").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/SEP").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/OCT").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/NOV").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_importaciones/DIC").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Export</th>

                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/us").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/operaciones").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/ENE").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/FEB").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/MAR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/ABR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/MAY").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/JUN").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/JUL").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/AGO").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/SEP").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/OCT").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/NOV").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_actual/cmx_detalle_exportaciones/DIC").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Per&iacute;odo anterior
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <td>&nbsp;</td>
                                                                                <th>US$</th>
                                                                                <th># Ops</th>
                                                                                <th>Ene</th>
                                                                                <th>Feb</th>
                                                                                <th>Mar</th>
                                                                                <th>Abr</th>
                                                                                <th>May</th>
                                                                                <th>Jun</th>
                                                                                <th>Jul</th>
                                                                                <th>Ago</th>
                                                                                <th>Sep</th>
                                                                                <th>Oct</th>
                                                                                <th>Nov</th>
                                                                                <th>Dic</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Import</th>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/us").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/operaciones").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/ENE").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/FEB").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/MAR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/ABR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/MAY").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/JUN").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/JUL").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/AGO").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/SEP").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/OCT").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/NOV").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_importaciones/DIC").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Export</th>

                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/us").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/operaciones").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/ENE").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/FEB").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/MAR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/ABR").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/MAY").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/JUN").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/JUL").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/AGO").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/SEP").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/OCT").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/NOV").toString()%></td>
                                                                                <td><%= datos.get("cmx_detalle_periodo_anterior/cmx_detalle_exportaciones/DIC").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!--<br> <label class="header">&Oacute;rdenes de no pago</label>-->
                                                        <!--                                        <table cellpadding="1" cellspacing="1" class="table">
                                                                                                    <thead>
                                                                                                        <tr>
                                                                                                            <th>Bancos</th>
                                                                                                            <th>Cant. Cheques</th>
                                                                                                            <th>Fecha de Publicaci&oacute;n</th>
                                                                                                            <th>Motivo</th>
                                                                                                        </tr>
                                                                                                    </thead>
                                                                                                    <tbody>
                                                                                                        <tr>
                                                                                                            <td colspan="4" style="text-align: center">No se registra informaci&oacute;n</td>
                                                                                                        </tr>
                                                                                                    </tbody>
                                                                                                </table>-->
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Protestos
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>&nbsp;</th>
                                                                                <th>N° Documentos</th>
                                                                                <th>N° Acreedores</th>
                                                                                <th>Fecha m&aacute;s reciente</th>
                                                                                <th>Monto Total</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <tr>
                                                                                <th>Protestos</th>
                                                                                <td><%= datos.get("protestos_vigentes/nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("protestos_vigentes/nro_acreedores").toString()%></td>
                                                                                <td><%= datos.get("protestos_vigentes/fecha_mas_reciente").toString()%></td>
                                                                                <td><%= datos.get("protestos_vigentes/monto_total").toString()%></td>                                                 
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Morosidad</th>
                                                                                <td><%= datos.get("morosidad_consolidada/nro_documentos").toString()%></td>                                                 
                                                                                <td><%= datos.get("morosidad_consolidada/nro_acreedores").toString()%></td>                                                 
                                                                                <td><%= datos.get("morosidad_consolidada/fecha_mas_reciente").toString()%></td>                                                 
                                                                                <td><%= datos.get("morosidad_consolidada/monto_total").toString()%></td>                                                 
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Bolet&iacute;n Laboral</th>
                                                                                <td><%= datos.get("boletin_laboral/nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/nro_acreedores").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/fecha_mas_reciente").toString()%></td>
                                                                                <td><%= datos.get("boletin_laboral/monto_total").toString()%></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <th>Totales</th>
                                                                                <td><%= datos.get("totales/nro_documentos").toString()%></td>
                                                                                <td><%= datos.get("totales/nro_acreedores").toString()%></td>
                                                                                <td>-</td>
                                                                                <td><%= datos.get("totales/monto_total").toString()%></td>
                                                                            </tr>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <br>
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Antecedentes de Protestos y Morosidades (Informaci&oacute;n para Evaluaci&oacute;n)
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Fecha Venc.</th>
                                                                                <th>Tipo Documento</th>
                                                                                <th>Librador</th>
                                                                                <th>Localidad</th>
                                                                                <th>Tipo de Deuda</th>
                                                                                <th>Moneda</th>
                                                                                <th>Monto</th>
                                                                                <th>Motivo</th>
                                                                                <th>Fecha Prot.</th>
                                                                                <th>Tipo Cr&eacute;dito</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <%
                                                                                int largo = datos.getJSONArray("dct_detalle_individual_de_registros_de_morosidad_y_protestos").length();
                                                                                if (largo == 0) {
                                                                                    out.write("<tr>");
                                                                                    out.write("<td> No se registra informaci&oacute;n</td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("</tr>");
                                                                                } else {
                                                                                    for (int i = 0; i < largo; i++) {
                                                                                        JSONObject prot = datos.getJSONArray("dct_detalle_individual_de_registros_de_morosidad_y_protestos").getJSONObject(i);
                                                                                        out.write("<tr>");
                                                                                        out.write("<td>" + prot.get("fecha_vencimiento") + "</td>");
                                                                                        out.write("<td>" + prot.get("tipo_documento") + "</td>");
                                                                                        out.write("<td>" + prot.get("emisor_librador") + "</td>");
                                                                                        out.write("<td>" + prot.get("localidad") + "</td>");
                                                                                        out.write("<td>" + prot.get("tipo_deuda") + "</td>");
                                                                                        out.write("<td>" + prot.get("moneda") + "</td>");
                                                                                        out.write("<td>" + prot.get("monto") + "</td>");
                                                                                        out.write("<td>" + prot.get("motivo") + "</td>");
                                                                                        out.write("<td>" + prot.get("fecha_protesto") + "</td>");
                                                                                        out.write("<td>" + prot.get("tipo_credito") + "</td>");
                                                                                        out.write("</tr>");
                                                                                    }
                                                                                }
                                                                            %>
                                                                        </tbody>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <!-- inicio tab 4 -->
                                                <!-- Tab consulta RUT -->
                                                <div id="tab-4" class="tab-pane">
                                                    <div class="panel-body">
                                                        <div class="portlet box blue">
                                                            <div class="portlet-title">
                                                                <div class="caption">
                                                                    <i class="fa fa-comments"></i>
                                                                    Antecedentes de Protestos y Morosidades (Informaci&oacute;n para Evaluaci&oacute;n)
                                                                    <!--Contextual Rows--> 
                                                                </div>
                                                                <div class="tools">
                                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>


                                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                                </div>
                                                            </div>
                                                            <div class="portlet-body">
                                                                <div class="table-scrollable">
                                                                    <table class="table table-bordered table-hover">
                                                                        <thead>
                                                                            <tr>
                                                                                <th>Fecha</th>
                                                                                <th>Empresa</th>
                                                                                <th>Tipo de informe</th>
                                                                            </tr>
                                                                        </thead>
                                                                        <tbody>
                                                                            <%
                                                                                //se valida que el arraylist contenga infotmacion
                                                                                int largo2 = datos.getJSONArray("dct_detalle_consultas_al_rut").length();
                                                                                if (largo2 == 0) {
                                                                                    out.write("<tr>");
                                                                                    out.write("<td> No se registra informaci&oacute;n</td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("<td></td>");
                                                                                    out.write("</tr>");
                                                                                } else {
                                                                                    for (int i = 0; i < largo2; i++) {
                                                                                        JSONObject consulta = datos.getJSONArray("dct_detalle_consultas_al_rut").getJSONObject(i);
                                                                                        out.write("<tr>");
                                                                                        out.write("<td>" + consulta.get("fecha_consulta") + "</td>");
                                                                                        out.write("<td>" + consulta.get("empresa") + "</td>");
                                                                                        out.write("<td>" + consulta.get("informe_solicitado") + "</td>");
                                                                                        out.write("</tr>");
                                                                                    }
                                                                                }
                                                                            %>
                                                                        </tbody>
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
                                <%
                                    }
                                %>
                            </div>
                            <!-- END TAB PORTLET-->
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="page-footer">
            <jsp:include page="seccion/footer.jsp"></jsp:include>
            </div>


            <!-- END CONTENT -->
            <!-- END CONTAINER -->

            <!-- BEGIN FOOTER -->

            <!-- END FOOTER -->

            <!--boton flotante-->
        <jsp:include page="seccion/flotante.jsp"></jsp:include>

            <!-- BEGIN CORE PLUGINS -->
            <script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
            <!-- END CORE PLUGINS -->
            <!-- BEGIN PAGE LEVEL PLUGINS -->
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
            <script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
            <!-- END PAGE LEVEL PLUGINS -->
            <script src="https://www.amcharts.com/lib/3/lang/es.js"></script>
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

            <script src="js/funciones.js"></script>
            <!-- END THEME LAYOUT SCRIPTS -->
            <script>
                                        function goHome() {
                                            var datos = <%= datos%>;
                                            go('Svl_Informacion', [{id: 'code', val: 'home'}, {id: 'obDatos', val: JSON.stringify(datos)}], undefined, 'Svl_Informacion');
                                        }
            </script>  
            
                        
    </body>
</html>