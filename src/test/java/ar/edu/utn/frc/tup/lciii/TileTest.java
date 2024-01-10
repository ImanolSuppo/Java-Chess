package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TileTest {


    Board board = new Board();
    Tile tile = new Tile();

    @Test
    public void testGetMovementsInAxis(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(1,1,"T1W", TypeParts.TOWER);
        List<Tile> result = new ArrayList<>();
        assertEquals(result, tile.getMovementsInAxis(board, startPosition));
    }

    @Test
    public void testGetMovementsInDiagonal(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(3,1,"B1W", TypeParts.BISHOP);
        List<Tile> result = new ArrayList<>();
        assertEquals(result, tile.getMovementsInAxis(board, startPosition));
    }

    @Test
    public void testVerifyIsDifferentTeam(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(3,2,"P3W", TypeParts.PAWN);
        Tile nextPosition = new Tile(3,7,"P3W", TypeParts.PAWN);
        assertFalse(tile.verifyIsDifferentTeam(startPosition, nextPosition, board));
    }

    @Test
    public void testMovePart(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(3,2,"P3W", TypeParts.PAWN);
        Tile nextPosition = new Tile(3,7,"P3W", TypeParts.PAWN);
        assertFalse(tile.movePart(board, startPosition, nextPosition));
    }
    @Test
    public void testGetName(){
        Tile startPosition = new Tile(1,1,"T1W", TypeParts.TOWER);
        String result = "T1W";
        assertEquals(result, startPosition.getName());
    }
    @Test
    public void testGetTileX(){
        Tile startPosition = new Tile(1,1,"T1W", TypeParts.TOWER);
        int result = 1;
        assertEquals(result, startPosition.getTileX());
    }

    @Test
    public void testGetTileY(){
        Tile startPosition = new Tile(1,1,"T1W", TypeParts.TOWER);
        int result = 1;
        assertEquals(result, startPosition.getTileY());
    }
    @Test
    public void testGetMovementsInAxis2(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(8,8,"T2B", TypeParts.TOWER);
        List<Tile> result = new ArrayList<>();
        assertEquals(result, tile.getMovementsInAxis(board, startPosition));
    }

    @Test
    public void testGetMovementsInDiagonal2(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(3,8,"B1B", TypeParts.BISHOP);
        List<Tile> result = new ArrayList<>();
        assertEquals(result, tile.getMovementsInAxis(board, startPosition));
    }

    @Test
    public void testVerifyIsDifferentTeam2(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(3,2,"P3B", TypeParts.PAWN);
        Tile nextPosition = new Tile(3,7,"P3B", TypeParts.PAWN);
        assertFalse(tile.verifyIsDifferentTeam(startPosition, nextPosition, board));
    }

    @Test
    public void testMovePart2(){
        board.setPartsInBoard();
        Tile startPosition = new Tile(1,1,"T1W", TypeParts.PAWN);
        Tile nextPosition = new Tile(4,1,"QNW", TypeParts.PAWN);
        assertFalse(tile.movePart(board, startPosition, nextPosition));
    }
    @Test
    public void testGetName2(){
        Tile startPosition = new Tile(5,1,"KIW", TypeParts.KING);
        String result = "KIW";
        assertEquals(result, startPosition.getName());
    }
    @Test
    public void testGetTileX2(){
        Tile startPosition = new Tile(5,1,"KIW", TypeParts.KING);
        int result = 5;
        assertEquals(result, startPosition.getTileX());
    }

    @Test
    public void testGetTileY2(){
        Tile startPosition = new Tile(5,8,"KIB", TypeParts.KING);
        int result = 8;
        assertEquals(result, startPosition.getTileY());
    }
}
