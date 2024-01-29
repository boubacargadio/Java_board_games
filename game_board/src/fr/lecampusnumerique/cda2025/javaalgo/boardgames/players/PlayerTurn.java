package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.Cell;
import java.util.Scanner;

public class PlayerTurn  {



    public void play(){

        Player currentPlayer = player1;
        while (!boardIsFull() && victory()){
            currentPlayer = switchPlayer(currentPlayer);
        }
    }

    void gameTurn(Player current){
        getMove();
        while (!checkMove()){
            getMove();
        }
        // assigne la position au joueur
        getMovePlayer(current);
    }

    // assigne la position au joueur
    private void getMovePlayer(Player current) {

    }
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

    private Player switchPlayer(Player currentPlayer) {
        return currentPlayer;
    }

    private boolean victory() {
        System.out.println("victory");
        return false;
    }


    public boolean checkMove() {
        for (Cell cell : board){
            if (!(cell.getRepresentation().equals(player1.getRepresentation())
                || cell.getRepresentation().equals(player2.getRepresentation()))) {
                return false;
            }
        }
        System.out.println("move invalid");
        return true;
    }
    public Scanner getMove() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("entry a position:");
            try {
                getPosition = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
                if (getPosition <= 0 && getPosition > sizeGame) {
                    System.out.println("Position: " + getPosition);
                    break;
                }

            }while (true);
        return scanner;
    }
}
