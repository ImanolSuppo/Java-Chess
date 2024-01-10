package ar.edu.utn.frc.tup.lciii.Validations;

import ar.edu.utn.frc.tup.lciii.DataBase.ChessDataBaseDao;
import ar.edu.utn.frc.tup.lciii.Enums.TeamColor;
import ar.edu.utn.frc.tup.lciii.Messages;
import ar.edu.utn.frc.tup.lciii.Player;

import java.util.Scanner;

public class Validation {

    private Messages messages;
    private ChessDataBaseDao helper = new ChessDataBaseDao();

    private TeamColor tm;
    public Validation() {

        messages = new Messages();
    }

    public String keepRunningNamePlayerIsEmpty(String namePlayer, Scanner scan) {

        while (!namePlayer.matches("[A-Z]+")) {

            messages.alertMessageNamePlayerEmpty();
            namePlayer = scan.nextLine().toUpperCase();
        }

        return namePlayer;
    }

    public String keepRunningTeamColorIsEmpty(String teamColor, Scanner scan) {

        while (!teamColor.equals("W") && !teamColor.equals("B")) {

            messages.alertMessageNameTeamColorEmpty();
            teamColor = scan.nextLine().toUpperCase();
        }
        return teamColor.toUpperCase();
    }

    public boolean validateAlgebraicNotation(String coordinates) {


        return coordinates.length() == 2 && coordinates.substring(0, 1).toLowerCase().matches("[a-h]+") && coordinates.substring(1, 2).toLowerCase().matches("[1-9]+");

    }

    public String keepRunningAlgebraicNotation(Scanner scan, boolean flag) {

        String coordinate = null;

        while (!flag) {


            System.out.println("* *********************************************************** *");
            System.out.println("* *********************************************************** *");
            System.out.println("* ----------------   ERROR ----------------                   *");
            System.out.println("* THE NOTATION THAT YOU ENTER IS NOT VALID, TRY AGAIN...      *");
            System.out.println("* REMIND ENTER FOR EXAMPLE a3, ENTER NOTATION:                *");
            System.out.println("* *********************************************************** *");
            System.out.println("* *********************************************************** *");

            coordinate = scan.nextLine();

            if (validateAlgebraicNotation(coordinate.toLowerCase())) {

                break;
            }

        }

        return coordinate;

    }

    public boolean validateUserName(String playerName){
        Player player = new Player(playerName,tm.WHITE);
        if (helper.selectIdPlayers(player) == 0){
            return true;
        }
        return false;
    }



}
