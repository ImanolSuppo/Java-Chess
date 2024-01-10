package ar.edu.utn.frc.tup.lciii.Validations;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    private Validation validation = new Validation();
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testKeepRunningNamePlayerIsEmpty(){
        Scanner scanner = new Scanner(System.in);
        String result = "IMA";
        assertEquals(result, validation.keepRunningNamePlayerIsEmpty("IMA", scanner));
    }

    @Test
    public void testKeepRunningTeamColorIsEmpty(){
        Scanner scanner = new Scanner(System.in);
        String result = "W";
        assertEquals(result, validation.keepRunningNamePlayerIsEmpty("W", scanner));
    }

    @Test
    public void testValidateAlgebraicNotation(){
        Scanner scanner = new Scanner(System.in);
        assertTrue(validation.validateAlgebraicNotation("c4"));
    }

    @Test
    public void testKeepRunningAlgebraicNotation(){
        Scanner scanner = new Scanner(System.in);
        String result = null;
        assertEquals(result, validation.keepRunningAlgebraicNotation(scanner, true));
    }

    @Test
    public void testValidateUserName(){
        assertTrue(validation.validateUserName("GUILLERMO"));
    }

    private String getOutput() {
        return testOut.toString();
    }
}
