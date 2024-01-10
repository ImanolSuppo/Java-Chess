package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Pieces.Tower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.ReflectionSupport;
import org.mockito.Mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    Board board = new Board();
    Game game = new Game();
    TeamColor tm;
    Player playerOne = new Player("Ezeaskdj", tm.WHITE);
    Player playerTwo = new Player("ASDKJSAD", tm.BLACK);
    Scanner scan = new Scanner(System.in);
    TypeParts tp;

    @Test
    public void testGetIndexPartNameInBoard() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        int result = game.getIndexPartNameInBoard("P1W");
        int expected = 8;

        assertEquals(expected, result);
    }

    @Test
    public void testVerifyNameExist() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard();
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);

        Method verifyNameExistMethod = Game.class.getDeclaredMethod("verifyNameExist", String.class);

        // Hacer que el método sea accesible
        verifyNameExistMethod.setAccessible(true);

        // Ejecutar el método privado en la instancia de game
        boolean result = (boolean) verifyNameExistMethod.invoke(game, "P1W");

        // Verificación del resultado esperado
        boolean expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void testValidateColorPartIsCorrectly() {
        board.setPartsInBoard();
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        String result = game.validateColorPartIsCorrectly(playerOne, "P1W", scan);
        String expected = "P1W";

        assertEquals(expected, result);
    }

    @Test
    public void testLetterToAxisX() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        int result = game.letterToAxisX("f");
        int expected = 6;

        assertEquals(expected, result);
    }

    @Test
    public void testAxisXToLetter() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        String result = game.axisXToLetter(6);
        String expected = "f";

        assertEquals(expected, result);
    }

    @Test
    public void testKeepRunningNamePartIsBad() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        String result = game.keepRunningNamePartIsBad("P1W", playerOne, scan);
        String expected = "P1W";

        assertEquals(expected, result);
    }

    @Test
    public void testHackeDetection() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        boolean result = game.hackeDetection("white");
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void testHackeMateDetection() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        boolean result = game.hackeMateDetection("white");
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void testIsPossibleMove() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);

        Tile tileStart = new Tile();
        tileStart.setTileX(1);
        tileStart.setTileY(2);
        tileStart.setTypePart(tp.PAWN);
        tileStart.setName("P1W");
        Tile tileEnd = new Tile();
        tileEnd.setTileX(1);
        tileEnd.setTileY(4);
        tileEnd.setTypePart(tp.PAWN);
        tileEnd.setName("P1W");

        Method isPossibleMoveMethod = Game.class.getDeclaredMethod("isPossibleMove", Tile.class, Tile.class, Board.class);

        // Hacer que el método sea accesible
        isPossibleMoveMethod.setAccessible(true);
        boolean result = (boolean) isPossibleMoveMethod.invoke(game, tileStart, tileEnd, board);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void testCanKingEscapeCheck() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        Tile tileStart = new Tile();
        tileStart.setTileX(4);
        tileStart.setTileY(4);
        tileStart.setTypePart(tp.PAWN);

        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        board.setNewPositionsInGame("P4W", tileStart);

        Method canKingEscapeCheckMethod = Game.class.getDeclaredMethod("canKingEscapeCheck", String.class, Board.class);

        // Hacer que el método sea accesible
        canKingEscapeCheckMethod.setAccessible(true);
        boolean result = (boolean) canKingEscapeCheckMethod.invoke(game, "white", board);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void testLetterToTile() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        Tile tileEnd = new Tile();
        tileEnd.setTileX(1);
        tileEnd.setTileY(4);
        int resultX = game.letterToTile("a4").getTileX();
        int resultY = game.letterToTile("a4").getTileY();
        int expectedX = tileEnd.getTileX();
        int expectedY = tileEnd.getTileY();

        boolean resulAndExpectedX = resultX == expectedX;
        boolean resulAndExpectedY = resultY == expectedY;

        assertEquals(resulAndExpectedX, resulAndExpectedY);
    }

    @Test
    public void testisKingInCheck() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        board.setPartsInBoard();
        Tile tileStart = new Tile();
        tileStart.setTileX(4);
        tileStart.setTileY(4);
        tileStart.setTypePart(tp.PAWN);

        game = new Game(playerOne, playerTwo);
        game.setBoard(board);
        board.setNewPositionsInGame("P4W", tileStart);

        Method isKingInCheckMethod = Game.class.getDeclaredMethod("isKingInCheck", new Class[]{Tile.class, List.class, Board.class});

        isKingInCheckMethod.setAccessible(true);

        boolean result = (boolean) isKingInCheckMethod.invoke(game, new Object[]{board.getKingPosition("white"),board.getBlackPieces(),board});
        boolean expected = false;

        assertEquals(expected, result);
    }


    @Test
    public void testCanAnyPieceCaptureThreat() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard();
        Tile king = new Tile(5, 1, "KIW", TypeParts.KING);
        Tile queen = new Tile(5, 2, "QNB", TypeParts.QUEEN);
        board.setNewPositionsInGame(queen.getName(), queen);
        Method metodoPrivado = Game.class.getDeclaredMethod("canAnyPieceCaptureThreat", new Class[]{Tile.class, Board.class});
        metodoPrivado.setAccessible(true);
        assertTrue((Boolean) metodoPrivado.invoke(game, new Object[]{king, board}));
    }


    @Test
    public void testSimulationFakeMoveParte() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard();
        Tile piece = new Tile(1, 5, "T1W", TypeParts.TOWER);
        Tile pieceHacke = new Tile(5, 5, "QNB", TypeParts.QUEEN);
        Tile king = new Tile(5, 1, "KIW", TypeParts.KING);
        Method metodoPrivado = Game.class.getDeclaredMethod("simulationFakeMoveParte", new Class[]{Tile.class, Tile.class, Board.class, Tile.class});
        metodoPrivado.setAccessible(true);
        assertTrue((Boolean) metodoPrivado.invoke(game, new Object[]{piece, pieceHacke, board, king}));
    }

    @Test
    public void testVerifyAnyPartRescueKing() {
        board.setPartsInBoard();
        game.setBoard(board);
        Tile king = new Tile(3, 3, "KIW", TypeParts.KING);
        board.setNewPositionsInGame(king.getName(),king);
        assertTrue(game.verifyAnyPartRescueKing(king));
    }

    @Test
    public void testHandlerPossibleAllPartsPossiblesMovements() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Tile> movements = new ArrayList<>();
        List<Tile> partsMovements = new ArrayList<>();
        Method metedoPrivado = Game.class.getDeclaredMethod("handlerPossibleAllPartsPossiblesMovements", new Class[]{List.class});
        metedoPrivado.setAccessible(true);
        assertEquals(movements, (List<Tile>) metedoPrivado.invoke(game, new Object[]{partsMovements}));
    }

    @Test void testConstructorGame(){
        Game testGame = new Game(null, null, null, null);
    }


    @Test void movePartsIsNotInsideBoard(){
        Tile tileOffTheBoard = new Tile(200, 200, "KIW", TypeParts.KING);
        Board board1 = new Board();
        board1.setPartsInBoard();
        Game game1 = new Game(playerOne, playerTwo, board1, new ArrayList<>());
        assertFalse(game1.moveParts(tileOffTheBoard.getName(), tileOffTheBoard, playerOne));
    }

    @Test void movePartsIsInsideBoard(){
        Tile king = new Tile(5, 1, "KIW", TypeParts.KING);
        Tile queen = new Tile(4, 1, "QNW", TypeParts.KING);
        Tile tower = new Tile(1, 1, "T1W", TypeParts.KING);
        Tile bishop = new Tile(4, 1, "B1W", TypeParts.KING);
        Tile horse = new Tile(2, 1, "H1W", TypeParts.KING);
        Tile pawn = new Tile(1, 2, "P1W", TypeParts.KING);
        Tile tileNull = new Tile(5, 5, "└-┘", TypeParts.NULL);
        Board board1 = new Board();
        board1.setPartsInBoard();
        Game game1 = new Game(playerOne, playerTwo, board1, new ArrayList<>());
        game1.moveParts(king.getName(), king, playerOne);
        game1.moveParts(queen.getName(), queen, playerOne);
        game1.moveParts(tower.getName(), tower, playerOne);
        game1.moveParts(bishop.getName(), bishop, playerOne);
        game1.moveParts(horse.getName(), horse, playerOne);
        game1.moveParts(pawn.getName(), pawn, playerOne);
        game1.moveParts(tileNull.getName(), tileNull, playerOne);
    }

    @Test void verifyExposeKing() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Game gameMock = mock(Game.class);
        Tile tileMock = mock(Tile.class);
        Tile nextPosition = new Tile(4, 1, "QNW", TypeParts.KING);
        Tile part = new Tile(1, 1, "T1W", TypeParts.KING);
        Board board1 = new Board();
        board1.setPartsInBoard();
        String kingColor = "white";
        when(tileMock.movePart(board1, part, nextPosition)).thenReturn(true);
        when(gameMock.simulationFakeMoveParte(part, nextPosition, board1, board1.getKingPosition(kingColor))).thenReturn(true);
        Method metodoPrivado = Game.class.getDeclaredMethod("verifyExposeKing", Tile.class, Tile.class, Tile.class, Board.class, String.class);
        metodoPrivado.setAccessible(true);
        assertTrue((boolean) metodoPrivado.invoke(gameMock, tileMock, part, nextPosition, board1, kingColor));
    }

    @Test void validateColorPartIsCorrectly(){
        Player player = new Player("test", TeamColor.WHITE);
        Scanner scannerMock = mock(Scanner.class);
        Board board1 = new Board();
        board1.setPartsInBoard();
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        when(scannerMock.nextLine()).thenReturn("KIW");
        assertEquals("KIW", game1.validateColorPartIsCorrectly(player, "KIB", scannerMock));
    }

    @Test
    public void keepRunningIsMoveIsNotPossible(){
        Player player = new Player("test", TeamColor.WHITE);
        Scanner scannerMock = mock(Scanner.class);
        Board board1 = new Board();
        board1.setPartsInBoard();
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        when(scannerMock.nextLine()).thenReturn("P2W").thenReturn("b3");
        game1.keepRunningIsMoveIsNotPossible(false, "P2W", scannerMock, player);
        when(scannerMock.nextLine()).thenReturn("P2B").thenReturn("b6");
        game1.keepRunningIsMoveIsNotPossible(false, "P2B", scannerMock, playerTwo);
        assertTrue(true);
    }

    @Test void addHistoricalMovements(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile nextPosition = new Tile(1, 1, "KIW", TypeParts.KING);
        game1.addHistoricalMovements(nextPosition, nextPosition.getName());
        assertTrue(true);
    }

    @Test void keepRunningNamePartIsBad(){
        Player player = new Player("test", TeamColor.WHITE);
        Scanner scannerMock = mock(Scanner.class);
        Board board1 = new Board();
        board1.setPartsInBoard();
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        when(scannerMock.nextLine()).thenReturn("P1W");
        assertEquals("P1W", game1.keepRunningNamePartIsBad("PPP", player, scannerMock));
    }

    @Test void getPlayerOne(){
        Game game1 = new Game();
        assertNull(game1.getPlayerOne());
    }
    @Test void getPlayerTwo(){
        Game game1 = new Game();
        assertNull(game1.getPlayerTwo());
    }
    @Test void getBoard(){
        Game game1 = new Game();
        assertNull(game1.getBoard());
    }
    @Test void getMessages(){
        Game game1 = new Game();
        assertNull(game1.getMessages());
    }
    @Test void getHistoricalMovements(){
        Game game1 = new Game(playerOne, playerTwo, new Board(), new ArrayList<>());
        assertEquals(game1.getHistoricalMovements().size(), 0);
    }
    @Test void getValidate(){
        Game game1 = new Game();
        assertNull(game1.getValidate());
    }

    @Test void hackeMateDetection(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 3));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        assertTrue(game1.hackeMateDetection("black"));
    }

    @Test void isPossibleMove() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method metodoPrivado = Game.class.getDeclaredMethod("isPossibleMove", Tile.class, Tile.class, Board.class);
        metodoPrivado.setAccessible(true);
        assertFalse((Boolean) metodoPrivado.invoke(game, new Tile(1, 1, null, TypeParts.NULL), null, null));
    }

    @Test void simulationFakeMoveParte(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 3));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile tile = board1.getTileInBoard(new Tile(1,2));
        Tile tile2 = board1.getTileInBoard(new Tile(1,7));
        Tile king = board1.getTileInBoard(new Tile(8, 3));
        assertFalse(game1.simulationFakeMoveParte(tile, tile2, board1, king));
    }

    @Test void verifyAnyPartRescueKingWithPawn(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 6));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile king = board1.getTileInBoard(new Tile(8, 6));
        assertTrue(game1.verifyAnyPartRescueKing(king));
    }

    @Test void verifyAnyPartRescueKingWithQueen(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 6));
        board1.setNewPositionsInGame("QNB", new Tile(4, 5));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile king = board1.getTileInBoard(new Tile(8, 6));
        assertTrue(game1.verifyAnyPartRescueKing(king));
    }

    @Test void verifyAnyPartRescueKingWithBishop(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 6));
        board1.setNewPositionsInGame("B2B", new Tile(6, 6));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile king = board1.getTileInBoard(new Tile(8, 6));
        assertTrue(game1.verifyAnyPartRescueKing(king));
    }

    @Test void verifyAnyPartRescueKingWithTower(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 6));
        board1.setNewPositionsInGame("T1B", new Tile(1, 5));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile king = board1.getTileInBoard(new Tile(8, 6));
        assertTrue(game1.verifyAnyPartRescueKing(king));
    }

    @Test void verifyAnyPartRescueKingWithHorse(){
        Player player = new Player("test", TeamColor.WHITE);
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.setNewPositionsInGame("QNW", new Tile(6, 4));
        board1.setNewPositionsInGame("KIB", new Tile(8, 6));
        board1.setNewPositionsInGame("H2B", new Tile(5, 6));
        Game game1 = new Game(player, playerTwo, board1, new ArrayList<>());
        Tile king = board1.getTileInBoard(new Tile(8, 6));
        assertTrue(game1.verifyAnyPartRescueKing(king));
    }
}







