package ar.edu.utn.frc.tup.lciii;


import ar.edu.utn.frc.tup.lciii.DataBase.ChessDataBaseDao;
import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import ar.edu.utn.frc.tup.lciii.Validations.Validation;

import java.util.Scanner;

public class NewGame {

    Menu menu = new Menu();
    Scanner scan = new Scanner(System.in);
    Messages messages = new Messages();
    Validation validate = new Validation();
    Game game;
    ChessDataBaseDao helper = new ChessDataBaseDao();

    public void IniciarJuego() {

        int cont = 0;

        System.out.println(messages.getWelcomeChess());

        messages.alertMessageSelectPlayerName("One");

        String playerName = scan.next();

        playerName = validate.keepRunningNamePlayerIsEmpty(playerName.toUpperCase(), scan);

        while (!validate.validateUserName(playerName)) {
            messages.playerAlreadyCreated();

            messages.alertMessageSelectPlayerName("One");

            playerName = scan.next();

            playerName = validate.keepRunningNamePlayerIsEmpty(playerName.toUpperCase(), scan);
        }

        messages.alertMessageSelectTeamColor("one");
        
        String colorTeam = scan.nextLine();
        while (colorTeam.isEmpty()){
            colorTeam = scan.nextLine();
        }

        colorTeam = validate.keepRunningTeamColorIsEmpty(colorTeam.toUpperCase(), scan);

        TeamColor teamcolor = colorTeam.equals("B") ? TeamColor.BLACK : TeamColor.WHITE;

        Player playerOne = new Player(playerName, teamcolor);

        messages.alertMessageSelectPlayerName("Two");

        playerName = scan.nextLine();

        playerName = validate.keepRunningNamePlayerIsEmpty(playerName.toUpperCase(), scan);

        while (!validate.validateUserName(playerName)) {

            messages.playerAlreadyCreated();

            messages.alertMessageSelectPlayerName("Two");

            playerName = scan.next();

            playerName = validate.keepRunningNamePlayerIsEmpty(playerName.toUpperCase(), scan);
        }

        teamcolor = playerOne.getTeamColor().toString().equals("WHITE") ? TeamColor.BLACK : TeamColor.WHITE;

        Player playerTwo = new Player(playerName, teamcolor);

        System.out.println(messages.getStartGame());

        game = new Game(playerOne, playerTwo);

        boolean endGame = false;

        game.getBoard().printStartBoard();

        while (!endGame) {

            messages.movePart(playerOne);

            String namePart = scan.next().toUpperCase();

            namePart = game.keepRunningNamePartIsBad(namePart, playerOne, scan);

            namePart = game.validateColorPartIsCorrectly(playerOne, namePart, scan);

            messages.inputAlgebraicNotation(playerOne.getName());

            String coordinate = scan.next();

            Tile nextPosition;

            boolean move;

            if (!validate.validateAlgebraicNotation(coordinate)) {

                coordinate = validate.keepRunningAlgebraicNotation(scan, false);
            }

            nextPosition = game.letterToTile(coordinate.toLowerCase());

            move = game.moveParts(namePart, nextPosition, playerOne);


            if (!move) {

                game.keepRunningIsMoveIsNotPossible(false, namePart, scan, playerOne);
            } else {

                game.addHistoricalMovements(nextPosition, namePart);

                game.getBoard().setNewPositionsInGame(namePart, nextPosition);
            }

            game.getBoard().printBoardGameSession();

            if (!game.verifyEndGameWhenSomeKingIsNoPresent(game.getBoard().getBoard())) {
                messages.endGameMessage();
                endGame = true;
                return;
            }

            if (game.hackeMateDetection("black")) {
                messages.kingBlackHackeMate();
                messages.playerWinner(game.getPlayerOne());
                menu.start();
            } else if (game.hackeMateDetection("white")) {
                messages.kingWhiteHackeMate();
                messages.playerWinner(game.getPlayerTwo());
                menu.start();
            } else {
                if (game.hackeDetection("white")) {
                    messages.kingWhiteHacke();
                }
                if (game.hackeDetection("black")) {
                    messages.kingBlackHacke();
                }
            }


            messages.movePart(playerTwo);

            namePart = scan.next().toUpperCase();

            namePart = game.keepRunningNamePartIsBad(namePart, playerTwo, scan);

            namePart = game.validateColorPartIsCorrectly(playerTwo, namePart, scan);

            messages.inputAlgebraicNotation(playerTwo.getName());

            coordinate = scan.next();

            if (!validate.validateAlgebraicNotation(coordinate)) {

                coordinate = validate.keepRunningAlgebraicNotation(scan, false);

            }

            nextPosition = game.letterToTile(coordinate.toLowerCase());

            move = game.moveParts(namePart, nextPosition, playerTwo);

            if (!move) {

                game.keepRunningIsMoveIsNotPossible(false, namePart, scan, playerTwo);

            } else {
                game.addHistoricalMovements(nextPosition, namePart);

                game.getBoard().setNewPositionsInGame(namePart, nextPosition);
            }

            game.getBoard().printBoardGameSession();

            if (!game.verifyEndGameWhenSomeKingIsNoPresent(game.getBoard().getBoard())) {
                messages.endGameMessage();
                endGame = true;
                return;
            }

            if (game.hackeMateDetection("black")) {
                messages.kingBlackHackeMate();
                messages.playerWinner(game.getPlayerOne());
                menu.start();
            } else if (game.hackeMateDetection("white")) {
                messages.kingWhiteHackeMate();
                messages.playerWinner(game.getPlayerTwo());
                menu.start();
            } else {
                if (game.hackeDetection("white")) {
                    messages.kingWhiteHacke();
                }
                if (game.hackeDetection("black")) {
                    messages.kingBlackHacke();
                }
            }

            if (!game.verifyEndGameWhenSomeKingIsNoPresent(game.getBoard().getBoard())) {
                messages.endGameMessage();
                endGame = true;
                return;
            }


            messages.saveGame();
            String prueba = scan.next();
            while (!prueba.equals("Y") && !prueba.equals("y") && !prueba.equals("N") && !prueba.equals("n")) {
                messages.errorMessage();
                messages.saveGame();
                prueba = scan.next();
            }
            if (prueba.equals("y") || prueba.equals("Y")) {
                if (cont > 0) {
                    messages.updatingGame();
                    helper.updateBoards(game, helper.selectIdJuego(playerOne, playerTwo), helper.selectIdTile(helper.selectIdJuego(playerOne, playerTwo))); //todavia creo que no anda
                    messages.gameUpdated();
                } else if (cont == 0) {
                    if (helper.insertPlayers(playerOne) > 0) {
                        messages.insertingPlayerOne();
                    }
                    if (helper.insertPlayers(playerTwo) > 0) {
                        messages.insertingPlayerTwo();
                    }
                    if (helper.insertJuego(helper.selectIdPlayers(playerOne), helper.selectIdPlayers(playerTwo)) > 0) {
                        messages.insertingGame();
                    }
                    if (helper.insertBoards(game, helper.selectIdJuego(playerOne, playerTwo)) > 0) {
                        messages.insertingBoard();
                    }
                    if (helper.inserthistoricalMovements(game, helper.selectIdJuego(playerOne, playerTwo)) > 0) {
                        messages.insertingHistoricalMovements();
                    }
                    messages.gameInserted();
                    cont++;
                }
                messages.goToMenu();
                String opt = scan.next();
                while (!opt.equals("Y") && !opt.equals("y") && !opt.equals("N") && !opt.equals("n")) {
                    messages.errorMessage();
                    messages.goToMenu();
                    opt = scan.next();
                }
                if (opt.equals("Y") || opt.equals("y")) {
                    menu.start();
                }
            }

            game.getBoard().printBoardGameSession();
        }
    }

