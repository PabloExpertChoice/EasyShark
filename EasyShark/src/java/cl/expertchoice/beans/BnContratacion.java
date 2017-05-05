package cl.expertchoice.beans;

import SQL.Conexion;
import cl.expertchoice.clases.Contratacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BnContratacion {

    public ArrayList<Contratacion> getContrataciones(int id_empresa) throws SQLException {

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT ID_CONTRATACION, ID_TIPOCONTRATACION, "
                + "ID_EMPRESA, FECHA_ACEPTACION, FECHA_MODIFICACION, ESTADO\n"
                + "FROM easy.LC_CONTRATACION WHERE ID_EMPRESA = ?;";
        conn = Conexion.getConexionEasy();
        pst = conn.prepareStatement(sql);

        pst.setInt(1, id_empresa);
        rs = pst.executeQuery();
        ArrayList<Contratacion> lista = new ArrayList<Contratacion>();
        while (rs.next()) {
            Contratacion cont = new Contratacion();
            cont.setId_contratacion(rs.getLong("ID_CONTRATACION"));
            cont.setId_tipocontratacion(rs.getLong("ID_TIPOCONTRATACION"));
            cont.setId_usuario(rs.getLong("ID_EMPRESA"));
            cont.setFecha_aceptacion(null);
            cont.setFecha_modificacion(null);
            cont.setEstado(rs.getInt("ESTADO"));
            lista.add(cont);
        }
        pst.close();
        Conexion.Desconectar(conn);
        return lista;
    }

    public Boolean updateContrataciones(int id_empresa, int id_tipocontratacion, int estado) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "UPDATE easy.LC_CONTRATACION SET FECHA_MODIFICACION=CURRENT_TIMESTAMP, ESTADO=? \n"
                + "WHERE ID_TIPOCONTRATACION=? AND ID_EMPRESA=?;";
        conn = Conexion.getConexionEasy();
        pst = conn.prepareStatement(sql);

        pst.setInt(1, estado);
        pst.setInt(2, id_tipocontratacion);
        pst.setInt(3, id_empresa);
        Boolean flag = false;
        if (pst.executeUpdate() > 0) {
            flag = true;
        }
        pst.close();
        return flag;

    }
}
