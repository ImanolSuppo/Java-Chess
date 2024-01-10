package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testWelcomeChess() {
        Messages messages = new Messages();
        String welcomeChess = messages.getWelcomeChess();

        String expectedOutput = "************************************************ Welcome Chess ************************************************\n\n";
        assertEquals(expectedOutput, welcomeChess);
    }

    @Test
    public void testStartGame() {
        Messages messages = new Messages();
        String startGame = messages.getStartGame();

        String expectedOutput = "************************************************ Starting Game ************************************************\n\n";
        assertEquals(expectedOutput, startGame);
    }

    @Test
    public void testExample() {
        Messages messages = new Messages();
        String example = messages.getExample();

        String expectedOutput = "Example : H1W";
        assertEquals(expectedOutput, example);
    }

    @Test
    public void testMensajeInicio() {
        Messages messages = new Messages();
        String mensajeInicio = messages.getMensajeInicio();

        String expectedOutput = "Welcome to the Chess Game!!  \n" +
                "Chose any option \n" +
                " 1) New Game \n" +
                " 2) Load old game \n" +
                " 3) About chess rules \n" +
                " 4) Exit Game";
        assertEquals(expectedOutput, mensajeInicio);
    }

}
