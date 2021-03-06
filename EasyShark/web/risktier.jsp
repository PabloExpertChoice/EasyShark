<%-- 
    Document   : risktier
    Created on : 22-03-2017, 16:56:49
    Author     : ignacio
--%>
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
        <title>Risk Tier</title>
        <link rel="shortcut icon" href="images/logo1.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #4 for statistics, charts, recent events and reports" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->
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
                        <div class="page-head">
                            <!-- BEGIN PAGE TITLE -->
                            <div class="page-title">
                                <h1>Administraci&#243;n Risk Tier</h1>
                            </div>
                            <!-- END PAGE TITLE -->
                            <!-- BEGIN PAGE TOOLBAR -->
                            <div class="page-toolbar" style="font-size: 13px;">
                                <!-- BEGIN THEME PANEL -->
                                <i class="fa fa-home" style="color: #69788c;"> Home</i> 
                                <i class="fa fa-angle-left"></i>
                                <a href="javascript:;" onclick="go('cmd', [{id: 'code', val: 'risktier_config'}], undefined, 'cmd');"><i class="fa fa-cogs"> Configuraci&#243;n</i>  </a>
                                <i class="fa fa-angle-left"></i>
                                <a href="javascript:;" onclick="go('cmd', [{id: 'code', val: 'risktier_tree'}], undefined, 'cmd');"><i class="fa fa-reorder"> Tree</i>  </a>
                                <!-- END THEME PANEL -->
                            </div>
                            <!-- END PAGE TOOLBAR -->
                        </div>
                        <!-- END PAGE HEAD-->

                        <!-- Ruta-->
                        <ul class="page-breadcrumb breadcrumb">
                            <li>
                                <a href="javascript:;" onclick="go('cmd', [{id: 'code', val: 'index'}], undefined, 'cmd');">Inicio</a>
                            </li>
                            <i class="fa fa-circle"></i>
                            <li>
                                Administraci&#243;n Risk Tier
                            </li>
                            <i class="fa fa-circle"></i>
                            <li>
                                Home
                            </li>
                        </ul>
                        <!-- Fin ruta -->

                        <div class="row">
                            <div class="col-md-12 col-lg-12">
                                <div class="portlet light">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-database"></i> Risk Tier 
                                            <br><br>
                                            <div class="col-md-2 col-lg-2" style="padding-left: 0px;">
                                                <select name="order_status" onchange="return cambiarTipoRiskTier(this.value)" class="form-control form-filter input-sm" style="width: 300px;">
                                                    <option value="1">Natural</option>
                                                    <option value="2">Jur&#237;dico</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="tools">
                                            <!--<a href="#" class="collapse" data-original-title="" title=""> </a>-->
                                            <br>
                                            <button type="button" class="btn blue mt-ladda-btn ladda-button btn-circle btn-outline" data-style="slide-up" data-spinner-color="#333" onclick="go('cmd', [{id: 'code', val: 'risktier_configRiskTier'}], undefined, 'cmd')">
                                                <span class="ladda-label"><i class="fa fa-wrench"></i> Configuraci&#243;n</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <!-- BEGIN SAMPLE TABLE PORTLET-->
                                        <div class="portlet box blue">
                                            <div class="portlet-title">
                                                <div class="caption">
                                                    <i class="fa fa-comments"></i>
                                                    Contextual Rows
                                                </div>
                                                <div class="tools">
                                                    <a href="javascript:;" class="collapse" data-original-title="" title=""> </a>
                                                    <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
                                                    <a href="javascript:buscarRiskTier();" class="" data-original-title="Refrescar" style="width: 13px; height: 15px; background-image:url(assets/global/img/portlet-reload-icon-white.png)"> </a>
                                                    <a href="javascript:;" class="remove" data-original-title="" title=""> </a>
                                                </div>
                                            </div>
                                            <div class="portlet-body">
                                                <div class="table-scrollable">
                                                    <table class="table table-bordered table-hover" id="tablaRiskTier">
                                                        <thead>
                                                            <tr class="uppercase">
                                                                <th style="text-align: center;"> Buscando datos para  RiskTier.. </th>
                                                            </tr>
                                                        </thead>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- END SAMPLE TABLE PORTLET-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END CONTENT -->
            </div>
            <!-- END CONTAINER -->

            <!-- BEGIN FOOTER -->
            <div class="page-footer">
            <jsp:include page="seccion/footer.jsp"></jsp:include>
            </div>
            <!-- END FOOTER -->


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
            <script src="assets/global/plugins/horizontal-timeline/horizontal-timeline.js" type="text/javascript"></script>
            <script src="assets/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
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
            <script src="js/funciones.js"></script>
            <script src="js/number_format.js"></script>
            <!-- End -->

            <!-- Codigo A.M.-->
            <script src="js/sidebar.js"></script>
            <script> menuSelected("<%=request.getParameter("code")%>");</script>
            <script src="js/mod_crear_indicador.js"></script>
            <script>
                $(function () {                
                    buscarRiskTier();
                }); 
            </script>
    </body>

    <!-- Mirrored from keenthemes.com/preview/metronic/theme/admin_4/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Mar 2017 15:44:48 GMT -->
</html>
