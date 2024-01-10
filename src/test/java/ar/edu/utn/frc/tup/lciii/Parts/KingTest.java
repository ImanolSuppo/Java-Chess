package ar.edu.utn.frc.tup.lciii.Parts;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Game;
import ar.edu.utn.frc.tup.lciii.Horse;
import ar.edu.utn.frc.tup.lciii.Pieces.King;
import ar.edu.utn.frc.tup.lciii.Pieces.Tower;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingTest {
    private Board board;
    private King king;

    @BeforeEach
    public void setup() {
        board = new Board();
        king = new King(5, 5);
    }


    @Test
    public void testMovePart_ValidMove_ReturnsTrue() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(5, 5, "KIB"); // Posición de inicio válida
        Tile nextPosition = new Tile(5, 4, "KIW"); // Posición de destino válida
        board.setNewPositionsInGame("KIB",startPosition);

        boolean result = king.movePart(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testMovePart_InvalidMove_ReturnsFalse() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "KIW"); // Posición de inicio válida
        Tile nextPosition = new Tile(5, 6 , "KIW"); // Posición de destino inválida
        board.setNewPositionsInGame("KIW",startPosition);

        boolean result = king.movePart(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }

    @Test
    public void verifyEndGameWhenSomeKingIsNoPresentTest() {

        board.setPartsInBoard();
        board.getBoard().get(4).setName("123");

        Game game = new Game();

        Assertions.assertFalse(game.verifyEndGameWhenSomeKingIsNoPresent(board.getBoard()));



    }
}
