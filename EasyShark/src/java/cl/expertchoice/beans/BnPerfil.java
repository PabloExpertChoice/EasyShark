/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.expertchoice.beans;

import SQL.Conexion;
import cl.expertchoice.clases.Perfil;
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
public class BnPerfil {

    public ArrayList<Perfil> ListaPerfil() throws SQLException {
        Connection conn = null;
        conn = Conexion.getConexionEasy();

        String sql = "SELECT id, nomb FROM " + D.ESQUEMA + ".PERFIL;";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        while (rs.next()) {
            Perfil perfil = new Perfil();
            perfil.setId(rs.getInt("id"));
            perfil.setNombre(rs.getString("nomb"));
            lista.add(perfil);
        }
        pst.close();
        Conexion.Desconectar(conn);
        return lista;
    }

    public Perfil buscarPorId(int id) {
        Connection conn = null;
        Perfil perfilBuscado = null;
        try {
            conn = Conexion.getConexionEasy();
            String sql = "SELECT id, nomb \n"
                    + "FROM " + D.ESQUEMA + ".PERFIL \n"
                    + "WHERE id = ? ";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                perfilBuscado = new Perfil();
                perfilBuscado.setId(rs.getInt("id"));
                perfilBuscado.setNombre(rs.getString("nomb"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            Conexion.Desconectar(conn);
        }
        return perfilBuscado;
    }
}
