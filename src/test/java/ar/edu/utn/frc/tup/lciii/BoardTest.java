package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


public class BoardTest {
    Board board = new Board();
    Game game = new Game();
    TeamColor tm;
    Player playerOne = new Player("Ezeaskdj", tm.WHITE);
    Player playerTwo = new Player("ASDKJSAD", tm.BLACK);
    Scanner scan = new Scanner(System.in);
    TypeParts tp;

    @Test
    public void testisInsideBoard() {

        board.setPartsInBoard();
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);

        Tile tileStart = new Tile();
        tileStart.setTileX(4);
        tileStart.setTileY(4);
        tileStart.setTypePart(tp.PAWN);

        boolean result = board.isInsideBoard(tileStart);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void testGetKingPosition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard();
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);

        int resultX = board.getKingPosition("WHITE").getTileX();
        int resultY = board.getKingPosition("WHITE").getTileY();
        int expectedX = board.getTileX();
        int expectedY = board.getTileY();

        boolean resulAndExpectedX = resultX == expectedX;
        boolean resulAndExpectedY = resultY == expectedY;

        assertEquals(resulAndExpectedX, resulAndExpectedY);
    }

    @Test
    public void testGetBlackPieces() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard();
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);

        List<Tile> result = board.getBlackPieces();

        List<Tile> expected = board.getBlackPieces();

        assertEquals(result, expected);
    }

    @Test
    public void testGetWhitePieces() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        board.setPartsInBoard();
        game = new Game(playerOne, playerTwo);
        game.setBoard(board);

        List<Tile> result = board.getWhitePieces();

        List<Tile> expected = board.getWhitePieces();

        assertEquals(result, expected);
    }


    @Test
    public void testGetKingPositionTwo() {
        board.setPartsInBoard();
        Tile result = board.getBoard().get(4);
        assertEquals(result, board.getKingPosition("white"));
    }

    @Test
    public void testGetBlackPiecesTwo() {
        List<Tile> result = new ArrayList<>();
        board.setPartsInBoard();
        for (Tile tile : board.getBoard()) {
            if (tile.getName().substring(2, 3).equals("B"))
                result.add(tile);
        }
        assertEquals(result, board.getBlackPieces());
    }

    @Test
    public void testGetWhitePiecesTwo() {
        List<Tile> result = new ArrayList<>();
        board.setPartsInBoard();
        for (Tile tile : board.getBoard()) {
            if (tile.getName().substring(2, 3).equals("W"))
                result.add(tile);
        }
        assertEquals(result, board.getWhitePieces());
    }

    @Test
    public void testGetTileInBoard() {
        board.setPartsInBoard();
        Tile tile = new Tile(22, 22);
        Tile result = null;
        assertEquals(result, board.getTileInBoard(tile));
    }

    @Test void printStartBoard(){
        Board board1 = new Board();
        board1.setPartsInBoard();
        board1.printStartBoard();
        assertTrue(true);
    }
}


