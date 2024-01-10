package ar.edu.utn.frc.tup.lciii.Parts;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Horse;
import ar.edu.utn.frc.tup.lciii.Pieces.Tower;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TowerTest {
    private Board board;
    private Tower tower;

    @BeforeEach
    public void setup() {
        board = new Board();
        tower = new Tower(3, 3);
    }

    @Test
    public void testMovePart_ValidMove_ReturnsTrue() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(3, 3,"T1W");
        Tile nextPosition = new Tile(3, 6, "T1W");

        board.setNewPositionsInGame("T1W",startPosition);

        boolean result = tower.movePart(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testMovePart_InvalidMove_ReturnsFalse() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(3, 3,"T1W");
        Tile nextPosition = new Tile(7, 5,"T1W");

        board.setNewPositionsInGame("T1W",startPosition);

        boolean result = tower.movePart(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }
    @Test
    public void testIsPossibleMovement_ValidMovement_ReturnsTrue() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(3, 3, "T1W"); // Posición de inicio válida (misma posición de la torre)
        Tile nextPosition = new Tile(3, 7, "T1W"); // Posición de destino válida (movimiento vertical hacia arriba)

        board.setNewPositionsInGame("T1W",startPosition);

        boolean result = tower.isPossibleMovement(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPossibleMovement_InvalidMovement_ReturnsFalse() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(3, 3, "T1W"); // Posición de inicio válida (misma posición de la torre)
        Tile nextPosition = new Tile(7, 5, "T1W"); // Posición de destino inválida (movimiento diagonal)

        board.setNewPositionsInGame("T1W",startPosition);

        boolean result = tower.isPossibleMovement(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }
}
