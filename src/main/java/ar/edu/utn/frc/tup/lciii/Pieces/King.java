package ar.edu.utn.frc.tup.lciii.Pieces;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Tile;

import java.util.ArrayList;
import java.util.List;

public class King extends Tile {

    public King(int tileX, int tileY) {
        super(tileX, tileY);
    }

    private int movementsUpp = 8 - this.getTileY();
    private int movementsDown = this.getTileY() - 1;
    private int movementsLeft = this.getTileX() - 1;
    private int movementsRight = 8 - this.getTileX();

    @Override
    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {

        return verifyIsDifferentTeam(startPosition, nextPosition, board) ? false : isPossibleMovement(board, startPosition, nextPosition);
    }

    private boolean isPossibleMovement(Board board, Tile startPosition, Tile nextPosition) {

        return isPossibleMove(startPosition, nextPosition, board);
    }

    private boolean isPossibleMove(Tile startPosition, Tile nextPosition, Board board) {

        List<Tile> movements = getPossibleMovements(board, startPosition);

        for (int i = 0; i < movements.size(); i++) {

            if (movements.get(i).getTileX() == nextPosition.getTileX() && movements.get(i).getTileY() == nextPosition.getTileY() && !startPosition.getName().substring(2, 3).equals(nextPosition.getName().substring(2, 3))) {

                return true;

            }

        }


        return false;

    }


    public List<Tile> getPossibleMovements(Board board, Tile startPosition) {

        List<Tile> movements = new ArrayList<>();
        List<Tile> reallyMovements = new ArrayList<>();

        movements.add(new Tile(startPosition.getTileX(), startPosition.getTileY() + 1));
        movements.add(new Tile(startPosition.getTileX(), startPosition.getTileY() - 1));
        movements.add(new Tile(startPosition.getTileX() - 1, startPosition.getTileY()));
        movements.add(new Tile(startPosition.getTileX() + 1, startPosition.getTileY()));
        movements.add(new Tile(startPosition.getTileX() - 1, startPosition.getTileY() + 1));
        movements.add(new Tile(startPosition.getTileX() + 1, startPosition.getTileY() + 1));
        movements.add(new Tile(startPosition.getTileX() - 1, startPosition.getTileY() - 1));
        movements.add(new Tile(startPosition.getTileX() + 1, startPosition.getTileY() - 1));

        for (int i = 0; i < movements.size(); i++) {

            if (board.isInsideBoard(movements.get(i))) {

                movements.set(i, board.getTileInBoard(movements.get(i)));
                
                if (!startPosition.getName().substring(2, 3).equals(movements.get(i).getName().substring(2, 3))) {
                    reallyMovements.add(movements.get(i));
                }
            }


        }

        return reallyMovements;
    }

}
