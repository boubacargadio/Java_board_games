package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player implements IPlayer {
    private int number;
    private Symbol symbol;
    private boolean isArtificial;
    private final UserInteraction userInteraction = new UserInteraction();

    private void definePlayerSymbol(int playerNumber, Symbol result1, Symbol result2) {
        this.symbol = (playerNumber == 1) ? result1 : result2;
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
        return userInteraction.askPlayerForMove("column");
    }

    private int getRowMove() {
        return userInteraction.askPlayerForMove("row");
    }

    public int[] getArtificialPlayerMove(List<int[]> availableCells) {
        int[] playerMove;

        int length = availableCells.size();
        Random randomizer = new Random();
        playerMove = availableCells.get(randomizer.nextInt(length));

        System.out.println("Getting player " + getRepresentation() + " move");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return playerMove;
    }

    public int[] getPlayerMove() {
        int[] playerMove = new int[2];
        playerMove[0] = getRowMove() - 1;
        playerMove[1] = getColumnMove() - 1;

        return playerMove;
    }

    public void playerTurn() {
    }
}
