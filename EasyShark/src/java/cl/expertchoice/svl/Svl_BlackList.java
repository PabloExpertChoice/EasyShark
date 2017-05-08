/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.expertchoice.svl;

import cl.expertchoice.beans.BnBlackList;
import cl.expertchoice.clases.RegistroBlackList;
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
public class Svl_BlackList extends HttpServlet {

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
                case "setBlackList": {
                        String id_empresa = request.getParameter("id_empresa");
                        String id_usuario = request.getParameter("id_usuario");
                        String comentario = request.getParameter("comentario");
                        String estadoBL = request.getParameter("estado");
                        String rut = request.getParameter("rut");
                        String comentarioBL = acentos(comentario);
                        BnBlackList bn = new BnBlackList();  
                        Boolean insertado = bn.insertarBlackList(Integer.parseInt(id_empresa),
                                comentarioBL, Integer.parseInt(estadoBL), Integer.parseInt(id_usuario), Integer.parseInt(rut));
                        out.print(insertado);
                        break; 
                }
                case "verBlackListXrut": {
                        String rut = request.getParameter("rut");
                        BnBlackList bn = new BnBlackList();  
                        ArrayList<RegistroBlackList> list= bn.verBlackListxRut(Integer.parseInt(rut));
                        String json = new Gson().toJson(list);
                        out.print(json);                        
                        break; 
                }
                case "verBlackListXempresa": {
                        String rut = request.getParameter("rut");
                        String id_empresa = request.getParameter("id_empresa");                        
                        BnBlackList bn = new BnBlackList();  
                        ArrayList<RegistroBlackList> list= bn.verBlackListxEmpresa(Integer.parseInt(rut),Integer.parseInt(id_empresa));
                        String json = new Gson().toJson(list);
                        out.print(json);                        
                        break; 
                }
                case "verBlackListXusuario": {
                        String rut = request.getParameter("rut");
                        String id_usuario = request.getParameter("id_usuario");                        
                        BnBlackList bn = new BnBlackList();  
                        ArrayList<RegistroBlackList> list= bn.verBlackListxUsuario(Integer.parseInt(rut),Integer.parseInt(id_usuario));
                        String json = new Gson().toJson(list);
                        out.print(json);                        
                        break; 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Svl_BlackList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String acentos(String string) {
        StringBuffer sb = new StringBuffer(string.length());
        // true if last char was blank
        boolean lastWasBlankChar = false;
        int len = string.length();
        char c;

        for (int i = 0; i < len; i++) {
            c = string.charAt(i);
            if (c == ' ') {
                // blank gets extra work,
                // this solves the problem you get if you replace all
                // blanks with &nbsp;, if you do that you loss
                // word breaking
                if (lastWasBlankChar) {
                    lastWasBlankChar = false;
                    sb.append("&nbsp;");
                } else {
                    lastWasBlankChar = true;
                    sb.append(' ');
                }
            } else {
                lastWasBlankChar = false;
                //
                // HTML Special Chars
                if (c == '"') {
                    sb.append("&quot;");
                } else if (c == '&') {
                    sb.append("&amp;");
                } else if (c == '<') {
                    sb.append("&lt;");
                } else if (c == '>') {
                    sb.append("&gt;");
                } else if (c == 'á') {//
                    sb.append("&aacute;");
                } else if (c == 'Á') {
                    sb.append("&Aacute;");
                } else if (c == 'é') {
                    sb.append("&eacute;");
                } else if (c == 'É') {
                    sb.append("&Eacute;");
                } else if (c == 'í') {
                    sb.append("&iacute;");
                } else if (c == 'Í') {
                    sb.append("&Iacute;");
                } else if (c == 'ó') {
                    sb.append("&oacute;");
                } else if (c == 'Ó') {
                    sb.append("&Oacute;");
                } else if (c == 'ú') {
                    sb.append("&uacute;");
                } else if (c == 'Ú') {
                    sb.append("&Uacute;");
                } else if (c == 'ñ') {
                    sb.append("&ntilde;");
                } else if (c == '\n') // Handle Newline
                {
                    sb.append("&lt;br/&gt;");
                } else {
                    int ci = 0xffff & c;
                    if (ci < 160) // nothing special only 7 Bit
                    {
                        sb.append(c);
                    } else {
                        // Not 7 Bit use the unicode system
                        sb.append("&#");
                        sb.append(new Integer(ci).toString());
                        sb.append(';');
                    }
                }
            }
        }
        return sb.toString();
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
