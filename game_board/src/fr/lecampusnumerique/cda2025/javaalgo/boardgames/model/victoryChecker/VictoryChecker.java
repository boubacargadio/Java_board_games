package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.victoryChecker;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.EmptySymbol;

import java.util.Objects;

public class VictoryChecker implements Victory {
    private final int victorySize;
    private String winningSymbol;

    public VictoryChecker(int victorySize) {
        this.victorySize = victorySize;
    }

    // *****
    // ************ METHODS
    // *****

    public String getWinningSymbol() {
        return winningSymbol;
    }

    public void setWinningSymbol(String winningSymbol) {
        this.winningSymbol = winningSymbol;
    }

    private boolean setIsVictory(boolean areSymbolsEqual, String currentSymbol) {
        boolean isEmpty = Objects.equals(currentSymbol, EmptySymbol.EMPTY.getRepresentation());
        if (areSymbolsEqual && !isEmpty) {
            setWinningSymbol(currentSymbol);
            return true;
        }
        return false;
    }

    private boolean lineCheck(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String currentSymbol = board[a][b].getSymbol().getRepresentation();
        if (b + victorySize <= board[a].length) {
            for (int c = 0; c < victorySize; c++) {
                if (!Objects.equals(board[a][b + c].getSymbol().getRepresentation(), currentSymbol)) {
                    areSymbolsEqual = false;
                }
            }
            return setIsVictory(areSymbolsEqual, currentSymbol);
        }
        return false;
    }

    private boolean columnCheck(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String currentSymbol = board[a][b].getSymbol().getRepresentation();
        if (a + victorySize <= board.length) {
            for (int c = 0; c < victorySize; c++) {
                if (!Objects.equals(board[a + c][b].getSymbol().getRepresentation(), currentSymbol)) {
                    areSymbolsEqual = false;
                }
            }
            return setIsVictory(areSymbolsEqual, currentSymbol);
        }
        return false;
    }

    private boolean diagonal1Check(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String currentSymbol = board[a][b].getSymbol().getRepresentation();
        if (b + victorySize <= board[a].length &&
                a + victorySize <= board.length) {

            for (int c = 0; c < victorySize; c++) {
                if (!Objects.equals(board[a + c][b + c].getSymbol().getRepresentation(), currentSymbol)) {
                    areSymbolsEqual = false;
                }
            }
            return setIsVictory(areSymbolsEqual, currentSymbol);
        }
        return false;
    }

    private boolean diagonal2Check(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String currentSymbol = board[a][b].getSymbol().getRepresentation();

        if (b + victorySize <= board[a].length &&
                a - victorySize >= -1) {

            for (int c = 0; c < victorySize; c++) {
                if (!Objects.equals(board[a - c][b + c].getSymbol().getRepresentation(), currentSymbol)) {
                    areSymbolsEqual = false;
                }
            }
            return setIsVictory(areSymbolsEqual, currentSymbol);
        }
        return false;
    }

    /**
     * Check if the player won after his move
     * @param board is the current board after player move
     * @return if victory or not
     */
    public boolean isVictory(Cell[][] board) {
        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board.length; b++) { //for every cell
                if (lineCheck(a, b, board)) {
                    return true;
                }
                if (columnCheck(a, b, board)) {
                    return true;
                }
                if (diagonal1Check(a, b, board)) {
                    return true;
                }
                if (diagonal2Check(a, b, board)) {
                    return true;
                }
            }
        }
        return false;
    }
}

