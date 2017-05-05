/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.expertchoice.svl;

import cl.expertchoice.beans.BnContratacion;
import cl.expertchoice.clases.Contratacion;
import com.google.gson.Gson;
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

/**
 *
 * @author jgalleguillos
 */
public class Svl_Contratacion extends HttpServlet {

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
            String accion = request.getParameter("accion");
            switch (accion) {

                case "verContratacion": {
                    String id_empresa = request.getParameter("id_empresa");
                    BnContratacion bn = new BnContratacion();
                    ArrayList<Contratacion> list = null;
                    try {
                        list = bn.getContrataciones(Integer.parseInt(id_empresa));
                    } catch (SQLException ex) {
                        Logger.getLogger(Svl_Contratacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String json = new Gson().toJson(list);
                    out.print(json);
                    break;
                }
                case "updateContratacion": {
                    String id_empresa = request.getParameter("id_empresa");
                    String id_tipocontratacion = request.getParameter("id_tipocontratacion");
                    String estado = request.getParameter("estado");
                    
                    BnContratacion bn = new BnContratacion();
                    ArrayList<Contratacion> list = null;
                    boolean flag;
                    try {
                        flag = bn.updateContrataciones(Integer.parseInt(id_empresa),Integer.parseInt(id_tipocontratacion),Integer.parseInt(estado));
                    } catch (SQLException ex) {
                         flag = false;
                    }
                    out.print(flag);
                    break;
                }                
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

}
