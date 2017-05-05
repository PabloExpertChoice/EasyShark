<%@page import="soporte.D"%>
<%
    if (!D.isSesionActiva(request)) {
        response.sendRedirect("cmd");
        return;
    }
    int id_empresa = D.getUsuarioSesion(request).getSubsidiary().getId();

%>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7
Version: 4.7.1
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
    <!--<![endif]-->
    <!-- BEGIN HEAD -->


    <!-- Mirrored from keenthemes.com/preview/metronic/theme/admin_4/components_bootstrap_switch.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Mar 2017 15:49:11 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <meta charset="utf-8" />
        <title>Contrato</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #4 for bootstrap switch" name="description" />
        <meta content="" name="author" />
        <!-- BEGIN GLOBAL MANDATORY STYLES -->

        <!-- Sweetalert2-->
        <link rel="stylesheet" type="text/css" href="dist/css/sweetalert.css">
        <!-- Tema loading-->
        <link rel="stylesheet" type="text/css" href="css/loading.css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css" />
        <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN THEME GLOBAL STYLES -->
        <link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME GLOBAL STYLES -->
        <!-- BEGIN THEME LAYOUT STYLES -->
        <link href="assets/layouts/layout4/css/layout.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/layouts/layout4/css/themes/default.min.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="assets/layouts/layout4/css/custom.min.css" rel="stylesheet" type="text/css" />
        <!-- END THEME LAYOUT STYLES -->
        <link rel="shortcut icon" href="images/logo1.ico" /> </head>

    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

    <!-- END HEAD -->
    <body class="page-container-bg-solid page-header-fixed page-sidebar-closed-hide-logo">
        <!-- BEGIN HEADER -->
        <jsp:include page="seccion/head.jsp"></jsp:include>
            <!-- BEGIN HEADER & CONTENT DIVIDER -->
            <div class="clearfix"> </div>
            <!-- END HEADER & CONTENT DIVIDER -->
            <!-- BEGIN CONTAINER -->
            <div class="page-container">
                <!-- BEGIN SIDEBAR -->
            <jsp:include page="seccion/sidebar.jsp"></jsp:include>
                <!-- END SIDEBAR -->
                <!-- BEGIN CONTENT -->
                <div class="page-content-wrapper">
                    <!-- BEGIN CONTENT BODY -->
                    <div class="page-content">
                        <!-- BEGIN PAGE HEAD-->
                        <div class="page-head">
                            <!-- BEGIN PAGE TITLE -->
                            <!-- END PAGE TITLE -->
                            <!-- BEGIN PAGE TOOLBAR -->
                            <!-- END PAGE TOOLBAR -->
                        </div>
                        <!-- END PAGE HEAD-->
                        <!-- BEGIN PAGE BREADCRUMB -->
                        <ul class="page-breadcrumb breadcrumb">
                            <li>
                                <a href="index.html">Home</a>
                                <i class="fa fa-circle"></i>
                            </li>
                            <li>
                                <span class="active">Components</span>
                            </li>
                        </ul>
                        <!-- END PAGE BREADCRUMB -->
                        <!-- BEGIN PAGE BASE CONTENT -->
                        <div class="row">
                            <div class="col-lg-12">
                                <!-- BEGIN PORTLET-->
                                <div class="portlet box blue">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-file"></i>CONTRATO DE BUREAUS
                                        </div>
                                        <div class="tools">
                                            <a href="#" class="collapse" data-original-title="" title=""> </a>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="pull-right text-right">
                                            <div class="portlet">
                                                <div class="checkbox" onclick="abrirModalContrato('chkSinacofi',<%= id_empresa%>);">
                                                    <label>
                                                        <input id="chkSinacofi" name="chkSinacofi" type="checkbox" data-toggle="toggle">

                                                    </label>
                                                </div>

                                            </div>
                                        </div>
                                        <h4 class="m-b-xs">Sinacofi</h4>
                                    </div>
                                </div>
                                <div class="portlet box blue">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-file"></i>CONTRATO DE BUREAUS
                                        </div>
                                        <div class="tools">
                                            <a href="#" class="collapse" data-original-title="" title=""> </a>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="pull-right text-right">
                                            <div class="portlet">
                                                <div class="checkbox" onclick="abrirModalContrato('chkEquifax',<%= id_empresa%>);">
                                                    <label>
                                                        <input id="chkEquifax"  name="chkEquifax" type="checkbox" data-toggle="toggle">
                                                    </label>
                                                </div>

                                            </div>
                                        </div>
                                        <h4 class="m-b-xs">Equifax</h4>
                                    </div>
                                </div>
                                <div class="portlet box blue">
                                    <div class="portlet-title">
                                        <div class="caption">
                                            <i class="fa fa-file"></i>CONTRATO DE BUREAUS
                                        </div>
                                        <div class="tools">
                                            <a href="#" class="collapse" data-original-title="" title=""> </a>
                                        </div>
                                    </div>
                                    <div class="portlet-body">
                                        <div class="pull-right text-right">
                                            <div class="portlet">
                                                <div class="checkbox" onclick="abrirModalContrato('chkTransunion',<%= id_empresa%>);">
                                                    <label>
                                                        <input id="chkTransunion"  name="chkTransunion" type="checkbox" data-toggle="toggle">
                                                    </label>
                                                </div>

                                            </div>
                                        </div>
                                        <h4 class="m-b-xs">Transunion</h4>
                                    </div>
                                </div>
                                <!-- END PORTLET-->
                            </div>
                        </div>
                        <!-- END PAGE BASE CONTENT -->
                    </div>
                    <!-- END CONTENT BODY -->
                </div>
                <!-- END CONTENT -->
                <!--///////////////MODAL//////////////////-->
            <jsp:include page="seccion/modal.jsp"></jsp:include>
                <!-- BEGIN FOOTER -->
            <jsp:include page="seccion/footer.jsp"></jsp:include>
                <!-- END FOOTER -->
            </div>
            <!-- END CONTAINER -->

            <div class="quick-nav-overlay"></div>
            <!-- END QUICK NAV -->
            <!--[if lt IE 9]>
    <script src="assets/global/plugins/respond.min.js"></script>
    <script src="assets/global/plugins/excanvas.min.js"></script> 
    <script src="assets/global/plugins/ie8.fix.min.js"></script> 
    <![endif]-->
            <!-- BEGIN CORE PLUGINS -->
            <script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
            <script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
            <!-- END CORE PLUGINS -->
            <!-- BEGIN THEME GLOBAL SCRIPTS -->
            <!-- Swall-->
            <script src="js/swall.js" type="text/javascript"></script>
            <!-- Sweetalert2-->
            <script src="dist/js/sweetalert.min.js"></script>

            <script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
            <!-- END THEME GLOBAL SCRIPTS -->
            <!-- BEGIN PAGE LEVEL SCRIPTS -->
            <script src="assets/pages/scripts/components-bootstrap-switch.min.js" type="text/javascript"></script>
            <!-- END PAGE LEVEL SCRIPTS -->
            <!-- BEGIN THEME LAYOUT SCRIPTS -->
            <script src="assets/layouts/layout4/scripts/layout.min.js" type="text/javascript"></script>
            <script src="assets/layouts/layout4/scripts/demo.min.js" type="text/javascript"></script>
            <script src="assets/layouts/global/scripts/quick-sidebar.min.js" type="text/javascript"></script>
            <script src="assets/layouts/global/scripts/quick-nav.min.js" type="text/javascript"></script>
            <script src="js/contrato.js" type="text/javascript"></script>
            <!-- END THEME LAYOUT SCRIPTS -->
            <!-- Google Code for Universal Analytics -->
            <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
            <script>
                                                    (function (i, s, o, g, r, a, m) {
                                                        i['GoogleAnalyticsObject'] = r;
                                                        i[r] = i[r] || function () {
                                                            (i[r].q = i[r].q || []).push(arguments)
                                                        }, i[r].l = 1 * new Date();
                                                        a = s.createElement(o),
                                                                m = s.getElementsByTagName(o)[0];
                                                        a.async = 1;
                                                        a.src = g;
                                                        m.parentNode.insertBefore(a, m)
                                                    })(window, document, 'script', 'www.google-analytics.com/analytics.js', 'ga');
                                                    ga('create', 'UA-37564768-1', 'auto');
                                                    ga('send', 'pageview');
            </script>
            <!-- End -->

            <!-- Google Tag Manager -->
            <noscript><iframe src="http://www.googletagmanager.com/ns.html?id=GTM-W276BJ"
                              height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
            <script>(function (w, d, s, l, i) {
                    w[l] = w[l] || [];
                    w[l].push({'gtm.start':
                                new Date().getTime(), event: 'gtm.js'});
                    var f = d.getElementsByTagName(s)[0],
                            j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
                    j.async = true;
                    j.src =
                            'www.googletagmanager.com/gtm5445.html?id=' + i + dl;
                    f.parentNode.insertBefore(j, f);
                })(window, document, 'script', 'dataLayer', 'GTM-W276BJ');</script>
            <!-- End -->

            <!-- Codigo A.M.-->
            <script src="js/funciones.js"></script>
            <script src="js/sidebar.js"></script>
            <script> menuSelected("<%=request.getParameter("code")%>");</script>
        <script src="dist/js/sweetalert.min.js"></script>
        <script>

                var id_empresa = '<%= id_empresa%>';
               
                $(function () {
                    swal_procces();
                    $.ajax({
                        url: 'Svl_Contratacion',
                        type: 'POST',
                        dataType: 'json',
                        data: {
                            accion: 'verContratacion',
                            id_empresa: id_empresa
                        },
                        success: function (data) {

                            for (var obj in data) {
                                var temp = data[obj]['Id_tipocontratacion'];
                                console.log('TipoContratacion: ' + data[obj]['Id_tipocontratacion'] + "  Estado:" + data[obj]['Estado']);
                                switch (temp) {
                                    case 1:
                                    {
                                        setChecked('chkSinacofi', data[obj]['Estado']);
                                        break;
                                    }
                                    case 2:
                                    {
                                        setChecked('chkEquifax', data[obj]['Estado']);
                                        break;
                                    }
                                    case 3:
                                    {
                                        setChecked('chkTransunion', data[obj]['Estado']);
                                        break;
                                    }
                                }
                            }
                            swal_unprocces();
                        }});
                });





        </script>
        <script src="js/contrato.js" type="text/javascript"></script>

    </body>



    <!-- Mirrored from keenthemes.com/preview/metronic/theme/admin_4/components_bootstrap_switch.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 13 Mar 2017 15:49:13 GMT -->
</html>