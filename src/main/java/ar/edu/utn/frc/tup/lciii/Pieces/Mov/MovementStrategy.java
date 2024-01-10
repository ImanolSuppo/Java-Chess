package ar.edu.utn.frc.tup.lciii.Pieces.Mov;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Tile;

public interface MovementStrategy {

    boolean movePart(Board board, Tile startPosition, Tile nextPosition);

}
