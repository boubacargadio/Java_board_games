package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.AbstractCell;

public abstract class AbstractBoard implements Board {

    // *******
    // ************* ATTRIBUTES
    // *******

    private final int amountOfRows;
    private final int amountOfColumns;
    private final AbstractCell[][] board;
    private boolean isFull;

    // *******
    // ************* CONSTRUCTOR
    // *******

    public AbstractBoard(int amountOfRows, int amountOfColumns) {
        this.amountOfColumns = amountOfColumns;
        this.amountOfRows = amountOfRows;
        this.board = new AbstractCell[amountOfRows][amountOfColumns];
    }

    // *******
    // ************* ATTRIBUTES METHODS
    // *******

    public int getAmountOfRows() {
        return amountOfRows;
    }

    public int getAmountOfColumns() {
        return amountOfColumns;
    }

    public AbstractCell[][] getBoard() {
        return board;
    }

    public boolean isFull() {
        return isFull;
    }

    protected boolean setIsFull(boolean isFull) {
        return this.isFull = isFull;
    }

    ;

    // *******
    // ************* METHODS
    // *******

    public void buildBoard() {
        System.out.println(" build board with " + amountOfColumns + " col");
        System.out.println(" build board with " + amountOfRows + " rows");
    }

    public AbstractCell[] getRow(int row) {
        return board[row];
    }

    public AbstractCell[] getColumn(int col) {
        return board[col];
    }

    public void clean() {
    }
}
