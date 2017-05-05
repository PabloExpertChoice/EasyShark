/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.expertchoice.beans;

import SQL.Conexion;
import cl.expertchoice.clases.RegistroBlackList;
import cl.expertchoice.clases.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import soporte.D;

/**
 *
 * @author jhonncard
 */
public class BnStatus {

    public ArrayList<Status> ListaEstados() throws SQLException {
        Connection conn = null;
        conn = Conexion.getConexionEasy();

        String sql = "SELECT id, nomb, descripcion FROM "+D.ESQUEMA+".STATUS;";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        ArrayList<Status> lista = new ArrayList<Status>();
        while (rs.next()) {
            Status estado = new Status();
            estado.setId(rs.getInt("id"));
            estado.setNombre(rs.getString("nomb"));
            estado.setDescripcion(rs.getString("descripcion"));
            lista.add(estado);
        }
        pst.close();
        Conexion.Desconectar(conn);
        return lista;
    }
    
    public Status buscarPorId(int id) {
        Connection conn = null;
        Status statusBuscado = null;
        try {
            conn = Conexion.getConexionEasy();
            String sql = "SELECT id, nomb, descripcion \n"
                    + "FROM " + D.ESQUEMA + ".STATUS \n"
                    + "WHERE id = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                statusBuscado = new Status();
                statusBuscado.setId(rs.getInt("id"));
                statusBuscado.setNombre(rs.getString("nomb"));
                statusBuscado.setDescripcion(rs.getString("descripcion"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.Desconectar(conn);
        }
        return statusBuscado;
    }
}
