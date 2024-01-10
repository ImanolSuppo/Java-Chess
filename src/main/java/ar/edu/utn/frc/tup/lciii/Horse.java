package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Horse extends Tile {

    public Horse(int tileX, int tileY) {

        super(tileX, tileY);

    }

    public Horse(int tileX, int tileY, String name, TypeParts typeParts) {

        super(tileX, tileY,name,typeParts);

    }

    @Override
    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {

        return verifyIsDifferentTeam(startPosition, nextPosition, board) ? false : isPossibleMovement(board, startPosition, nextPosition);
    }

    public boolean isPossibleMovement(Board board, Tile positionStart, Tile nextPosition) {

        Tile[] possibleMovements = new Tile[8];
        possibleMovements[0] = new Tile(positionStart.getTileX() - 1, positionStart.getTileY() + 2);
        possibleMovements[1] = new Tile(positionStart.getTileX() + 1, positionStart.getTileY() + 2);
        possibleMovements[2] = new Tile(positionStart.getTileX() - 1, positionStart.getTileY() - 2);
        possibleMovements[3] = new Tile(positionStart.getTileX() + 1, positionStart.getTileY() - 2);
        possibleMovements[4] = new Tile(positionStart.getTileX() - 2, positionStart.getTileY() + 1);
        possibleMovements[5] = new Tile(positionStart.getTileX() - 2, positionStart.getTileY() - 1);
        possibleMovements[6] = new Tile(positionStart.getTileX() + 2, positionStart.getTileY() + 1);
        possibleMovements[7] = new Tile(positionStart.getTileX() + 2, positionStart.getTileY() - 1);


        return movementsHorse(positionStart, nextPosition, possibleMovements, board) >= 0 ? true : false;

    }

    private int movementsHorse(Tile startPosition, Tile nextPosition, Tile[] possibleMovements, Board board) {

        int indexToMovement = -1;
        String friendColor = startPosition.getName().substring(2,3);

        if (!board.isInsideBoard(nextPosition)) {

            return indexToMovement;
        }
        for (int i = 0; i < possibleMovements.length; i++) {
            if (board.isInsideBoard(possibleMovements[i])){
                Tile tile = board.getTileInBoard(possibleMovements[i]);
                if (nextPosition.getTileX() == tile.getTileX() && nextPosition.getTileY() == tile.getTileY() && !tile.getName().substring(2,3).equals(friendColor)) {

                    indexToMovement = i;
                    break;
                }
            }
        }

        return indexToMovement;
    }

    public List<Tile> getPossibleMovements(Tile startPosition, Board board) {
        List<Tile> movements = new ArrayList<>();

        movements.add(new Tile(startPosition.getTileX() - 1, startPosition.getTileY() + 2));
        movements.add(new Tile(startPosition.getTileX() + 1, startPosition.getTileY() + 2));
        movements.add(new Tile(startPosition.getTileX() - 1, startPosition.getTileY() - 2));
        movements.add(new Tile(startPosition.getTileX() + 1, startPosition.getTileY() - 2));
        movements.add(new Tile(startPosition.getTileX() - 2, startPosition.getTileY() + 1));
        movements.add(new Tile(startPosition.getTileX() - 2, startPosition.getTileY() - 1));
        movements.add(new Tile(startPosition.getTileX() + 2, startPosition.getTileY() + 1));
        movements.add(new Tile(startPosition.getTileX() + 2, startPosition.getTileY() - 1));

        List<Tile> filteredMovements = new ArrayList<>();

        Iterator<Tile> iterator = movements.iterator();
        while (iterator.hasNext()) {
            Tile movement = iterator.next();
            if (board.isInsideBoard(movement)) {
                Tile tile = board.getTileInBoard(movement);
                if (!tile.getName().substring(2, 3).equals(startPosition.getName().substring(2, 3))) {
                    filteredMovements.add(tile);
                }
            }
        }

        return filteredMovements;
    }



}

