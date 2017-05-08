package cl.expertchoice.svl;

import org.json.*;
import cl.expertchoice.beans.BnPerfil;
import cl.expertchoice.beans.BnRecurso;
import cl.expertchoice.clases.PERFIL_has_RECURSO;
import cl.expertchoice.clases.Perfil;
import cl.expertchoice.clases.Recurso;
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
import soporte.D;

public class Svl_Recursos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String accion = request.getParameter("accion");
            JsonObject json = null;
            if (accion != null) {
                switch (accion) {
                    case "ListarRecursos": {
                        BnRecurso bnRec = new BnRecurso();
                        ArrayList<Recurso> list = bnRec.ListarRecursos();
                        String json1 = new Gson().toJson(list);
                        System.out.println(json1);
                        response.getWriter().print(json1);
                        break;
                    }
                    case "ListarRecursosDelPerfil": {
                        int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
                        BnRecurso bnRec = new BnRecurso();
                        ArrayList<PERFIL_has_RECURSO> list = bnRec.ListarRecursosDelPerfil(idPerfil);
                        String json1 = new Gson().toJson(list);
                        System.out.println(json1);
                        response.getWriter().print(json1);
                        break;
                    }
                    case "AsignarRecursosDelPerfil": {
                        json = new JsonObject();
                        int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
                        JSONArray ListaPerfiles = new JSONArray();
                        BnRecurso bnRecurso = new BnRecurso();
                        try {
                            ListaPerfiles = new JSONArray(request.getParameter("perfiles"));
                            bnRecurso.BorrarRecursos(idPerfil);
                            for (int i = 0; i < ListaPerfiles.length(); i++) {
                                bnRecurso.AsignarRecursos(idPerfil, ListaPerfiles.getInt(i));
                            }
                        } catch (JSONException ex) {
                            Logger.getLogger(Svl_Recursos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        json.addProperty("estado", D.EST_OK);
                        json.addProperty("descripcion", "Usuario Agregado");
                        response.getWriter().print(json);
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
