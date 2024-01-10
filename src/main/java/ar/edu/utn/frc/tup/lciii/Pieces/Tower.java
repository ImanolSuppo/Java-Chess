package ar.edu.utn.frc.tup.lciii.Pieces;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tower extends Tile {

    public Tower(int tileX, int tileY) {

        super(tileX, tileY);
    }

    public Tower(int tileX, int tileY, String name, TypeParts typeParts) {

        super(tileX, tileY,name,typeParts);
    }


    @Override
    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {

        return verifyIsDifferentTeam(startPosition, nextPosition, board) ? false : isPossibleMovement(board, startPosition, nextPosition);
    }

    public boolean isPossibleMovement(Board board, Tile startPosition, Tile nextPosition) {

        List<Tile> obstaclesTower = getMovementsInAxis(board, startPosition);

        for (Tile obstacle : obstaclesTower) {
            if (nextPosition.getTileX() == obstacle.getTileX() && nextPosition.getTileY() == obstacle.getTileY())
                return true;
        }

        return false;
    }

    public List<Tile> getPossibleMovements(Tile startPosition, Board board) {

        List<Tile> movements = getMovementsInAxis(board, startPosition);

        return movements;

    }
}
