package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            String servidor = "jdbc:mysql://192.168.100.2/southcone";
            String servidor = "jdbc:mysql://54.202.128.106/CacheTransunion";
            String usuario = "desarrollo";
            String password = "+2017desarrollo";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            conexion.setAutoCommit(true);
        } catch (ClassNotFoundException ex) {
            conexion = null;
        } catch (SQLException ex) {
            conexion = null;
        } catch (Exception ex) {
            conexion = null;
        }
        return conexion;
    }
    public static Connection getConexionEasy() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String servidor = "jdbc:mysql://192.168.100.2/easy";
            String usuario = "desarrollo";
            String password = "clavetemporal";
            conexion = DriverManager.getConnection(servidor, usuario, password);
            conexion.setAutoCommit(true);
        } catch (ClassNotFoundException ex) {
            conexion = null;
        } catch (SQLException ex) {
            conexion = null;
        } catch (Exception ex) {
            conexion = null;
        }
        return conexion;
    }

    public static boolean Desconectar(Connection conn) {
        boolean flag = false;
        try {
            if (conn == null || conn.isClosed()) {
                return true;
            }

            if (conn.isReadOnly()) {
                conn.rollback();
            } else {
                if (!conn.getAutoCommit()) {
                    conn.commit();
                }
            }

            conn.close();
            conn = null;
            flag = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return flag;
    }
}
