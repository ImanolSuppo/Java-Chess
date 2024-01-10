package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.TypeParts;
import ar.edu.utn.frc.tup.lciii.Pieces.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Board extends Tile {

    private final int nwTileX = 1;
    private final int nwTileY = 1;

    @Getter
    private final int seTileX = 8;
    @Getter
    private final int seTileY = 8;
    private final String emptyPosition = "└-┘";
    private final List<Tile> tiles;
    private String board_list;

    public Board() {

        tiles = new ArrayList<>();
        generateBoard();
    }

    public Board(String board_list) {
        tiles = new ArrayList<>();
        this.board_list = board_list;
    }

    public List<Tile> getBoard() {
        return tiles;
    }

    public boolean isInsideBoard(Tile tile) {

        return this.nwTileX <= tile.getTileX() && tile.getTileX() <= this.seTileX &&
                this.nwTileY <= tile.getTileY() && tile.getTileY() <= this.seTileY;
    }

    private void generateBoard() {

        int countHorizontal = this.seTileX - this.nwTileX;
        int countVertical = this.seTileY - this.nwTileY;

        for (int axisY = 0; axisY <= countHorizontal; axisY++) {

            for (int axisX = 0; axisX <= countVertical; axisX++) {
                tiles.add(new Tile(this.nwTileX + axisX, this.nwTileY + axisY, "", TypeParts.NULL));

            }

        }

    }


    public void printStartBoard() {

        setPartsInBoard();

        System.out.println("    a - b - c - d - e - f - g - h");

        String[] rows = new String[seTileX];
        int count = 0;

        for (int i = seTileX; i >= 1; i--) {


            for (int j = (seTileX * i - 1); j >= seTileX * i - 8; j--) {

                rows[count] = tiles.get(j).getName();

                count++;

                if (j == seTileX * i - 8) {

                    String[] reversedRows = new String[rows.length];

                    for (int k = 0; k < rows.length; k++) {

                        reversedRows[k] = rows[rows.length - k - 1];
                    }

                    System.out.println(i + "  " + Arrays.toString(reversedRows).replaceAll("[\\[\\]\\,]", "") + "  " + i);

                    count = 0;
                }
            }
        }


        System.out.println("    a - b - c - d - e - f - g - h");

    }


    public void setPartsInBoard() {

        tiles.get(0).setName("T1W");
        tiles.get(0).setTypePart(TypeParts.TOWER);
        tiles.get(1).setName("H1W");
        tiles.get(1).setTypePart(TypeParts.HORSE);
        tiles.get(2).setName("B1W");
        tiles.get(2).setTypePart(TypeParts.BISHOP);
        tiles.get(3).setName("QNW");
        tiles.get(3).setTypePart(TypeParts.QUEEN);
        tiles.get(4).setName("KIW");
        tiles.get(4).setTypePart(TypeParts.KING);
        tiles.get(5).setName("B2W");
        tiles.get(5).setTypePart(TypeParts.BISHOP);
        tiles.get(6).setName("H2W");
        tiles.get(6).setTypePart(TypeParts.HORSE);
        tiles.get(7).setName("T2W");
        tiles.get(7).setTypePart(TypeParts.TOWER);
        tiles.get(8).setName("P1W");
        tiles.get(9).setName("P2W");
        tiles.get(10).setName("P3W");
        tiles.get(11).setName("P4W");
        tiles.get(12).setName("P5W");
        tiles.get(13).setName("P6W");
        tiles.get(14).setName("P7W");
        tiles.get(15).setName("P8W");

        for (int i = 8; i < 16; i++) {

            tiles.get(i).setTypePart(TypeParts.PAWN);
        }

        tiles.get(63).setName("T2B");
        tiles.get(63).setTypePart(TypeParts.TOWER);
        tiles.get(62).setName("H2B");
        tiles.get(62).setTypePart(TypeParts.HORSE);
        tiles.get(61).setName("B2B");
        tiles.get(61).setTypePart(TypeParts.BISHOP);
        tiles.get(60).setName("KIB");
        tiles.get(60).setTypePart(TypeParts.KING);
        tiles.get(59).setName("QNB");
        tiles.get(59).setTypePart(TypeParts.QUEEN);
        tiles.get(58).setName("B1B");
        tiles.get(58).setTypePart(TypeParts.BISHOP);
        tiles.get(57).setName("H1B");
        tiles.get(57).setTypePart(TypeParts.HORSE);
        tiles.get(56).setName("T1B");
        tiles.get(56).setTypePart(TypeParts.TOWER);
        tiles.get(55).setName("P8B");
        tiles.get(54).setName("P7B");
        tiles.get(53).setName("P6B");
        tiles.get(52).setName("P5B");
        tiles.get(51).setName("P4B");
        tiles.get(50).setName("P3B");
        tiles.get(49).setName("P2B");
        tiles.get(48).setName("P1B");

        for (int i = 48; i < 56; i++) {

            tiles.get(i).setTypePart(TypeParts.PAWN);
        }

        for (int i = seTileX * 2; i < tiles.size() - seTileX * 2; i++) {

            tiles.get(i).setName(emptyPosition);

        }


    }


    public void setNewPositionsInGame(String namePart, Tile nextPosition) {

        TypeParts typePart = TypeParts.NULL;

        for (int i = 0; i < tiles.size(); i++) {

            if (tiles.get(i).getName().equals(namePart)) {
                typePart = tiles.get(i).getTypePart();
                break;
            }
        }


        for (int i = 0; i < tiles.size(); i++) {

            if (tiles.get(i).getName().equals(namePart)) {
                tiles.get(i).setName(emptyPosition);
                tiles.get(i).setTypePart(TypeParts.NULL);
            } else if (tiles.get(i).getTileX() == nextPosition.getTileX() && tiles.get(i).getTileY() == nextPosition.getTileY()) {
                tiles.get(i).setName(namePart);
                tiles.get(i).setTypePart(typePart);
            }
        }

    }

    public void printBoardGameSession() {


        System.out.println("    a - b - c - d - e - f - g - h");

        String[] rows = new String[seTileX];
        int count = 0;

        for (int i = seTileX; i >= 1; i--) {


            for (int j = (seTileX * i - 1); j >= seTileX * i - 8; j--) {

                rows[count] = tiles.get(j).getName();

                count++;

                if (j == seTileX * i - 8) {

                    String[] reversedRows = new String[rows.length];

                    for (int k = 0; k < rows.length; k++) {

                        reversedRows[k] = rows[rows.length - k - 1];
                    }

                    System.out.println(i + "  " + Arrays.toString(reversedRows).replaceAll("[\\[\\]\\,]", "") + "  " + i);

                    count = 0;
                }
            }
        }

        System.out.println("    a - b - c - d - e - f - g - h");


    }

    public Tile getKingPosition(String kingColor) {
        String king = kingColor.equals("white") ? "KIW" : "KIB";
        for (Tile tile : tiles) {
            if (tile.getName().equals(king)) {
                return tile;
            }
        }
        return null;
    }

    public List<Tile> getBlackPieces() {
        List<Tile> blackPieces = new ArrayList<>();
        Iterator<Tile> it = tiles.iterator();
        while (it.hasNext()) {
            Tile current = it.next();
            if (current.getName().charAt(current.getName().length() - 1) == 'B') {
                blackPieces.add(current);
            }
        }
        return blackPieces;
    }

    public List<Tile> getWhitePieces() {
        List<Tile> whitePieces = new ArrayList<>();
        Iterator<Tile> it = tiles.iterator();
        while (it.hasNext()) {
            Tile current = it.next();
            if (current.getName().charAt(current.getName().length() - 1) == 'W') {
                whitePieces.add(current);
            }
        }
        return whitePieces;
    }

    public Tile getTileInBoard(Tile tile) {

        Tile tileToReturn = null;

        List<Tile> innerBoard = tiles;

        for (int i = 0; i < innerBoard.size(); i++) {

            if (innerBoard.get(i).getTileX() == tile.getTileX() && innerBoard.get(i).getTileY() == tile.getTileY()) {

                tileToReturn = new Tile(innerBoard.get(i).getTileX(), innerBoard.get(i).getTileY(), innerBoard.get(i).getName(), innerBoard.get(i).getTypePart());
            }

        }

        return tileToReturn;

    }


}





