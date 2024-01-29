package fr.lecampusnumerique.cda2025.javaalgo.boardgames.PlayerTurns;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.players.Player;

import java.util.Scanner;

public class PlayerTurn implements PlayerTurns{

    private Player player1;
    private Player player2;
    int sizeGame;
    private Cell[] board = new Cell[sizeGame];
    private int getPosition;
    public PlayerTurn(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    public PlayerTurn() {

    }

    @Override
    public Player switchPlayer() {
        Player currentPlayer = null;
        System.out.println("Turn of player: ");

        while(!boardIsFull() && victory()){
            if (currentPlayer == this.player1){
                return this.player2;
            } else {
                return this.player1;
            }
        }
        return currentPlayer;
    }
    void play (){
        Player currentPlayer = player1;
        while (!boardIsFull()){

            currentPlayer = switchPlayer(currentPlayer);
        }
    }

    private Player switchPlayer(Player currentPlayer) {

        return currentPlayer;
    }

    private boolean victory() {
        System.out.println("victory");
        return true;
    }

    @Override
    public boolean checkMove() {
        for (Cell cell : board){

        }
        return false;
    }
    public Scanner getPosition() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Entrez une colonne :");
            try {
                getPosition = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
            //            if (getPosition <= 0 && getPosition > sizeGame) {
            //                System.out.println("Position: " + getPosition);
            //                break;
            //            }

            }while (true);
    }

    @Override
    public boolean boardIsFull() {
        System.out.println("tie");
        return false;
    }
}
