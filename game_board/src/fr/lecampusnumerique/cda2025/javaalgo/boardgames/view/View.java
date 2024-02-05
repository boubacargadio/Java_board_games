package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.GameIdentity;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players.Player;

public class View {
    public void displayChooseHowManyPlayers(){
        System.out.println("How many players want to play? ");
        System.out.println("Press 2 for 2 players |  1 to play against computer |  or 0 to watch the computer playing!");
    }

    public void displayChooseGame(GameIdentity[] gamesList){
        System.out.println("Welcome to our boardgames platform. Which game do you want to play?");

        for (GameIdentity gameIdentity : gamesList) {
            int gameNumber = gameIdentity.ordinal() + 1;
            System.out.println("Press " + gameNumber + " to play " + gameIdentity.getName());
        }
    }

    public void displayNewTurn(Player player) {
        System.out.println("Player turn, playing move " + player.getRepresentation());
    }

    public void displayCellNonAvailable(){
        System.out.println("Cellule non disponible. Veuillez en choisir une autre.");
    }

    public void displaySelectRow(){
        System.out.println("Select a row to target:");
    }
    public void displaySelectCol(){
        System.out.println("Select a column to target:");
    }


}
