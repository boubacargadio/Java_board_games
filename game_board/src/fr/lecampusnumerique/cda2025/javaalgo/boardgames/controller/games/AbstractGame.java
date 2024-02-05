package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players.Player;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.victoryChecker.VictoryChecker;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.View;

public abstract class AbstractGame implements IGame {
    private final GameIdentity gameIdentity;
    private Player player1;
    private Player player2;
    private Symbol[] symbols;
    private final Board board;
    private boolean isOver;

    private final VictoryChecker victoryChecker;
    private final UserInteraction userInteraction = new UserInteraction();
    private final View view = new View();

    public AbstractGame(GameIdentity gameIdentity, int amountOfRows, int amountOfColumns) {
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

    public Board getBoard() {
        return board;
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
            board.isBoardFull();
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
        view.displayChooseHowManyPlayers();
        howManyPlayers = userInteraction.getIntChoice(0, 2);

        buildPlayers(howManyPlayers);
    }

    public void stop() {
    }

    public void restart() {
    }

    protected void playerTurn(Player player) {
        boolean running = true;
        while (running) {
            view.displayNewTurn(player);

            int[] move;

            if (player.isArtificial()) {
                move = player.getArtificialPlayerMove(board.getCellsAvailable());
            } else {
                move = player.getPlayerMove(gameIdentity.getSize());
            }

            Cell cell = board.getBoard()[move[0]][move[1]];

            if (cell.isAvailable()) {

                cell.setSymbol(player.getSymbol());
                running = false;
            } else {
                view.displayCellNonAvailable();
            }
        }
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