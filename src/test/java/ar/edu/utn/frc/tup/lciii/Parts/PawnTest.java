package ar.edu.utn.frc.tup.lciii.Parts;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Game;
import ar.edu.utn.frc.tup.lciii.Pieces.Bishop;
import ar.edu.utn.frc.tup.lciii.Pieces.King;
import ar.edu.utn.frc.tup.lciii.Pieces.Pawn;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.ReflectionSupport;

public class PawnTest {
    private Board board = new Board();;

    @Test
    public void testPawnMove() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        Pawn pawn = new Pawn(4,2, "P4W");
        Tile tileEnd = new Tile();
        tileEnd.setTileX(4);
        tileEnd.setTileY(4);

        boolean result = pawn.movePart(board,pawn, tileEnd);
        boolean expected = true;

        Assertions.assertEquals(expected, result);
    }
    @Test
    public void testPawnMoveF() {
        board.setPartsInBoard(); //PONER PUBLICO O VER COMO HACERLO CON REFFLECTIONSUPPORT
        Pawn pawn = new Pawn(4,2, "P4W");
        Tile tileEnd = new Tile();
        tileEnd.setTileX(4);
        tileEnd.setTileY(5);

        boolean result = pawn.movePart(board,pawn, tileEnd);
        boolean expected = false;

        Assertions.assertEquals(expected, result);
    }

}
