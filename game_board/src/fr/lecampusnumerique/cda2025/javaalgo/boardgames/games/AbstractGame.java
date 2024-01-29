package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.players.Player;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.players.TicTacToePlayer;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.TicTacToeSymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.victoryChecker.VictoryChecker;

public abstract class AbstractGame implements Game {
    private Player player1;
    private Player player2;

    private final Board board;
    private boolean isOver;

    VictoryChecker victoryChecker = new VictoryChecker(0);


    public AbstractGame(int amountOfRows, int amountOfColumns) {
        this.board = new Board(amountOfRows, amountOfColumns);
    }

    protected boolean getIsOver() {
        return this.isOver;
    }

    protected void setIsOver(boolean isOver) {
        this.isOver = isOver;
    }


    public void play(Games game) {
        System.out.println(" We are playing " + game.getName());
        player1 = new TicTacToePlayer(1, TicTacToeSymbol.X, false);
        player2 = new TicTacToePlayer(2, TicTacToeSymbol.O, false);

        Player currentPlayer = player1;

        while (!board.isFull()) {
            currentPlayer = switchPlayer(currentPlayer);
        }
    }

    public void stop() {

    }

    public void restart() {

    }

    public void playerTurns() {

    }

    public void playTurns() {

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