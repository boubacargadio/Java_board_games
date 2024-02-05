package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.View;

public class Player implements IPlayer {
    private int number;
    private Symbol symbol;
    private boolean isArtificial;
    private final UserInteraction userInteraction = new UserInteraction();

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

    private int getColumnMove(int max) {
        View.displayLine("Select a column to target:");
        return userInteraction.getIntChoice(1, max);
    }

    private int getRowMove(int max) {
        View.displayLine("Select a row to target:");
        return userInteraction.getIntChoice(1, max);
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

    public int getPlayerMoveForConnect4(int amountOfColumns) {
        if (isArtificial) {
            Random randomizer = new Random();
            return randomizer.nextInt(amountOfColumns);
        } else {
            return getColumnMove(amountOfColumns) - 1;
        }
    }
    public int[] getPlayerMove(int size) {
        int[] playerMove = new int[2];
        playerMove[0] = getRowMove(size) - 1;
        playerMove[1] = getColumnMove(size) - 1;

        return playerMove;
    }

    public void playerTurn() {
    }
}
