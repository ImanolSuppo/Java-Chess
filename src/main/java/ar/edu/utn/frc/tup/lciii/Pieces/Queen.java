package ar.edu.utn.frc.tup.lciii.Pieces;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Tile;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Tile{

    public Queen(int tileX, int tileY) {

        super(tileX, tileY);

    }

    public Queen(int tileX, int tileY, String name, TypeParts typeParts) {

        super(tileX, tileY,name,typeParts);

    }

    @Override
    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {

        return verifyIsDifferentTeam(startPosition, nextPosition, board) ? false : isPossibleMovement(board, startPosition, nextPosition);
    }

    private boolean isPossibleMovement(Board board, Tile startPosition, Tile nextPosition) {
        List<Tile> obstaclesDiagonal = getMovementsInDiagonal(board, startPosition);
        List<Tile> obstaclesInAxis = getMovementsInAxis(board, startPosition);

        for (Tile obstacle : obstaclesInAxis) {
            if (nextPosition.getTileX() == obstacle.getTileX() && nextPosition.getTileY() == obstacle.getTileY())
                return true;
        }
        for (Tile obstacle : obstaclesDiagonal) {
            if (nextPosition.getTileX() == obstacle.getTileX() && nextPosition.getTileY() == obstacle.getTileY())
                return true;
        }
        return false;
    }

    public List<Tile> getPossibleMovements(Tile startPosition, Board board) {

        List<Tile> moveInDiagonal = getMovementsInDiagonal(board, startPosition);
        List<Tile> moveInAxis = getMovementsInAxis(board, startPosition);

        moveInDiagonal.addAll(moveInAxis);

        return moveInDiagonal;

    }

}
