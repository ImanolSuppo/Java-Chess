package ar.edu.utn.frc.tup.lciii.Parts;
import static org.junit.jupiter.api.Assertions.*;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Game;
import ar.edu.utn.frc.tup.lciii.Pieces.Bishop;
import ar.edu.utn.frc.tup.lciii.Pieces.Queen;
import ar.edu.utn.frc.tup.lciii.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.support.ReflectionSupport;

public class BishopTest {
    private Board board;
    private Bishop bishop;

    @BeforeEach
    public void setup() {
        // Configurar el tablero y el obispo para cada prueba
        board = new Board();
        bishop = new Bishop(4, 4);
    }

    @Test
    public void testMovePart_ValidMove_ReturnsTrue() {
        board.setPartsInBoard();

        Tile startPosition = new Tile(4, 4, "B2B"); // Posición de inicio válida
        Tile nextPosition = new Tile(6, 6, "B2B"); // Posición de destino válida
        board.setNewPositionsInGame("B2B",startPosition);

        boolean result = bishop.movePart(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testMovePart_InvalidMove_ReturnsFalse() {
        board.setPartsInBoard();

        Tile startPosition = new Tile(4, 4, "B2B"); // Posición de inicio válida
        Tile nextPosition = new Tile(4, 5, "B2B"); // Posición de destino inválida
        board.setNewPositionsInGame("B2B",startPosition);

        boolean result = bishop.movePart(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }

    @Test
    public void testIsPossibleMovement_ValidMovement_ReturnsTrue() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "B2B"); // Posición de inicio válida
        Tile nextPosition = new Tile(6, 6, "B2B"); // Posición de destino válida
        board.setNewPositionsInGame("B2B",startPosition);

        boolean result = bishop.isPossibleMovement(board, startPosition, nextPosition);

        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPossibleMovement_InvalidMovement_ReturnsFalse() {
        board.setPartsInBoard();
        Tile startPosition = new Tile(4, 4, "B2B"); // Posición de inicio válida
        Tile nextPosition = new Tile(5, 6, "B2B"); // Posición de destino inválida
        board.setNewPositionsInGame("B2B",startPosition);

        boolean result = bishop.isPossibleMovement(board, startPosition, nextPosition);

        Assertions.assertFalse(result);
    }


}
