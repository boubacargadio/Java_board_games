package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.board.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbol;

import java.util.Scanner;

public class Player implements IPlayer {
    private int number;
    private Symbol symbol;
    private boolean isArtificial;
    private Board board;

    private void definePlayerSymbol(int playerNumber, Symbol result1, Symbol result2){
        this.symbol = (playerNumber == 1) ? result1 :result2;
    }
    Scanner scanner = new Scanner(System.in);

    public Player(int number, Symbol symbol, boolean isArtificial) {
        this.number = number;
        this.symbol = symbol;
        this.isArtificial = isArtificial;
    }

    // **
    // *****
    // ********* METHODS
    // *****
    // **

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Symbol getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isArtificial() {
        return isArtificial;
    }

    public void setArtificial(boolean artificial) {
        isArtificial = artificial;
    }

    public String getRepresentation() {
        return getSymbol().getRepresentation();
    }

    private int getColumnMove() {
        boolean running = true;
        int answer = 0;
        do {
            System.out.println("Entrez une colonne :");
            try {
                answer = Integer.parseInt(scanner.next());
                System.out.println("colonne is: " + answer);
                running = false;
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
        } while (running);
        return answer;
    }

    private int getRowMove() {
        boolean running = true;
        int answer = 0;
        do {
            System.out.println("Choisissez une ligne :");
            try {
                answer = Integer.parseInt(scanner.next());
                System.out.println("row is: " + answer);
                running = false;
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
        } while (running);
        return answer;
    }


    public int[] getPlayerMove() {
        int[] playerMove = new int[2];

        System.out.println("Get player row");
        playerMove[0] = getRowMove()-1;

        System.out.println("Get player col");
        playerMove[1] = getColumnMove()-1;

        return playerMove;
    }

    private boolean isMoveInBoardSize(int row, int col){

        if (row < 0 || row >= board.getAmountOfRows() || col < 0 || col >= board.getAmountOfColumns()) {
            System.out.println("Invalid line or column");

        }
        return false;
    }
    public boolean checkmove(Board board, Player player,int[] move) {
        int row = move[0];
        int col = move[1];

        boolean isMoveInBoardSize = isMoveInBoardSize(row, col);
        boolean isAvailable = board.getBoard()[row][col].isAvailable();

        return isAvailable && isMoveInBoardSize;
    }

    // Set the owner of a cell on the board
    public void setOwner(Board board, Player player, int[] move) {
        int row = move[0];
        int col = move[1];


        if (row >= 0 && row < board.getAmountOfRows() && col >= 0 && col < board.getAmountOfColumns()) {
          //  board.getCell(row, col).getRepresentation();
            board.displayBoard();

        } else {
            System.out.println("row or column already used");
        }
    }
    public void playerTurn() {
    }
}
