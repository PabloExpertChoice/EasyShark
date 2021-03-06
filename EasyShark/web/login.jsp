<%@page import="soporte.D"%>
<%@page import="cl.expertchoice.clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (D.isSesionActiva(request)) {
        response.sendRedirect("cmd");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Login</title>
        <link rel="shortcut icon" href="images/logo1.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Preview page of Metronic Admin Theme #4 for " name="description" />
        <meta content="" name="author" />
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css" />
        <link href="font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/pages/css/login-3.min.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="favicon.ico" /> </head>
    <body class=" login">
        <div class="logo">
        </div>
        <div class="content">
            <form class="login-form" action="javascript:;" onsubmit="login()">
                <input type="hidden" name="code" value="login">
                <h3 class="form-title">Iniciar sesi&#243;n   
                    <img src="assets/layouts/layout4/img/logo4.png" alt="logo" class="logo-default" style="margin:0px;margin-top: 10px;height: 60px"/></h3>
                <div class="alert alert-danger display-hide">
                    <button class="close" data-close="alert"></button>
                    <span> Ingrese ususario y contrase&ntilde;a </span>
                </div>
                <div class="form-group">
                    <!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
                    <label class="control-label visible-ie8 visible-ie9">Usuario</label>
                    <div class="input-icon">
                        <i class="fa fa-user"></i>
                        <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="username" id="username"/> </div>
                </div>
                <div class="form-group">
                    <label class="control-label visible-ie8 visible-ie9">contrase&ntilde;a</label>
                    <div class="input-icon">
                        <i class="fa fa-lock"></i>
                        <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="password" id="password"/> </div>
                </div>
                <!--mensaje de error-->
                <div>

                    <%if (request.getAttribute("valido") == "no") {%>
                    <span style="color: #D8322F;" id="msgLogin"> 
                        "!Error de usuario o contraseña¡"
                    </span>
                    <% }%> 

                </div>
                <div class="form-actions">
                    <label class="rememberme mt-checkbox mt-checkbox-outline">
                        <input type="checkbox" name="remember" value="1" /> Recordar contrase&ntilde;a
                        <span></span>
                    </label>
                    <!--al hacer clic los datos se envian a clave.js para validar la sesion-->
                    <button class="btn green pull-right" id="btnEntrar" >
                        Iniciar sesi&#243n <i class="fa fa-sign-in"></i>
                    </button>
                </div>
                <div class="forget-password">
                    <h4>Olvidaste tu contrase&ntilde;a ?</h4>
                    <p> No te preocupes, click
                        <a href="javascript:;" id="forget-password"> aqu&#237</a> para restablecer la contraseña. </p>
                </div>
            </form>
            <div class="form-actions">
                <input class="btn green pull-right" id="btnRegistro" type="submit" value="REGISTRATE" onclick="location.href = 'easy_registro_ws.jsp'"/>
            </div>
        </div>
        <script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
        <script src="assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="assets/global/plugins/jquery-validation/js/additional-methods.min.js" type="text/javascript"></script>
        <script src="assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
        <script src="assets/global/scripts/app.min.js" type="text/javascript"></script>
        <script src="assets/pages/scripts/login.min.js" type="text/javascript"></script>
        <script src="js/clave.js" type="text/javascript">
        </script>
    </body>
</html>
