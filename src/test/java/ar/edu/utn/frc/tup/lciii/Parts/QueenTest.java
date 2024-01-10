package ar.edu.utn.frc.tup.lciii.Parts;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Pieces.Pawn;
import ar.edu.utn.frc.tup.lciii.Pieces.Queen;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QueenTest {
    private Board board = new Board();;

    @Test
    public void testQueenMoveTrue_1() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(5, 5, "QNW", TypeParts.QUEEN);
        board.setNewPositionsInGame(startPosition.getName(), startPosition);
        Tile nextPosition = new Tile(5, 7, "P5B", TypeParts.PAWN);
        boolean result = queen.movePart(board, startPosition, nextPosition);
        boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testQueenMoveFalse_1() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(4, 1, "QNW", TypeParts.QUEEN);
        Tile nextPosition = new Tile(1, 1, "T1W", TypeParts.TOWER);
        boolean result = queen.movePart(board, startPosition, nextPosition);
        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testQueenMoveTrue_2() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(5, 5, "QNW", TypeParts.QUEEN);
        board.setNewPositionsInGame(startPosition.getName(), startPosition);
        Tile nextPosition = new Tile(5, 6, "KIB", TypeParts.KING);
        boolean result = queen.movePart(board, startPosition, nextPosition);
        boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testQueenMoveFalse_2() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(4, 1, "QNW", TypeParts.QUEEN);
        Tile nextPosition = new Tile(1, 8, "T1B", TypeParts.TOWER);
        boolean result = queen.movePart(board, startPosition, nextPosition);
        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testQueenMoveTrue_3() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(5, 5, "QNB", TypeParts.QUEEN);
        board.setNewPositionsInGame(startPosition.getName(), startPosition);
        Tile nextPosition = new Tile(8, 2, "P8W", TypeParts.PAWN);
        boolean result = queen.movePart(board, startPosition, nextPosition);
        boolean expected = true;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testQueenMoveFalse_3() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(4, 1, "QNW", TypeParts.QUEEN);
        Tile nextPosition = new Tile(5, 1, "QNW", TypeParts.TOWER);
        boolean result = queen.movePart(board, startPosition, nextPosition);
        boolean expected = false;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testQueenMovePossibleMovements() {
        board.setPartsInBoard();
        Queen queen = new Queen(4,3);
        Tile startPosition = new Tile(4, 1, "QNW", TypeParts.QUEEN);
        List<Tile> result = queen.getPossibleMovements(startPosition, board);
        int expected = 0;
        Assertions.assertEquals(expected, result.size());
    }


}
