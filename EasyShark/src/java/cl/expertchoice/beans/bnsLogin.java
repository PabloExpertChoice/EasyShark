package cl.expertchoice.beans;

import SQL.Conexion;
import cl.expertchoice.clases.Perfil;
import cl.expertchoice.clases.Status;
import cl.expertchoice.clases.Subsidiary;
import cl.expertchoice.clases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import soporte.D;

public class bnsLogin {

    public Usuario iniciarSesion(String email, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            
            String sql = "SELECT USU.id, USU.nomb, USU.apellpat, USU.apellmat, USU.email,\n"
                    + "EMP.id, EMP.nombre, EMP.rut, \n"
                    + "ESTADO.id, ESTADO.nomb,\n"
                    + "PER.id, PER.nomb\n"
                    + "FROM " + D.ESQUEMA + ".`USER` AS USU\n"
                    + "INNER JOIN " + D.ESQUEMA + ".SUBSIDIARY AS EMP\n"
                    + "ON USU.subsidiary_id = EMP.id\n"
                    + "INNER JOIN " + D.ESQUEMA + ".STATUS AS ESTADO\n"
                    + "ON USU.status_id = ESTADO.id\n"
                    + "INNER JOIN " + D.ESQUEMA + ".PERFIL AS PER\n"
                    + "ON USU.perfil_id = PER.id\n"
                    + "WHERE USU.email = ?\n"
                    + "AND BINARY USU.clave = ?\n"
                    + "AND USU.status_id = 2";

            conn = Conexion.getConexionEasy();
            pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("USU.id"));
                usuario.setNombre(rs.getString("USU.nomb"));
                usuario.setApePaterno(rs.getString("USU.apellpat"));
                usuario.setApeMaterno(rs.getString("USU.apellmat"));
                usuario.setEmail(rs.getString("USU.email"));
                
                Subsidiary sub = new Subsidiary();
                sub.setId(rs.getInt("EMP.id"));
                sub.setNombre(rs.getString("EMP.nombre"));
                sub.setRut(rs.getInt("EMP.rut"));
                usuario.setSubsidiary(sub);

                usuario.setEstado(new Status(rs.getInt("ESTADO.id"), rs.getString("ESTADO.nomb"), ""));
                Perfil perfil = new Perfil(rs.getInt("PER.id"), rs.getString("PER.nomb"));
                usuario.setPerfil(perfil);

                /**
                 * Obtener la lista de los recursos a los cuales el usuario
                 * tiene permisos para acceder
                 */
                usuario.setRecursos(new BnRecurso().obtenerPorPerfil(perfil));
            }
        } finally {
            Conexion.Desconectar(conn);
        }
        return usuario;
    }
}
