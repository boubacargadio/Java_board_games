package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.victoryChecker;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.EmptySymbol;

import java.util.Objects;

public class VictoryChecker implements Victory {
    private int checkSize = 0;
    private String winningSymbol;

    // *****
    // ************ METHODS
    // *****

    public void setCheckSize(int size) {
        checkSize = size;
    }

    public String getWinner() {
        return winningSymbol;
    }

    public void setWinner(String winningSymbol) {
        this.winningSymbol = winningSymbol;
    }

    private boolean isOver_util(boolean same, String currentSymbol) {
        if (same && !Objects.equals(currentSymbol, EmptySymbol.EMPTY.getRepresentation())) {
            setWinner(currentSymbol);
            return true;
        }
        return false;
    }

    private boolean lineCheck(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (b + checkSize <= board[a].length) {
            for (int c = 0; c < checkSize; c++) {
                if (!Objects.equals(board[a][b + c].getSymbol().getRepresentation(), curStr)) {
                    areSymbolsEqual = false;
                }
            }
            return isOver_util(areSymbolsEqual, curStr);
        }
        return false;
    }

    private boolean columnCheck(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (a + checkSize <= board.length) {
            for (int c = 0; c < checkSize; c++) {
                if (!Objects.equals(board[a + c][b].getSymbol().getRepresentation(), curStr)) {
                    areSymbolsEqual = false;
                }
            }
            return isOver_util(areSymbolsEqual, curStr);
        }
        return false;
    }

    private boolean diagonal1Check(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (b + checkSize <= board[a].length &&
                a + checkSize <= board.length) {

            for (int c = 0; c < checkSize; c++) {
                if (!Objects.equals(board[a + c][b + c].getSymbol().getRepresentation(), curStr)) {
                    areSymbolsEqual = false;
                }
            }
            return isOver_util(areSymbolsEqual, curStr);
        }
        return false;
    }

    private boolean diagonal2Check(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();

        if (b + checkSize <= board[a].length &&
                a - checkSize >= -1) {

            for (int c = 0; c < checkSize; c++) {
                if (!Objects.equals(board[a - c][b + c].getSymbol().getRepresentation(), curStr)) {
                    areSymbolsEqual = false;
                }
            }
            return isOver_util(areSymbolsEqual, curStr);
        }
        return false;
    }

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

