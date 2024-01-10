package ar.edu.utn.frc.tup.lciii.DataBase;

import ar.edu.utn.frc.tup.lciii.Game;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessDataBaseTest {

    ChessDataBase db = new ChessDataBase();
    @Test
    public void testgetConnection() throws ClassNotFoundException, SQLException {
        String URL = "jdbc:mysql://database-1-instance-1.cfz3gcclpabq.us-east-1.rds.amazonaws.com:3306/Ajedrez?serverTimezone=UTC";
        String USER = "admin";
        String PASS = "password";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection expect = db.getConexion();

        Connection result = expect;


        assertEquals(result, expect);
    }
}
