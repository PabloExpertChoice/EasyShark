package soporte;

import cl.expertchoice.clases.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class D {

    public static String ESQUEMA = "easy";
    public static String TITULO = "Easy Shark";
    public static String DOMINIO = "localhost:8084/EasyShark";
    //Estados de respuesta ajax
    public static final int EST_OK = 200;
    //estado del usuario comun sirve para actualizar la lista de usuarios
    public static final int EST_USUARIO_COMUN_OK = 100;
    //para verificar si es un administrador
    public static final int EST_EsADMINISTRADOR = 50;
    public static final int EST_ERROR = 404;
    public static final int EST_NORESULTADO = 405;

    /**
     * JSP
     */
    public static final String PAGE_INDEX = "/index.jsp";
    public static final String PAGE_LOGIN = "/login.jsp";
    public static final String PAGE_DASHBOARD = "/dashboard.jsp";
    public static final String PAGE_TRANSUNION = "/transunion.jsp";

    /**
     * Nombres de sesion
     */
    public static final String SESSION_USUARIO = "user_session";

    public static String NUMEROS = "0123456789";
    public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    public static String ESPECIALES = "ñÑ";

    public static String getPinNumber() {
        return getPassword(NUMEROS, 4);
    }

    public static String getPassword() {
        return getPassword(8);
    }

    public static String getPassword(int length) {
        return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, length);
    }

    public static String getPassword(String key, int length) {
        String pswd = "";

        for (int i = 0; i < length; i++) {
            pswd += (key.charAt((int) (Math.random() * key.length())));
        }

        return pswd;
    }

    /**
     *
     * @param page
     * @param request
     * @param response
     * @param ser
     * @throws ServletException
     */
    public static void toPage(String page, HttpServletRequest request, HttpServletResponse response, HttpServlet ser) throws ServletException {
        try {
            ser.getServletContext().getRequestDispatcher(page).forward(request, response);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }

    public static Usuario getUsuarioSesion(HttpServletRequest request) {
        if (isSesionActiva(request)) {
            HttpSession sesion = request.getSession(false);
            Usuario usuLogin = (Usuario) sesion.getAttribute(D.SESSION_USUARIO);
            if (usuLogin == null) {
                return null;
            } else {
                return usuLogin;
            }
        } else {
            return null;
        }
    }

    public static boolean isSesionActiva(HttpServletRequest request) {
        Usuario usuLogin = (Usuario) request.getSession().getAttribute(D.SESSION_USUARIO);
        if (usuLogin == null) {
            return false;
        } else {
            return true;
        }
    }
}
