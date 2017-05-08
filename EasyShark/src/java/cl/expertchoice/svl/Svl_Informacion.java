package cl.expertchoice.svl;

import HtmlUnit.BuscarInformacion;
import cl.expertchoice.beans.BnSubsidiary;
import cl.expertchoice.clases.Subsidiary;
import cl.expertchoice.clases.Usuario;
import cl.expertchoice.xml.bnsInformacion;
import java.io.IOException;
import java.io.PrintWriter;
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
import soporte.D;

@WebServlet(name = "Svl_Informacion", urlPatterns = {"/Svl_Informacion", "/Dashboard"})
public class Svl_Informacion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                HttpSession sesion = request.getSession();
                Usuario usuario = (Usuario) sesion.getAttribute(D.SESSION_USUARIO);
                String code = request.getParameter("code");
                JSONObject datos;

                switch (code) {
                    case "dashboard": {
                        int rut = Integer.parseInt(request.getParameter("rut"));
                        String dv = request.getParameter("dv");
                        Subsidiary subsidiary = null;

                        subsidiary = new BnSubsidiary().buscarPorRut(rut);
                        if (subsidiary == null) {
                            if (rut >= 50000000) {
                                subsidiary = new BuscarInformacion().buscarEmpresa(rut, dv);
                            } else {
                                subsidiary = new BuscarInformacion().buscarPersona(rut, dv);
                            }
                        }
                        if (subsidiary != null) {
                            new BnSubsidiary().agregarSubsidiary(subsidiary);
                            request.setAttribute("datos", subsidiary);
                            toPage("/dashboard.jsp", request, response);
                        } else {
                            request.setAttribute("msg", "No se encuentran datos");
                            toPage("/cmd", request, response);
                        }
                        break;
                    }
                    case "dashboard2": {
                        int rut = Integer.parseInt(request.getParameter("rut"));
                        String dv = request.getParameter("dv");
                        Subsidiary subsidiary = null;

                        subsidiary = new BnSubsidiary().buscarPorRut(rut);
                        if (subsidiary == null) {
                            if (rut >= 50000000) {
                                subsidiary = new BuscarInformacion().buscarEmpresa(rut, dv);
                            } else {
                                subsidiary = new BuscarInformacion().buscarPersona(rut, dv);
                            }
                        }
                        if (subsidiary != null) {
                            subsidiary.setRut(rut);
                            subsidiary.setDv(dv);
                            request.setAttribute("datos", subsidiary);
                            toPage("/dashboard.jsp", request, response);
                        } else {
                            request.setAttribute("msg", "No se encuentran datos");
                            toPage("/index.jsp", request, response);
                        }
                        break;
                    }

                    case "transunion": {
                        bnsInformacion bn = new bnsInformacion();
                        String rut = request.getParameter("rut");
                        String dv = request.getParameter("dv");
                        JSONObject jsonInformacion = bn.obtenerInformacion(rut + "-" + dv, usuario);
                        request.setAttribute("datos", jsonInformacion);
                        toPage("/transunion.jsp", request, response);
                        break;
                    }
                    case "home": {
                        datos = new JSONObject(request.getParameter("obDatos"));
                        request.setAttribute("datos", datos);
                        toPage("/dashboard.jsp", request, response);
                        break;
                    }
                    case "jur": {

                        datos = new JSONObject(request.getParameter("obDatos"));
                        request.setAttribute("datos", datos);
                        toPage("/InformacionJuridico.jsp", request, response);
                        break;
                    }
                }
            } catch (JSONException ex) {
                Logger.getLogger(Svl_Informacion.class.getName()).log(Level.SEVERE, null, ex);
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
