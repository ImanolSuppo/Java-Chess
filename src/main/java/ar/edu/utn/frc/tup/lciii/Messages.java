package ar.edu.utn.frc.tup.lciii;

import lombok.Getter;
import lombok.Setter;


public class Messages {


    @Getter
    private String welcomeChess = "************************************************ Welcome Chess ************************************************\n\n";

    @Getter
    private String startGame = "************************************************ Starting Game ************************************************\n\n";

    @Getter
    private String example = "Example : H1W";

    @Getter
    private String mensajeInicio = "Welcome to the Chess Game!!  \n" + "Chose any option \n" +
            " 1) New Game \n" +
            " 2) Load old game \n" +
            " 3) About chess rules \n" +
            " 4) Exit Game";




    public void movePart(Player player) {

        System.out.println("\n\n!Player " + player.getName() + "¡ -- " + "Team Color: " + player.getTeamColor() + "\n¡Enter The Name Of The Part That You Move!");
        System.out.println("Example: H1W");
        System.out.println("Name Part: \n");


    }

    public void enterNameMovePart(Player player) {

        System.out.println("¡Player: " + player.getName() + "!");
        System.out.println("¡Enter The Name Of The Part That You Move!     \n" + "* Example: H1W \n");

    }

    public void validateNamePart(Player player) {

        System.out.println("* *********************************************************************************************************************************************** *");
        System.out.println("* !" + player.getName() + "¡" + " -- " + "Team Color: " + player.getTeamColor() + ":");
        System.out.println("* THE NAME THAT YOU ENTER NOT  EXIST OR IS INVALID TRY AGAIN...");
        System.out.println("* *********************************************************************************************************************************************** *");

    }

    public void inputAlgebraicNotation(String playerName) {

        System.out.println("¡Player " + playerName + "!" + " Enter Your Movement Using Algebraic Notation a3 ...\n\n");

    }

    public void alertMessageColorTeamIsBad(Player player) {

        System.out.println("¡Player: " + player.getName() + "!");
        System.out.println("Remind that you are team color: " + player.getTeamColor());
        System.out.println("Try Again Please...");
    }

    public void alertMessageMoveIsNotPossible() {

        System.out.println("* ********************************************************************************************************* *");
        System.out.println("* **************************************** ERROR ********************************************************** *");
        System.out.println(" THE POSITION THAT YOU TRY TO MOVE IS NOT AVAILABLE FOR THIS PART , TRY WITH ANOTHER PLEASE...");
        System.out.println("* ********************************************************************************************************* *");
    }

    public void alertMessageNamePlayerEmpty() {

        System.out.println("* ********************************************************************************************************* *");
        System.out.println("* **************************************** ERROR ********************************************************** *");
        System.out.println(" THE NAME PLAYER NOT SHOULD BE EMPTY... TRY AGAIN");
        System.out.println("* ********************************************************************************************************* *");

    }

    public void alertMessageNameTeamColorEmpty() {

        System.out.println("* ********************************************************************************************************* *");
        System.out.println("* **************************************** ERROR ********************************************************** *");
        System.out.println(" THE TEAM COLOR NOT SHOULD BE EMPTY... TRY AGAIN");
        System.out.println("* ********************************************************************************************************* *");

    }

    public void alertMessageSelectPlayerName(String player) {

        System.out.println("Player " + player + " Enter Your Name Please...");
    }

    public void alertMessageSelectTeamColor(String player) {

        System.out.println("Player " + player + " Select Your Part Colour...    W or B");

    }

    public void enterGame(){
        System.out.println("What game do you want to play? (please enter only the number!)");
    }

    public void saveGame(){
        System.out.println("Do you want to Update/Insert this game? \n" +
                "Y - Yes \n" +
                "N - No");
    }
    public void errorMessage(){
        System.out.println("\nUps, you pressed the wrong key. Try with the letter 'Y' or 'N'!\n");
    }

    public void insertingPlayerOne(){
        System.out.println("Inserting player One...");
    }
    public void insertingPlayerTwo(){
        System.out.println("Inserting player Two...");
    }
    public void insertingGame(){
        System.out.println("Creating Game...");
    }
    public void insertingBoard(){
        System.out.println("Inserting Board...");
    }
    public void insertingHistoricalMovements(){
        System.out.println("Inserting Board...");
    }
    public void gameInserted(){
        System.out.println("The game was inserted successfully \n");
    }
    public void updatingGame(){
        System.out.println("wait, updating game...");
    }
    public void gameUpdated(){
        System.out.println("Game updated successfully \n");
    }
    public void kingBlackHacke(){
        System.out.println("\n---------------------------");
        System.out.println("THE BLACK KING IS IN HACKED");
        System.out.println("---------------------------");
    }
    public void kingBlackHackeMate(){
        System.out.println("\n---------------------------");
        System.out.println("THE BLACK KING IS IN MATE");
        System.out.println("PLAYER ONE HAS WON");
        System.out.println("---------------------------");
    }
    public void kingWhiteHacke(){
        System.out.println("\n---------------------------");
        System.out.println("THE WHITE KING IS IN HACKED");
        System.out.println("---------------------------");
    }
    public void kingWhiteHackeMate(){
        System.out.println("\n---------------------------");
        System.out.println("THE WHITE KING IS IN MATE");
        System.out.println("PLAYER TWO HAS WON");
        System.out.println("---------------------------");
    }
    public void playerWinner(Player player){
        System.out.println("The winner is " + player.getName() + " ¡congratulation!");
    }

    public void goToMenu(){
        System.out.println("would you like to go to the menu?\n" +
                "Y - Yes \n" +
                "N - No");
    }
    public void messageMistake(){
        System.out.println("Ups, you pressed the wrong number. Try again!");
    }
    public void howToPlayChess(){
        System.out.println("Look at this link and you will learn how to play chess like a pro! \n\n" +
                "https://www.chess.com/learn-how-to-play-chess \n\n");
    }
    public void playerAlreadyCreated(){
        System.out.println("\n" +
                "The name you are trying to enter is not available, please try another! \n");
    }

    public void endGameMessage() {




        System.out.println("\n*********************************  THANKS FOR PLAY  *********************************************");
        System.out.println("\n********************************   END GAME          ********************************************");

    }

}