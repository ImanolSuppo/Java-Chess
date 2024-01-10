package ar.edu.utn.frc.tup.lciii.DataBase;

import java.sql.*;

public class ChessDataBase {
    private static final String URL = "jdbc:mysql://database-1-instance-1.cfz3gcclpabq.us-east-1.rds.amazonaws.com:3306/Ajedrez?serverTimezone=UTC";
    //database-1-instance-1.cfz3gcclpabq.us-east-1.rds.amazonaws.com //conexion mysql
    //user = admin
    //contraseña = password
    private static final String USER = "admin";
    private static final String PASS = "password";

    public static Connection getConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASS);
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }

    public static void close(PreparedStatement ps) throws SQLException{
        ps.close();
    }

    public static void close(Connection cnn) throws SQLException{
        cnn.close();
    }
}