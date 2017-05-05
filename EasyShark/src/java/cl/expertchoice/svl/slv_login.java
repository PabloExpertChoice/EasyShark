package cl.expertchoice.svl;

import cl.expertchoice.beans.bnsLogin;
import cl.expertchoice.clases.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;
import soporte.D;
import soporte.ENCR;

@WebServlet(name = "slv_login", urlPatterns = {"/slv_login"})
public class slv_login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String code = request.getParameter("code");
            HttpSession session = request.getSession();
            switch (code) {
                case "login": {
                    String user = request.getParameter("username");
                    String clave = request.getParameter("password");
                    bnsLogin bsn = new bnsLogin();
                    Usuario usuario = bsn.iniciarSesion(user, ENCR.toMD5(clave));
                    JSONObject json = new JSONObject();
                    if (usuario != null) {
                        session.setAttribute(D.SESSION_USUARIO, usuario);
                        json.put("estado", D.EST_OK);
                    } else {
                        json.put("estado", D.EST_NORESULTADO);
                        json.put("descripcion", "Error de usuario o contraseña");
                    }

                    out.print(json);
                    break;
                }
                case "logout": {
                    session.invalidate();
                    response.sendRedirect("cmd");
                    break;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
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
        processRequest(request, response);

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
        processRequest(request, response);
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

}
