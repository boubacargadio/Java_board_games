package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players.Player;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.victoryChecker.VictoryChecker;

import java.util.Scanner;

public abstract class AbstractGame implements Game {
    private GameIdentity gameIdentity;
    private Player player1;
    private Player player2;
    private Symbol[] symbols;
    private final Board board;
    private boolean isOver;

    private Scanner scanner = new Scanner(System.in);

    private VictoryChecker victoryChecker = new VictoryChecker(0);

    abstract void defineSymbols();

    public AbstractGame(GameIdentity gameIdentity, int amountOfRows, int amountOfColumns) {
        this.gameIdentity = gameIdentity;
        this.board = new Board(amountOfRows, amountOfColumns);
        defineSymbols();
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
            playerTurn(currentPlayer);
            currentPlayer = switchPlayer(currentPlayer);
            board.displayBoard();
        }
        System.out.println("Game over or victory");
    }

    private void buildPlayers(int players){
        boolean isPlayer1Artificial = players == 0;
        boolean isPlayer2Artificial = players == 0 || players == 1;

        player1 = new Player(1, symbols[0], isPlayer1Artificial);
        player2 = new Player(2, symbols[1], isPlayer2Artificial);
    }

    private void definePlayers(){
        int howManyPlayers;
        System.out.println("How many players want to play? ");
        System.out.println("Press 2 for 2 players |  1 to play against computer |  or 0 to watch the computer playing!");
        howManyPlayers = Integer.parseInt(scanner.next());

        buildPlayers(howManyPlayers);
    }

    public void stop() {    }

    public void restart() {    }


    public void playerTurn(Player player) {
        boolean running = true;
        while(running) {
            System.out.println("Player turn, playing move " + player.getRepresentation());
            int[] move = player.getPlayerMove();

            if (board.getBoard()[move[0]][move[1]].isAvailable()) {
                board.getBoard()[move[0]][move[1]].setSymbol(player.getSymbol());
                running = false;
            } else {
                System.out.println("Case déjà remplie. Veuillez en choisir une autre.");
            }
        }

        // Check if move is correct --> with the move; check if the cell in board is empty
        // move [4, 2] --> check if board[2][4] is empty / available
        // if error --> getPlayerMove again
        // if good --> setOwner of cell to belong to player && check for victory
    }


    public Player switchPlayer(Player currentPlayer) {
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