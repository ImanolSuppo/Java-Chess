package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    TeamColor tm;
    Player player = new Player("Raul", tm.WHITE );
    @Test
    public void testGetPlayer() {

        String result = player.getName();
        String expect = "Raul";
        assertEquals(result, expect);
    }
    @Test
    public void testGetTeamColor() {

        TeamColor result = player.getTeamColor();
        TeamColor expect = tm.WHITE;
        assertEquals(result, expect);
    }

    @Test
    public void testSetNombre() {
        player.setName("Nico");
        String result = player.getName();
        String expect = "Nico";
        assertEquals(result, expect);
    }

    @Test
    public void testSetTeamColor() {
        player.setTeamColor(tm.BLACK);
        TeamColor result = player.getTeamColor();
        TeamColor expect = tm.BLACK;
        assertEquals(result, expect);
    }

    @Test
    public void testToString() {
        String result = player.toString();
        String expect = "Players{" +
                "nombre='" + "Raul" + '\'' +
                '}';
        assertEquals(result, expect);
    }

}
