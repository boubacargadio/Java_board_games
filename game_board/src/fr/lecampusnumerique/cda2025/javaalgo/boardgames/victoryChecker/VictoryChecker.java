package fr.lecampusnumerique.cda2025.javaalgo.boardgames.victoryChecker;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.board.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.EmptySymbol;

public class VictoryChecker implements Victory {
    private boolean isVictory = false;
    private final int checkSize;


    public VictoryChecker(int checkSize) {
        this.checkSize = checkSize;
    }

    public boolean getIsVictory() {
        return isVictory;
    }

    private void setIsVictory(boolean victory) {
        isVictory = victory;
    }

    // *****
    // ************ METHODS
    // *****

    private boolean isOver_util(boolean same, String curStr) {
        if (same && curStr != EmptySymbol.EMPTY.getRepresentation()) {
//            if (curStr.equals(player1.getRepresentation())) {
//               // display();
//                // view.println("Joueur 1 a gagné!");
//                return true;
//            } else if (curStr.equals(player2.getRepresentation())) {
//               // display();
//                // view.println("Joueur 2 a gagné!");
//                return true;
//            }
            return true;
        }
        return false;
    }

    private boolean lineCheck(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (b + checkSize <= board[a].length) {
            for (int c = 0; c < checkSize; c++) {
                if (board[a][b + c].getSymbol().getRepresentation() != curStr) {
                    areSymbolsEqual = false;
                }
            }
        }
        return isOver_util(areSymbolsEqual, curStr);
    }

    private boolean columnCheck(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (a + checkSize <= board.length) {
            for (int c = 0; c < checkSize; c++) {
                if (board[a + c][b].getSymbol().getRepresentation() != curStr) {
                    areSymbolsEqual = false;
                }
            }
        }
        return isOver_util(areSymbolsEqual, curStr);
    }

    private boolean diagonal1Check(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (b + checkSize <= board[a].length &&
                a + checkSize <= board.length) {

            for (int c = 0; c < checkSize; c++) {
                if (board[a + c][b + c].getSymbol().getRepresentation() != curStr) {
                    areSymbolsEqual = false;
                }
            }
        }
        return isOver_util(areSymbolsEqual, curStr);
    }

    private boolean diagonal2Check(int a, int b, Cell[][] board) {
        boolean areSymbolsEqual = true;
        String curStr = board[a][b].getSymbol().getRepresentation();
        if (b + checkSize <= board[a].length &&
                a - checkSize >= -1) {

            for (int c = 0; c < checkSize; c++) {
                if (board[a - c][b + c].getSymbol().getRepresentation() != curStr) {
                    areSymbolsEqual = false;
                }
            }
        }
        return isOver_util(areSymbolsEqual, curStr);
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

