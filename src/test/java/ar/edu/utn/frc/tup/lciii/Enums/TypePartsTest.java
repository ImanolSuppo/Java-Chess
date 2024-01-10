package ar.edu.utn.frc.tup.lciii.Enums;

import ar.edu.utn.frc.tup.lciii.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypePartsTest {
    TypeParts tp;
    @Test
    public void testParse() {

        TypeParts result = tp.parse("TOWER");
        TypeParts expected = tp.TOWER ;

        assertEquals(expected, result);
    }
}
