package cl.expertchoice.beans;

import SQL.Conexion;
import cl.expertchoice.clases.PERFIL_has_RECURSO;
import cl.expertchoice.clases.Perfil;
import cl.expertchoice.clases.Recurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import soporte.D;

public class BnRecurso {

    public ArrayList<Recurso> obtenerPorPerfil(Perfil perfil) throws SQLException {
        Connection conn = null;
        ArrayList<Recurso> arr = new ArrayList<>();
        try {
            conn = Conexion.getConexionEasy();
            String sql = "SELECT REC.ID_RECURSO, REC.URL, REC.TITULO, REC.ICONO \n"
                    + "FROM easy.PERFIL_has_RECURSO AS PER_REC\n"
                    + "INNER JOIN easy.RECURSO AS REC\n"
                    + "ON PER_REC.ID_RECURSO = REC.ID_RECURSO\n"
                    + "WHERE PER_REC.PERFIL_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, perfil.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Recurso r = new Recurso(rs.getInt("REC.ID_RECURSO"), rs.getString("REC.TITULO"), rs.getString("REC.ICONO"), rs.getString("REC.URL"));
                arr.add(r);
            }
        } finally {
            Conexion.Desconectar(conn);
        }

        return arr;
    }

    public ArrayList<Recurso> ListarRecursos() throws SQLException {
        Connection conn = null;
        conn = Conexion.getConexionEasy();

        String sql = "SELECT id_recurso, titulo, url, icono FROM " + D.ESQUEMA + ".RECURSO";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        ArrayList<Recurso> lista = new ArrayList<Recurso>();
        while (rs.next()) {
            Recurso recursos = new Recurso();
            recursos.setId(rs.getInt("id_recurso"));
            recursos.setTitulo(rs.getString("titulo"));
            recursos.setUrl(rs.getString("url"));
            recursos.setIcono(rs.getString("icono"));
            lista.add(recursos);
        }
        pst.close();
        Conexion.Desconectar(conn);
        return lista;
    }

    public ArrayList<PERFIL_has_RECURSO> ListarRecursosDelPerfil(int idPerfil) throws SQLException {
        Connection conn = null;
        conn = Conexion.getConexionEasy();

        String sql = "SELECT ID_PERFIL_RECURSO, PERFIL_id, ID_RECURSO FROM " + D.ESQUEMA + ".PERFIL_has_RECURSO "
                + "WHERE PERFIL_id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idPerfil);
        ResultSet rs = pst.executeQuery();
        ArrayList<PERFIL_has_RECURSO> lista = new ArrayList<PERFIL_has_RECURSO>();
        while (rs.next()) {
            PERFIL_has_RECURSO perfilRe = new PERFIL_has_RECURSO();
            perfilRe.setId(rs.getInt("ID_PERFIL_RECURSO"));
            perfilRe.setIdPerfil(rs.getInt("PERFIL_id"));
            perfilRe.setIdRecurso(rs.getInt("ID_RECURSO"));
            lista.add(perfilRe);
        }
        pst.close();
        Conexion.Desconectar(conn);
        return lista;
    }

    public void BorrarRecursos(int idPerfil) throws SQLException {
        Connection conn = null;
        conn = Conexion.getConexionEasy();
        String sql = "DELETE FROM  " + D.ESQUEMA + ".PERFIL_has_RECURSO\n"
                + "WHERE PERFIL_id=?;";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idPerfil);
        pst.executeUpdate();
        pst.close();
        Conexion.Desconectar(conn);
    }

    public void AsignarRecursos(int idPerfil, int idRecurso) throws SQLException {
        Connection conn = null;
        conn = Conexion.getConexionEasy();
        String sql = "INSERT INTO "+D.ESQUEMA+".PERFIL_has_RECURSO (PERFIL_id, ID_RECURSO)"
                +"VALUES(?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, idPerfil);
        pst.setInt(2, idRecurso);
        pst.executeUpdate();
        pst.close();
        Conexion.Desconectar(conn);
    }
}
