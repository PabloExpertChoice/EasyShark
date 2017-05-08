package cl.expertchoice.svl;

import cl.expertchoice.beans.BnEmail;
import cl.expertchoice.beans.BnPerfil;
import cl.expertchoice.beans.BnStatus;
import cl.expertchoice.beans.BnSubsidiary;
import cl.expertchoice.beans.BnUsuario;
import cl.expertchoice.clases.Perfil;
import cl.expertchoice.clases.Status;
import cl.expertchoice.clases.Subsidiary;
import cl.expertchoice.clases.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import soporte.D;
import soporte.ENCR;

public class Svl_Perfiles extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String accion = request.getParameter("accion");
            JsonObject json = null;
            if (accion != null) {
                switch (accion) {
                    case "ListarPerfiles": {
                        BnPerfil bnPer = new BnPerfil();
                        ArrayList<Perfil> list = bnPer.ListaPerfil();
                        String json1 = new Gson().toJson(list);
                        System.out.println(json1);
                        response.getWriter().print(json1);
                        break;
                    }
                }
            } else {
                toPage("/easy_registro_ws.jsp", request, response); //, this
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
//        } catch (JSONException ex) {
//            Logger.getLogger(Svl_RegistroMeses.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            
//        }
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

    private void toPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            getServletContext().getRequestDispatcher(page).forward(request, response);
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
}
