package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.GameIdentity;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
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

    public void displayBoardDrawing(Cell[][] board, int amountOfColumns) {
        String endRow = "|";
        StringBuilder horizontalBorder = new StringBuilder();
        horizontalBorder.append(" -----".repeat(amountOfColumns));

        System.out.println(horizontalBorder);

        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.printf("|  " + cell.getSymbol().getRepresentation() + "  ");
            }
            System.out.printf(endRow);
            System.out.println();
            System.out.println(horizontalBorder);
        }
    }

    public void displayPlayGame(GameIdentity gameIdentity){
        System.out.println(" We are playing " + gameIdentity.getName());

    }

    public void displayNewTurn(Player player) {
        System.out.println("Player turn, playing move " + player.getRepresentation());
    }

    public void displayCellNonAvailable(){
        System.out.println("Cellule non disponible. Veuillez en choisir une autre.");
    }

    public void displayColumnIsFull(){
        System.out.println("This column is full, chose another one");
    }

    public void displaySelectRow(){
        System.out.println("Select a row to target:");
    }
    public void displaySelectCol(){
        System.out.println("Select a column to target:");
    }

    public void displayWinner(String winner) {
        System.out.println("Player " + winner + " won!");
    }
    public void displayGameTie(){
        System.out.println("You both lost you're shit.");
    }


}
