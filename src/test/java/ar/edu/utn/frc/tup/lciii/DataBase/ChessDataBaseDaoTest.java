package ar.edu.utn.frc.tup.lciii.DataBase;

import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import ar.edu.utn.frc.tup.lciii.Game;
import ar.edu.utn.frc.tup.lciii.Player;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessDataBaseDaoTest {
    ChessDataBaseDao helper = new ChessDataBaseDao();
    TeamColor tm;
    Player playerOne = new Player("Guillermo", tm.WHITE);
    Player playerTwo = new Player("Nicolas", tm.BLACK);
    @Test
    public void testSelectIdTile() throws ClassNotFoundException, SQLException {
        int expect = helper.selectIdTile(1);
        int result = 0;
        assertEquals(result, expect);
    }
    @Test
    public void testSelectIdJuego() throws ClassNotFoundException, SQLException {
        int expect = helper.selectIdJuego(playerOne,playerTwo);
        int result = 0;
        assertEquals(result, expect);
    }
    @Test
    public void testSelectIdPlayers() throws ClassNotFoundException, SQLException {
        int expect = helper.selectIdPlayers(playerOne);
        int result = 0;
        assertEquals(result, expect);
    }
    @Test
    public void testSelectGame() throws ClassNotFoundException, SQLException {
        Game expect = helper.selectGame(1,helper.selectHistoricalMovements(1));
        Game result = expect;
        assertEquals(result, expect);
    }

    @Test
    public void testSelectHistoricalMovements() throws ClassNotFoundException, SQLException {
        List<String> expect = helper.selectHistoricalMovements(1);
        List<String> result = expect;
        assertEquals(result, expect);
    }
}
