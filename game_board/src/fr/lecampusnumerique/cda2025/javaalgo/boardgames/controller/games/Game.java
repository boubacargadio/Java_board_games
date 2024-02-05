package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players.Player;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.victoryChecker.VictoryChecker;

import java.util.Scanner;

public class Game implements IGame {
    private final GameIdentity gameIdentity;
    private Player player1;
    private Player player2;
    private Symbol[] symbols;
    private final Board board;
    private boolean isOver;

    private final Scanner scanner = new Scanner(System.in);

    private final VictoryChecker victoryChecker;

    public Game(GameIdentity gameIdentity, int amountOfRows, int amountOfColumns) {
        this.gameIdentity = gameIdentity;
        this.board = new Board(amountOfRows, amountOfColumns);
        this.victoryChecker = new VictoryChecker(gameIdentity.getVictorySize());
        this.symbols = gameIdentity.getSymbols();
    }

    public Symbol[] getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbol[] symbols) {
        this.symbols = symbols;
    }

    protected boolean getIsOver() {
        return this.isOver;
    }

    protected void setIsOver(boolean isOver) {
        this.isOver = isOver;
    }


    public void play() {
        System.out.println(" We are playing " + this.gameIdentity.getName());
        definePlayers();

        Player currentPlayer = player1;
        while (!board.isFull() && !victoryChecker.isVictory(board.getBoard())) {
            if (gameIdentity == GameIdentity.CONNECT4) {
                playConnect4Turn(currentPlayer);
            } else {
                playerTurn(currentPlayer);
            }
            currentPlayer = switchPlayer(currentPlayer);
            board.displayBoard();
        }

        if (victoryChecker.isVictory(board.getBoard())) {
            String winner = victoryChecker.getWinningSymbol();
            System.out.println("Player " + winner + " won!");
        } else {
            System.out.println("You both lost you're shit.");
        }

    }

    private void buildPlayers(int players) {
        boolean isPlayer1Artificial = players == 0;
        boolean isPlayer2Artificial = players == 0 || players == 1;

        player1 = new Player(1, symbols[0], isPlayer1Artificial);
        player2 = new Player(2, symbols[1], isPlayer2Artificial);
    }

    private void definePlayers() {
        int howManyPlayers;
        System.out.println("How many players want to play? ");
        System.out.println("Press 2 for 2 players |  1 to play against computer |  or 0 to watch the computer playing!");
        howManyPlayers = Integer.parseInt(scanner.next());

        buildPlayers(howManyPlayers);
    }

    public void stop() {
    }

    public void restart() {
    }

    private void playerTurn(Player player) {
        boolean running = true;
        while (running) {
            System.out.println("Player turn, playing move " + player.getRepresentation());
            int[] move;

            if (player.isArtificial()) {
                move = player.getArtificialPlayerMove(board.getCellsAvailable());
            } else {
                move = player.getPlayerMove();
            }

            Cell cell = board.getBoard()[move[0]][move[1]];

            if (cell.isAvailable()) {

                cell.setSymbol(player.getSymbol());
                running = false;
            } else {
                System.out.println("Case déjà remplie. Veuillez en choisir une autre.");
            }
        }
    }

    private int setOwnerConnect4(int col) {
        Cell[][] board = this.board.getBoard();

        for (int row = board.length - 1; row >= 0; row--) {
            Cell cell = board[row][col];
            if (cell.isAvailable()) {
                return row;
            }
        }
        return -1;
    }

    private void playConnect4Turn(Player player) {
        boolean running = true;
        int[] move = new int[2];
        int amountOfColumns = board.getAmountOfColumns();

        while (running) {
            System.out.println("Player turn, playing move " + player.getRepresentation());

            int col = player.getPlayerMoveForConnect4(amountOfColumns);
            int row = setOwnerConnect4(col);

            if (row == -1) {
                System.out.println("This column is full, chose another one");
            } else {
                move[0] = row;
                move[1] = col;
                running = false;
            }
        }
        Cell cell = board.getBoard()[move[0]][move[1]];
        cell.setSymbol(player.getSymbol());
    }

    private Player switchPlayer(Player currentPlayer) {
        if (currentPlayer == player1) {
            return player2;
        } else {
            return player1;
        }
    }

    // *****
    // ************ METHODS
    // *****

    public boolean isOver() {
        boolean isVictory = victoryChecker.isVictory(board.getBoard());

        boolean isBoardFull = board.isFull();

        return isBoardFull | isVictory;
    }
}