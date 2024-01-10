package ar.edu.utn.frc.tup.lciii.Pieces;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Tile;

import java.lang.reflect.Type;
import java.util.List;

public class Bishop extends Tile {

    public Bishop(int tileX, int tileY) {

        super(tileX, tileY);

    }

    public Bishop(int tileX, int tileY, String name, TypeParts typeParts) {

        super(tileX, tileY,name,typeParts);

    }



    @Override
    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {

        return verifyIsDifferentTeam(startPosition, nextPosition, board) ? false : isPossibleMovement(board, startPosition, nextPosition);
    }

    public boolean isPossibleMovement(Board board, Tile startPosition, Tile nextPosition) {

        List<Tile> obstaclesInDiagonal = getMovementsInDiagonal(board, startPosition);
        for (Tile tileDiagonal : obstaclesInDiagonal) {
            if (nextPosition.getTileX() == tileDiagonal.getTileX() && nextPosition.getTileY() == tileDiagonal.getTileY())
                return true;
        }

        return false;
    }

    public List<Tile> getPossibleMovements(Tile startPosition, Board board) {

        List<Tile> movements = getMovementsInDiagonal(board, startPosition);

        return movements;

    }

}
