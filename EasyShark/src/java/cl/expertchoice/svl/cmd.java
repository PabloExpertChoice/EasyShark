package cl.expertchoice.svl;

import cl.expertchoice.clases.Recurso;

import soporte.D;

import cl.expertchoice.beans.bnsLogin;
import cl.expertchoice.clases.Usuario;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet(name = "cmd", urlPatterns = {"/cmd"})
public class cmd extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario usu_session = D.getUsuarioSesion(request);
        if (D.isSesionActiva(request)) {
            if (request.getParameter("recurso") != null) {
                String url = "";
                for (Recurso x : usu_session.getRecursos()) {
                    if (x.getId() == Integer.parseInt(request.getParameter("recurso"))) {
                        url = x.getUrl();
                        break;
                    }
                }
                D.toPage(url, request, response, this);
            } else if (request.getParameter("code") != null) {
                String in_code = request.getParameter("code");
                switch (in_code) {
                    case "inicio": {
                        toPage("/index.jsp", request, response);
                        break;
                    }
                    case "index": {
                        toPage("/index.jsp", request, response);
                        break;
                    }
                    case "risktier": {
                        toPage("/risktier.jsp", request, response);
                        break;
                    }
                    case "risktier_config": {
                        toPage("/risktier_config.jsp", request, response);
                        break;
                    }
                    case "risktier_configRiskTier": {
                        toPage("/configuracionRiskTier.jsp", request, response);
                        break;
                    }
                    case "risktier_adminRiskTier": {
                        toPage("/adminRiskTier.jsp", request, response);
                        break;
                    }
                    case "risktier_tree": {
                        toPage("/risktier_tree.jsp", request, response);
                        break;
                    }
                    case "answer": {
                        toPage("/answer.jsp", request, response);
                        break;
                    }
                    case "contrato": {
                        toPage("/contrato.jsp", request, response);
                        break;
                    }
                    case "mis": {
                        toPage("/mis.jsp", request, response);
                        break;
                    }
                    case "estadisticas": {
                        toPage("/estadisticas.jsp", request, response);
                        break;
                    }
                    case "usuario": {
                        toPage("/usuario.jsp", request, response);
                        break;
                    }
                    case "perfil": {
                        toPage("/perfil.jsp", request, response);
                        break;
                    }                    
                    case "configuracion": {
                        toPage("/configuracion.jsp", request, response);
                        break;
                    }
                    case "Empresa": {
                        toPage("/easy_registro_ws_respuesta.jsp", request, response);
                        break;
                    }
                    default: {
                        toPage("/index.jsp", request, response);
                        break;
                    }
                }
            } else {
                toPage("/index.jsp", request, response);
                
            }
        } else {
            HttpSession session = request.getSession();
            System.out.println(session);
            if (session != null) {
                if (request.getParameter("code") != null) {
                    String code = request.getParameter("code");
                    switch (code) {
                        case "login": {
                            String user = request.getParameter("username");
                            String clave = request.getParameter("password");
                            bnsLogin bsn = new bnsLogin();
                            Usuario usuario;
                            usuario = bsn.iniciarSesion(user, clave);
                            JSONObject json = new JSONObject();

                            try {
                                if (usuario != null) {
                                    session.setAttribute("sesion", usuario);
                                    json.put("estado", "200");
                                    System.out.println("Paso");
                                    toPage("/index.jsp", request, response);

                                } else {
                                    request.setAttribute("valido","no");
                                    toPage("/login.jsp", request, response);
                                }
                            } catch (JSONException ex) {
                                Logger.getLogger(slv_login.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            out.print(json);
                            break;
                        }
                        case "logout": {
                            session.invalidate();
                            toPage("/login.jsp", request, response);
                            break;
                        }
                    }
                }else{
                    toPage("/login.jsp", request, response);
                }

            } else {
                toPage("/login.jsp", request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(cmd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /**
     * Realiza el redirect a la página del contexto indicada. Ésta debe tener el
     * formato <code>/pagina</code>.
     *
     * @param page
     * @param request
     * @param response
     * @throws ServletException
     */
    private void toPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            getServletContext().getRequestDispatcher(page).forward(request, response);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
    
    

}