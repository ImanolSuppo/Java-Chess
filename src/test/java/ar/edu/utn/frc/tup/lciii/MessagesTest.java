package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagesTest {
    TeamColor tm;
    Player playerOne = new Player("raul",tm.WHITE );
    @Test
    public void testplayerAlreadyCreated() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.playerAlreadyCreated();

        // Verificación del comportamiento esperado
        String expectedOutput ="The name you are trying to enter is not available, please try another!";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    @Test
    public void testmessageMistake() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.messageMistake();

        // Verificación del comportamiento esperado
        String expectedOutput ="Ups, you pressed the wrong number. Try again!";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    @Test
    public void testgoToMenu() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.goToMenu();

        // Verificación del comportamiento esperado
        String expectedOutput ="would you like to go to the menu?\n" +
                "Y - Yes \n" +
                "N - No";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    @Test
    public void testplayerWinner() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.playerWinner(playerOne);

        // Verificación del comportamiento esperado
        String expectedOutput ="The winner is " + playerOne.getName() + " ¡congratulation!";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    @Test
    public void testkingWhiteHackeMate() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.kingWhiteHackeMate();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"---------------------------" +System.lineSeparator()+
                "THE WHITE KING IS IN MATE" +System.lineSeparator()+
                "PLAYER TWO HAS WON" +System.lineSeparator()+
                "---------------------------";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testkingWhiteHacke() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.kingWhiteHacke();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"---------------------------" +System.lineSeparator()+
                "THE WHITE KING IS IN HACKED" +System.lineSeparator()+
                "---------------------------";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testkingBlackHackeMate() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.kingBlackHackeMate();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"---------------------------" +System.lineSeparator()+
                "THE BLACK KING IS IN MATE" +System.lineSeparator()+
                "PLAYER ONE HAS WON" +System.lineSeparator()+
                "---------------------------";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testkingBlackHacke() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.kingBlackHacke();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"---------------------------" +System.lineSeparator()+
                "THE BLACK KING IS IN HACKED" +System.lineSeparator()+
                "---------------------------";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testgameUpdated() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.gameUpdated();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Game updated successfully " +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testupdatingGame() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.updatingGame();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"wait, updating game..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testgameInserted() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.gameInserted();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"The game was inserted successfully " +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testinsertingHistoricalMovements() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.insertingHistoricalMovements();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Inserting Board..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testinsertingBoard() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.insertingBoard();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Inserting Board..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testinsertingGame() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.insertingGame();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Creating Game..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testinsertingPlayerTwo() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.insertingPlayerTwo();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Inserting player Two..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testinsertingPlayerOne() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.insertingPlayerOne();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Inserting player One..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testerrorMessage() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.errorMessage();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Ups, you pressed the wrong key. Try with the letter 'Y' or 'N'!" +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testsaveGame() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.saveGame();

        // Verificación del comportamiento esperado
        String expectedOutput ="Do you want to Update/Insert this game? \n" +
                "Y - Yes \n" +
                "N - No";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testenterGame() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.enterGame();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"What game do you want to play? (please enter only the number!)" +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testalertMessageSelectTeamColor() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.alertMessageSelectTeamColor(playerOne.getName());

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Player " + playerOne.getName() + " Select Your Part Colour...    W or B" +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testalertMessageSelectPlayerName() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.alertMessageSelectPlayerName(playerOne.getName());

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"Player " + playerOne.getName() + " Enter Your Name Please..." +System.lineSeparator();
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testalertMessageNameTeamColorEmpty() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.alertMessageNameTeamColorEmpty();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"* ********************************************************************************************************* *"
                +System.lineSeparator() + "* **************************************** ERROR ********************************************************** *"
                +System.lineSeparator() + " THE TEAM COLOR NOT SHOULD BE EMPTY... TRY AGAIN" +
                System.lineSeparator() +"* ********************************************************************************************************* *";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testalertMessageNamePlayerEmpty() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.alertMessageNamePlayerEmpty();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"* ********************************************************************************************************* *"
                +System.lineSeparator() + "* **************************************** ERROR ********************************************************** *"
                +System.lineSeparator() + " THE NAME PLAYER NOT SHOULD BE EMPTY... TRY AGAIN" +
                System.lineSeparator() +"* ********************************************************************************************************* *";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testalertMessageMoveIsNotPossible() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.alertMessageMoveIsNotPossible();

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"* ********************************************************************************************************* *"
                +System.lineSeparator() + "* **************************************** ERROR ********************************************************** *"
                +System.lineSeparator() + " THE POSITION THAT YOU TRY TO MOVE IS NOT AVAILABLE FOR THIS PART , TRY WITH ANOTHER PLEASE..." +
                System.lineSeparator() +"* ********************************************************************************************************* *";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testalertMessageColorTeamIsBad() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.alertMessageColorTeamIsBad(playerOne);

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"¡Player: " + playerOne.getName() + "!"
                +System.lineSeparator() + "Remind that you are team color: " + playerOne.getTeamColor()
                +System.lineSeparator() + "Try Again Please...";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testinputAlgebraicNotation() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.inputAlgebraicNotation(playerOne.getName());

        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"¡Player " + playerOne.getName() + "!" + " Enter Your Movement Using Algebraic Notation a3 ...\n\n";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testvalidateNamePart() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.validateNamePart(playerOne);
        // Verificación del comportamiento esperado
        String expectedOutput =System.lineSeparator()+"* *********************************************************************************************************************************************** *" +System.lineSeparator()+
                "* !" + playerOne.getName() + "¡" + " -- " + "Team Color: " + playerOne.getTeamColor() + ":" + System.lineSeparator() +
                "* THE NAME THAT YOU ENTER NOT  EXIST OR IS INVALID TRY AGAIN..." + System.lineSeparator()+
                "* *********************************************************************************************************************************************** *";
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
    }
    @Test
    public void testAlertMessageMoveIsNotPossible() {
        // Configuración inicial
        Messages messages = new Messages();

        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        messages.enterGame();

        // Verificación del comportamiento esperado
        String expectedOutput ="What game do you want to play? (please enter only the number!)";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
    @Test
    public void testInsertingPlayerOne() {
        // Redirigir la salida a un stream para capturarla
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecución del método void que se desea probar
        Messages messages = new Messages();
        messages.insertingPlayerOne();

        // Verificación del comportamiento esperado
        String expectedOutput = "Inserting player One...";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
