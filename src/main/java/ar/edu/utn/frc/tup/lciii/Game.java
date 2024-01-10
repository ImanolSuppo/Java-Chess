package ar.edu.utn.frc.tup.lciii;

import ar.edu.utn.frc.tup.lciii.Enums.AxisX;
import ar.edu.utn.frc.tup.lciii.Pieces.*;
import ar.edu.utn.frc.tup.lciii.Validations.Validation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class Game {

    private Player playerOne;
    private Player playerTwo;
    private Board board;
    private Messages messages;
    private List<String> historicalMovements;
    private Validation validate;

    public Game(Player playerOne, Player playerTwo, Board board, List<String> historicalMovements) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
        this.historicalMovements = historicalMovements;
        messages = new Messages();
        validate = new Validation();
    }

    public Game(Player playerOne, Player playerTwo) {

        this.board = new Board();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        messages = new Messages();
        historicalMovements = new ArrayList<>();
        validate = new Validation();

    }

    public Game() {

    }


    public int getIndexPartNameInBoard(String namePart) {

        int index = -1;

        List<Tile> innerBoard = board.getBoard();

        for (int i = 0; i < innerBoard.size(); i++) {

            if (innerBoard.get(i).getName().equals(namePart)) {

                index = i;
                break;
            }

        }

        return index;

    }

    public boolean moveParts(String namePart, Tile nextPosition, Player player) {

        if (!board.isInsideBoard(nextPosition)) {

            return false;

        } else {

            Tile part = board.getBoard().get(getIndexPartNameInBoard(namePart.toUpperCase()));
            nextPosition = board.getTileInBoard(nextPosition);
            String kingColor = part.getName().substring(2,3).equals("W") ? "white" : "black";

            switch (part.getTypePart()) {
                case TOWER:
                    Tower tower = new Tower(part.getTileX(), part.getTileY());
                    return verifyExposeKing(tower, part, nextPosition, board, kingColor);
                case HORSE:
                    ar.edu.utn.frc.tup.lciii.Horse horse = new ar.edu.utn.frc.tup.lciii.Horse(part.getTileX(), part.getTileY());
                    return verifyExposeKing(horse, part, nextPosition, board, kingColor);
                case BISHOP:
                    Bishop bishop = new Bishop(part.getTileX(), part.getTileY());
                    return verifyExposeKing(bishop, part, nextPosition, board, kingColor);
                case QUEEN:
                    Queen queen = new Queen(part.getTileX(), part.getTileY());
                    return verifyExposeKing(queen, part, nextPosition, board, kingColor);
                case KING:
                    King king = new King(part.getTileX(), part.getTileY());
                    return verifyExposeKing(king, part, nextPosition, board, kingColor);
                case PAWN:
                    Pawn pawn = new Pawn(part.getTileX(), part.getTileY(), part.getName());
                    return verifyExposeKing(pawn, part, nextPosition, board, kingColor);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }

        }

        return true;
    }

    private boolean verifyExposeKing(Tile tile, Tile part, Tile nextPosition, Board board, String kingColor){
        if(tile.movePart(board, part, nextPosition)){
            if(simulationFakeMoveParte(part, nextPosition, board, board.getKingPosition(kingColor))){
                return true;
            }
        }
        return false;
    }

    private boolean verifyNameExist(String namePart) {

        List<Tile> innerBoard = board.getBoard();

        return innerBoard.stream().anyMatch(x -> x.getName().equals(namePart));
    }

    public String validateColorPartIsCorrectly(Player player, String namePart, Scanner scan) {

        String playerTeam = player.getTeamColor().toString().toUpperCase();

        playerTeam = playerTeam.substring(0, 1);

        while (!playerTeam.equals(namePart.substring(2, 3).toUpperCase())) {

            messages.alertMessageColorTeamIsBad(player);
            namePart = scan.nextLine();
            namePart = keepRunningNamePartIsBad(namePart, player, scan);

            if (playerTeam.equals(namePart.substring(2, 3).toUpperCase())) {
                break;
            }

        }

        return namePart;
    }


    public void keepRunningIsMoveIsNotPossible(boolean move, String namePart, Scanner scan, Player player) {

        Tile nextPosition = null;
        String coordinates = null;

        while (!move) {

            messages.alertMessageMoveIsNotPossible();
            System.out.println(messages.getExample());
            board.printBoardGameSession();
            messages.enterNameMovePart(player);
            namePart = scan.nextLine().toUpperCase();
            namePart = keepRunningNamePartIsBad(namePart, player, scan);
            namePart = validateColorPartIsCorrectly(player, namePart, scan);
            messages.inputAlgebraicNotation(player.getName());
            coordinates = scan.nextLine().toLowerCase();

            if (!validate.validateAlgebraicNotation(coordinates)) {

                coordinates = validate.keepRunningAlgebraicNotation(scan, false);

            }

            nextPosition = letterToTile(coordinates.toLowerCase());

            if (namePart.substring(2, 3).equals("W")) {

                move = moveParts(namePart, nextPosition, playerOne);
            } else {
                move = moveParts(namePart, nextPosition, playerTwo);
            }


        }

        board.setNewPositionsInGame(namePart, nextPosition);


    }

    public void addHistoricalMovements(Tile nextPosition, String namePart) {

        this.historicalMovements.add(namePart + " ; " + axisXToLetter(nextPosition.getTileX()) + nextPosition.getTileY());
    }

    public Tile letterToTile(String coordinates) {

        return new Tile(letterToAxisX(coordinates.substring(0, 1)), Integer.parseInt(coordinates.substring(1, 2)));

    }

    public int letterToAxisX(String letter) {
        AxisX axisX = AxisX.fromLetter(letter);
        return axisX.getValue();
    }

    public String axisXToLetter(int axisX) {
        AxisX axisXEnum = AxisX.fromValue(axisX);
        return axisXEnum.name().toLowerCase();
    }


    public String keepRunningNamePartIsBad(String namePart, Player player, Scanner scan) {

        String innerNamePart = namePart;

        while (!verifyNameExist(innerNamePart)) {

            messages.validateNamePart(player);
            board.printBoardGameSession();
            innerNamePart = scan.nextLine().toUpperCase();

        }

        return innerNamePart;
    }


    public boolean hackeDetection(String kingColor) {
        Tile kingPosition = board.getKingPosition(kingColor);
        List<Tile> opponentPieces = (kingPosition.getName().equals("KIW")) ? board.getBlackPieces() : board.getWhitePieces();
        return isKingInCheck(kingPosition, opponentPieces, board);
    }


    public boolean hackeMateDetection(String kingColor) {

        Tile kingPosition = board.getKingPosition(kingColor);

        List<Tile> opponentPieces = (kingPosition.getName().equals("KIW")) ? board.getBlackPieces() : board.getWhitePieces();

        if (!isKingInCheck(kingPosition, opponentPieces, board) || canKingEscapeCheck(kingColor, board)
            || canAnyPieceCaptureThreat(kingPosition, board) || verifyAnyPartRescueKing(kingPosition)) {
            return false;
        }
        return true;
    }

    private boolean isKingInCheck(Tile kingPosition, List<Tile> opponentPieces, Board board) {

        for (Tile piece : opponentPieces) {
            if (isPossibleMove(piece, kingPosition, board)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPossibleMove(Tile part, Tile target, Board board) {

        switch (part.getTypePart()) {
            case TOWER:
                Tower tower = new Tower(part.getTileX(), part.getTileY());
                return tower.movePart(board, part, target);
            case HORSE:
                ar.edu.utn.frc.tup.lciii.Horse horse = new ar.edu.utn.frc.tup.lciii.Horse(part.getTileX(), part.getTileY());
                return horse.movePart(board, part, target);

            case BISHOP:
                Bishop bishop = new Bishop(part.getTileX(), part.getTileY());
                return bishop.movePart(board, part, target);
            case QUEEN:
                Queen queen = new Queen(part.getTileX(), part.getTileY());
                return queen.movePart(board, part, target);
            case KING:
                King king = new King(part.getTileX(), part.getTileY());
                return king.movePart(board, part, target);
            case PAWN:
                Pawn pawn = new Pawn(part.getTileX(), part.getTileY(), part.getName());
                return pawn.movePart(board, part, target);
            default:
                System.out.println("Invalid option. Please select a valid option.");
                break;
        }
        return false;
    }

    private boolean canKingEscapeCheck(String kingColor, Board board) {

        Tile kingPosition = board.getKingPosition(kingColor);

        List<Tile> kingMovements = new King(kingPosition.getTileX(), kingPosition.getTileY()).getPossibleMovements(board, kingPosition);

        List<Tile> opponentPieces = (kingColor.equals("white")) ? board.getBlackPieces() : board.getWhitePieces();

        for (Tile move : kingMovements) {
            if (board.isInsideBoard(move) && board.getTileInBoard(move).getName().equals("└-┘")) {
                Tile kingMove = board.getTileInBoard(move);
                kingMove.setName(kingPosition.getName());
                if (!opponentPieces.stream().anyMatch(opponent -> isPossibleMove(opponent, kingMove, board))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canAnyPieceCaptureThreat(Tile kingPosition, Board board) {

        Tile pieceHacke = null;
        List<Tile> opponentPieces = (kingPosition.getName().equals("KIW")) ? board.getBlackPieces() : board.getWhitePieces();
        for (Tile piece : opponentPieces) {
            if (isPossibleMove(piece, kingPosition, board)) {
                pieceHacke = piece;
                break;
            }
        }
        List<Tile> opponentPieceEnemy = (pieceHacke.getName().substring(2, 3).equals("W")) ? board.getBlackPieces() : board.getWhitePieces();

        for (Tile piece : opponentPieceEnemy) {
            if (isPossibleMove(piece, pieceHacke, board)) {
                if (simulationFakeMoveParte(piece, pieceHacke, board, kingPosition)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean simulationFakeMoveParte(Tile piece, Tile pieceHacke, Board board, Tile king) {
        boolean flag = true;
        Tile originPiece = new Tile(piece.getTileX(), piece.getTileY(), piece.getName(), piece.getTypePart());
        Tile originPieceHacke = new Tile(pieceHacke.getTileX(), pieceHacke.getTileY(), pieceHacke.getName(), pieceHacke.getTypePart());

        board.setNewPositionsInGame(piece.getName(), pieceHacke);
        List<Tile> opponents = king.getName().equals("KIW") ? board.getBlackPieces() : board.getWhitePieces();
        Tile kingPosition = board.getKingPosition(king.getName());
        if (isKingInCheck(kingPosition, opponents, board)) {
            flag = false;
        }
        board.setNewPositionsInGame(originPiece.getName(), originPiece);
        List<Tile> tiles = board.getBoard();
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getTileX() == originPieceHacke.getTileX() && tiles.get(i).getTileY() == originPieceHacke.getTileY()) {
                tiles.get(i).setName(originPieceHacke.getName());
                tiles.get(i).setTypePart(originPieceHacke.getTypePart());
            }
        }
        return flag;
    }

    public boolean verifyAnyPartRescueKing(Tile king) {

        List<Tile> kingMovements = new King(king.getTileX(), king.getTileY()).getPossibleMovements(board, king);

        List<Tile> parts = (king.getName().substring(2, 3).equals("B")) ? board.getBlackPieces() : board.getWhitePieces();

        List<Tile> possibleMovementsTower = new ArrayList<>();
        List<Tile> possibleMovementsHorse = new ArrayList<>();
        List<Tile> possibleMovementsBishop = new ArrayList<>();
        List<Tile> possibleMovementsQueen = new ArrayList<>();
        List<Tile> possibleMovementsPawn = new ArrayList<>();

        for (int i = 0; i < parts.size(); i++) {

            switch (parts.get(i).getTypePart()) {
                case TOWER:
                    Tower tower = new Tower(parts.get(i).getTileX(), parts.get(i).getTileY(), parts.get(i).getName(), parts.get(i).getTypePart());
                    possibleMovementsTower.addAll(tower.getPossibleMovements(tower, board));
                    if(isRescueKing(tower, king, kingMovements, possibleMovementsTower, board)){
                        return true;
                    }
                    possibleMovementsTower.clear();
                    break;
                case HORSE:
                    Horse horse = new Horse(parts.get(i).getTileX(), parts.get(i).getTileY(), parts.get(i).getName(), parts.get(i).getTypePart());
                    possibleMovementsHorse.addAll(horse.getPossibleMovements(horse, board));
                    if(isRescueKing(horse, king, kingMovements, possibleMovementsHorse, board)){
                        return true;
                    }
                    possibleMovementsHorse.clear();
                    break;
                case BISHOP:
                    Bishop bishop = new Bishop(parts.get(i).getTileX(), parts.get(i).getTileY(), parts.get(i).getName(), parts.get(i).getTypePart());
                    possibleMovementsBishop.addAll(bishop.getPossibleMovements(bishop, board));
                    if(isRescueKing(bishop, king, kingMovements, possibleMovementsBishop, board)){
                        return true;
                    }
                    possibleMovementsBishop.clear();
                    break;
                case QUEEN:
                    Queen queen = new Queen(parts.get(i).getTileX(), parts.get(i).getTileY(), parts.get(i).getName(), parts.get(i).getTypePart());
                    possibleMovementsQueen.addAll(queen.getPossibleMovements(queen, board));
                    if(isRescueKing(queen, king, kingMovements, possibleMovementsQueen, board)){
                        return true;
                    }
                    possibleMovementsQueen.clear();
                    break;
                case PAWN:
                    Pawn pawn = new Pawn(parts.get(i).getTileX(), parts.get(i).getTileY(), parts.get(i).getName(), parts.get(i).getTypePart());
                    possibleMovementsPawn.addAll(pawn.getPossibleMovements(pawn, board));
                    if(isRescueKing(pawn, king, kingMovements, possibleMovementsPawn, board)){
                        return true;
                    }
                    possibleMovementsPawn.clear();
                    break;
                default: //Si entra en default es porque es el King
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }


        }

        return false;

    }

    private Boolean isRescueKing(Tile tile, Tile king, List<Tile> kingMovements, List<Tile> possibleMovementsTile, Board board){
        for (Tile kingMovement : kingMovements) {
            for (Tile tileMovement : possibleMovementsTile) {
                if (tileMovement.getTileX() == kingMovement.getTileX() && tileMovement.getTileY() == kingMovement.getTileY()) {
                    if(simulationFakeMoveParte(tile, kingMovement, board, king)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private List<Tile> handlerPossibleAllPartsPossiblesMovements(List<Tile> partsMovements) {

        List<Tile> movements = new ArrayList<>();

        movements.addAll(partsMovements);
        return movements;
    }


    public boolean verifyEndGameWhenSomeKingIsNoPresent(List<Tile> board) {

        return board.stream().anyMatch(x -> x.getName().equals("KIW") || x.equals("KIB"));
    }

}
