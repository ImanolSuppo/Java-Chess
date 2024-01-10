package ar.edu.utn.frc.tup.lciii.Parts;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Horse;
import ar.edu.utn.frc.tup.lciii.Pieces.Bishop;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorseTest {
    private Board board;
    private Horse horse;

    @BeforeEach
    public void setup() {
        board = new Board();
        horse = new Horse(4, 4);
    }
    @Test
    public void testMovePart_ValidMove_ReturnsTrue() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "B1B"); // Posición de inicio válida
        Tile nextPosition = new Tile(3, 6, "B1B"); // Posición de destino válida
        board.setNewPositionsInGame("B1B",startPosition);

        boolean result = horse.movePart(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testMovePart_InvalidMove_ReturnsFalse() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "B1B"); // Posición de inicio válida
        Tile nextPosition = new Tile(2, 6 , "B1B"); // Posición de destino inválida
        board.setNewPositionsInGame("B1B",startPosition);

        boolean result = horse.movePart(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }

    @Test
    public void testIsPossibleMovement_ValidMovement_ReturnsTrue() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "B1B"); // Posición de inicio válida
        Tile nextPosition = new Tile(3, 6, "B1B"); // Posición de destino válida
        board.setNewPositionsInGame("B1B",startPosition);

        boolean result = horse.isPossibleMovement(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPossibleMovement_InvalidMovement_ReturnsFalse() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "B1B"); // Posición de inicio válida
        Tile nextPosition = new Tile(1 ,4, "B1B"); // Posición de destino inválida
        board.setNewPositionsInGame("B1B",startPosition);

        boolean result = horse.isPossibleMovement(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }

}
