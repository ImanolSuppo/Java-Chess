package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;

import java.util.ArrayList;
import java.util.List;

public class Tile {
    private int tileX;
    private int tileY;
    private String name;
    private TypeParts typePart;

    public Tile(int tileX, int tileY, String name, TypeParts typePart) {

        this.tileX = tileX;
        this.tileY = tileY;
        this.name = name;
        this.typePart = typePart;
    }

    public Tile(int tileX, int tileY, String name) {

        this.tileX = tileX;
        this.tileY = tileY;
        this.name = name;

    }

    public Tile() {

    }


    public Tile(int tileX, int tileY) {

        this.tileX = tileX;
        this.tileY = tileY;

    }

    public int getTileX() {
        return tileX;
    }

    public void setTileX(int tileX) {
        this.tileX = tileX;
    }

    public int getTileY() {
        return tileY;
    }

    public void setTileY(int tileY) {
        this.tileY = tileY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeParts getTypePart() {
        return typePart;
    }

    public void setTypePart(TypeParts typePart) {
        this.typePart = typePart;
    }

    public boolean movePart(Board board, Tile startPosition, Tile nextPosition) {
        return false;
    }

    protected List<Tile> getMovementsInAxis(Board board, Tile startPosition) {

        List<Tile> tilesFound = new ArrayList<>();

        int row = startPosition.getTileX();
        int col = startPosition.getTileY();

        String friendColor = startPosition.getName().substring(2, 3);
        String enemyColor = startPosition.getName().substring(2, 3).equals("W") ? "B" : "W";


        for (int i = col + 1; i <= 8; i++) {
            Tile tile = new Tile(row, i);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }

        }

        for (int i = col - 1; i >= 1; i--) {
            Tile tile = new Tile(row, i);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }

        }

        for (int i = row + 1; i <= 8; i++) {
            Tile tile = new Tile(i, col);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }

        }

        for (int i = row - 1; i >= 1; i--) {
            Tile tile = new Tile(i, col);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }

        }

        return tilesFound;

    }


    protected List<Tile> getMovementsInDiagonal(Board board, Tile startPosition) {

        List<Tile> innerBoard = board.getBoard();

        List<Tile> tilesFound = new ArrayList<>();
        int row = startPosition.getTileX();
        int col = startPosition.getTileY();
        String friendColor = startPosition.getName().substring(2, 3);
        String enemyColor = startPosition.getName().substring(2, 3).equals("W") ? "B" : "W";


        for (int i = row + 1, j = col + 1; i <= 8 && j <= 8; i++, j++) {
            Tile tile = new Tile(i, j);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 1 && j <= 8; i--, j++) {
            Tile tile = new Tile(i, j);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }
        }


        for (int i = row + 1, j = col - 1; i <= 8 && j >= 1; i++, j--) {
            Tile tile = new Tile(i, j);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }
        }


        for (int i = row - 1, j = col - 1; i >= 1 && j >= 1; i--, j--) {
            Tile tile = new Tile(i, j);
            tile = board.getTileInBoard(tile);
            if (board.isInsideBoard(tile) && tile.getName().substring(2, 3).equals(enemyColor)) {
                tilesFound.add(tile);
                break;
            } else if (board.isInsideBoard(tile) && !tile.getName().substring(2, 3).equals(friendColor)) {
                tilesFound.add(tile);
            } else {
                break;
            }
        }

        return tilesFound;

    }


    protected boolean verifyIsDifferentTeam(Tile startPosition, Tile nextPosition, Board board) {

        startPosition = board.getTileInBoard(startPosition);
        nextPosition = board.getTileInBoard(nextPosition);

        return startPosition.getName().substring(2, 3).equals(nextPosition.getName().substring(2, 3));

    }


}