    public void LoadGame() {

        System.out.println(messages.getWelcomeChess());

        messages.enterGame();

        helper.selectShowGames();
        int numberGame = scan.nextInt();
        game = helper.selectGame(numberGame, helper.selectHistoricalMovements(numberGame));

        System.out.println(messages.getStartGame());

        boolean endGame = false;

        while (!endGame) {

            game.getBoard().printBoardGameSession();

            messages.movePart(game.getPlayerOne());

            String namePart = scan.next().toUpperCase();

            namePart = game.keepRunningNamePartIsBad(namePart, game.getPlayerOne(), scan);

            namePart = game.validateColorPartIsCorrectly(game.getPlayerOne(), namePart, scan);


            messages.inputAlgebraicNotation(game.getPlayerOne().getName());

            String coordinate = scan.next();
            Tile nextPosition;
            boolean move;

            if (!validate.validateAlgebraicNotation(coordinate)) {

                coordinate = validate.keepRunningAlgebraicNotation(scan, false);

            }

            nextPosition = game.letterToTile(coordinate.toLowerCase());

            move = game.moveParts(namePart, nextPosition, game.getPlayerOne());


            if (!move) {

                game.keepRunningIsMoveIsNotPossible(false, namePart, scan, game.getPlayerOne());
            } else {

                game.addHistoricalMovements(nextPosition, namePart);

                game.getBoard().setNewPositionsInGame(namePart, nextPosition);
            }

            game.getBoard().printBoardGameSession();

            if (!game.verifyEndGameWhenSomeKingIsNoPresent(game.getBoard().getBoard())) {
                messages.endGameMessage();
                endGame = true;
                return;
            }

            if (game.hackeMateDetection("black")) {
                messages.kingBlackHackeMate();
                messages.playerWinner(game.getPlayerOne());
                menu.start();
            } else if (game.hackeMateDetection("white")) {
                messages.kingWhiteHackeMate();
                messages.playerWinner(game.getPlayerTwo());
                menu.start();
            } else {
                if (game.hackeDetection("white")) {
                    messages.kingWhiteHacke();
                }
                if (game.hackeDetection("black")) {
                    messages.kingBlackHacke();
                }
            }


            messages.movePart(game.getPlayerTwo());

            namePart = scan.next().toUpperCase();

            namePart = game.keepRunningNamePartIsBad(namePart, game.getPlayerTwo(), scan);

            namePart = game.validateColorPartIsCorrectly(game.getPlayerTwo(), namePart, scan);

            messages.inputAlgebraicNotation(game.getPlayerTwo().getName());

            coordinate = scan.next();

            if (!validate.validateAlgebraicNotation(coordinate)) {

                coordinate = validate.keepRunningAlgebraicNotation(scan, false);

            }

            nextPosition = game.letterToTile(coordinate.toLowerCase());

            move = game.moveParts(namePart, nextPosition, game.getPlayerTwo());

            if (!move) {

                game.keepRunningIsMoveIsNotPossible(false, namePart, scan, game.getPlayerTwo());

            } else {
                game.addHistoricalMovements(nextPosition, namePart);

                game.getBoard().setNewPositionsInGame(namePart, nextPosition);
            }

            game.getBoard().printBoardGameSession();

            if (!game.verifyEndGameWhenSomeKingIsNoPresent(game.getBoard().getBoard())) {
                messages.endGameMessage();
                endGame = true;
                return;
            }

            if (game.hackeMateDetection("black")) {
                messages.kingBlackHackeMate();
                messages.playerWinner(game.getPlayerOne());
                menu.start();
            } else if (game.hackeMateDetection("white")) {
                messages.kingWhiteHackeMate();
                messages.playerWinner(game.getPlayerTwo());
                menu.start();
            } else {
                if (game.hackeDetection("white")) {
                    messages.kingWhiteHacke();
                }
                if (game.hackeDetection("black")) {
                    messages.kingBlackHacke();
                }
            }

            messages.saveGame();
            String prueba = scan.next();
            while (!prueba.equals("Y") && !prueba.equals("y") && !prueba.equals("N") && !prueba.equals("n")) {
                messages.errorMessage();
                messages.saveGame();
                prueba = scan.next();
            }

            if (prueba.equals("Y") || prueba.equals("y")) {
                messages.updatingGame();
                helper.updateBoards(game, numberGame, helper.selectIdTile(numberGame)); //todavia creo que no anda
                messages.gameUpdated();

                messages.goToMenu();
                String opt = scan.next();
                while (!opt.equals("Y") && !opt.equals("y") && !opt.equals("N") && !opt.equals("n")) {
                    messages.errorMessage();
                    messages.goToMenu();
                    opt = scan.next();
                }
                if (opt.equals("Y") || opt.equals("y")) {
                    menu.start();
                }
            }
        }
    }
}
