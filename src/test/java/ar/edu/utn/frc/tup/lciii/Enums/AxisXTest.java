package ar.edu.utn.frc.tup.lciii.Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxisXTest {
    private AxisX ax;
    @Test
    public void testFromLetter() {

        AxisX result = ax.fromLetter("A");
        AxisX expected = ax.A;

        assertEquals(expected, result);
    }
    @Test
    public void testFromValue() {

        AxisX result = ax.fromValue(1);
        AxisX expected = ax.A;

        assertEquals(expected, result);
    }
}
