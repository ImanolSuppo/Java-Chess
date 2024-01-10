package ar.edu.utn.frc.tup.lciii.Pieces;

import ar.edu.utn.frc.tup.lciii.Board;
import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Tile;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Tile {

    public Pawn(int tileX, int tileY, String name) {

        super(tileX, tileY, name);
    }

    public Pawn(int tileX, int tileY, String name, TypeParts typeParts) {

        super(tileX, tileY, name,typeParts);
    }


    @Override
    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {

        return verifyIsDifferentTeam(startPosition, nextPosition, board) ? false : isPossibleMovement(board, startPosition, nextPosition);
    }

    private boolean isPossibleMovement(Board board, Tile startPosition, Tile nextPosition) {

        if (startPosition.getName().substring(2, 3).equals("W")) {

            return isPossibleMoveUp(board, startPosition, nextPosition) || isPossibleMoveDiagonalUpperLeft(board, startPosition, nextPosition) || isPossibleMoveDiagonalUpperRight(board, startPosition, nextPosition);

        } else if (startPosition.getName().substring(2, 3).equals("B")) {

            return isPossibleMoveDown(board, startPosition, nextPosition) || isPossibleMoveDiagonalDownLeft(board, startPosition, nextPosition) || isPossibleMoveDiagonalDownRight(board, startPosition, nextPosition);
        }

        return false;
    }

    private boolean isPossibleMoveUp(Board board, Tile startPosition, Tile nextPosition) {

        boolean flag = true;

        int axisY = nextPosition.getTileY() - startPosition.getTileY();
        int axisX = nextPosition.getTileX() - startPosition.getTileX();

        if (axisY < 1 || axisY > 2 || axisX != 0) {

            return false;
        }

        if (!verifyFirstMovement(startPosition, startPosition.getName()) && axisY != 1) {

            return false;
        } else {

            for (int j = 1; j <= axisY; j++) {

                Tile tile = new Tile(startPosition.getTileX(), startPosition.getTileY() + j);
                tile = board.getTileInBoard(tile);

                if (!board.isInsideBoard(tile) || !tile.getName().equals("└-┘")) {

                    flag = false;
                    break;
                }
            }
        }

        return flag;

    }

    private boolean isPossibleMoveDiagonalUpperLeft(Board board, Tile startPosition, Tile nextPosition) {

        int axisX = startPosition.getTileX() - nextPosition.getTileX();
        int axisY = startPosition.getTileY() + nextPosition.getTileY();

        if (axisX != 1 || axisY != 1) {
            return false;
        }

        Tile tileDiagonal = new Tile(startPosition.getTileX() - 1, startPosition.getTileY() + 1);
        tileDiagonal = board.getTileInBoard(tileDiagonal);

        if (!board.isInsideBoard(tileDiagonal) || !tileDiagonal.getName().substring(2, 3).equals("B")) {
            return false;
        }

        return true;
    }

    private boolean isPossibleMoveDiagonalUpperRight(Board board, Tile startPosition, Tile nextPosition) {

        Tile tileDiagonal = new Tile(startPosition.getTileX() + 1, startPosition.getTileY() + 1);
        tileDiagonal = board.getTileInBoard(tileDiagonal);

        int axisX = nextPosition.getTileX() - startPosition.getTileX();
        int axisY = nextPosition.getTileY() - startPosition.getTileY();

        if (axisX != 1 || axisY != 1) {
            return false;
        }

        if (!board.isInsideBoard(tileDiagonal) || !tileDiagonal.getName().substring(2, 3).equals("B")) {
            return false;
        }

        return true;
    }

    private boolean isPossibleMoveDown(Board board, Tile startPosition, Tile nextPosition) {

        boolean flag = true;

        int axisX = startPosition.getTileX() - nextPosition.getTileX();
        int axisY = startPosition.getTileY() - nextPosition.getTileY();

        if (axisY < 1 || axisY > 2 || axisX != 0) {

            return false;
        }

        if (!verifyFirstMovement(startPosition, startPosition.getName()) && axisY != 1) {

            return false;
        } else {

            for (int j = 1; j <= axisY; j++) {

                Tile tile = new Tile(startPosition.getTileX(), startPosition.getTileY() - j);

                tile = board.getTileInBoard(tile);

                if (!board.isInsideBoard(tile) || !tile.getName().equals("└-┘")) {

                    flag = false;
                    break;
                }
            }
        }
        return flag;

    }


    private boolean isPossibleMoveDiagonalDownLeft(Board board, Tile startPosition, Tile nextPosition) {

        int axisX = startPosition.getTileX() - nextPosition.getTileX();
        int axisY = startPosition.getTileY() - nextPosition.getTileY();

        if (axisX != 1 || axisY != 1) {
            return false;
        }

        Tile tileDiagonal = new Tile(startPosition.getTileX() - 1, startPosition.getTileY() - 1);
        tileDiagonal = board.getTileInBoard(tileDiagonal);

        if (!board.isInsideBoard(tileDiagonal) || !tileDiagonal.getName().substring(2, 3).equals("W")) {
            return false;
        }

        return true;
    }

    private boolean isPossibleMoveDiagonalDownRight(Board board, Tile startPosition, Tile nextPosition) {

        int axisX = nextPosition.getTileX() - startPosition.getTileX();
        int axisY = startPosition.getTileY() - nextPosition.getTileY();

        if (axisX != 1 || axisY != 1) {
            return false;
        }

        Tile tileDiagonal = new Tile(startPosition.getTileX() + 1, startPosition.getTileY() - 1);
        tileDiagonal = board.getTileInBoard(tileDiagonal);

        if (!board.isInsideBoard(tileDiagonal) || !tileDiagonal.getName().substring(2, 3).equals("W")) {
            return false;
        }

        return true;
    }

    private boolean verifyFirstMovement(Tile pawn, String namePart) {

        List<Tile> pawnsStartPositions = new ArrayList<>();

        int axisY = 2;

        if (namePart.substring(2, 3).equals("B")) {
            axisY = 7;
        }

        for (int i = 1; i <= 8; i++) {

            pawnsStartPositions.add(new Tile(i, axisY));
        }

        return pawnsStartPositions.stream().anyMatch(x -> x.getTileX() == pawn.getTileX() && x.getTileY() == pawn.getTileY());

    }

    public List<Tile> getPossibleMovements(Tile startPosition, Board board) {
        List<Tile> movements = new ArrayList<>();
        int indice = verifyFirstMovement(startPosition, startPosition.getName()) ? 2 : 1;
        if(startPosition.getName().substring(2,3).equals("W")){
            for (int i = 1; i <= indice; i++) {
                Tile nextPosition = board.getTileInBoard(new Tile(startPosition.getTileX(), startPosition.getTileY() + i));
                if(isPossibleMoveUp(board, startPosition, nextPosition)){
                    movements.add(nextPosition);
                }
            }

        } else{
            for (int i = 1; i <= indice; i++) {
                Tile nextPosition = board.getTileInBoard(new Tile(startPosition.getTileX(), startPosition.getTileY() - i));
                if(isPossibleMoveDown(board, startPosition, nextPosition)){
                    movements.add(nextPosition);
                }
            }
        }
        return movements;

    }




}
