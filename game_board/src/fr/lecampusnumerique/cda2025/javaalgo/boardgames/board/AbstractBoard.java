package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.AbstractCell;

public abstract class AbstractBoard implements Board {

    // *******
    // ************* ATTRIBUTES
    // *******

    private int amountOfRows;
    private int amountOfColumns;
    private AbstractCell[][] board = new AbstractCell[amountOfRows][amountOfColumns];
    private boolean isFull;

    // *******
    // ************* CONSTRUCTOR
    // *******

    public AbstractBoard() {
        this.amountOfColumns = amountOfColumns;
        this.amountOfRows = amountOfRows;
        this.isFull = isFull;
        this.board = board;
    }

    // *******
    // ************* ATTRIBUTES METHODS
    // *******

    public int getAmountOfRows() {
        return amountOfRows;
    }

    public void setAmountOfRows(int amountOfRows) {
        this.amountOfRows = amountOfRows;
    }

    public int getAmountOfColumns() {
        return amountOfColumns;
    }

    public void setAmountOfColumns(int amountOfColumns) {
        this.amountOfColumns = amountOfColumns;
    }

    public AbstractCell[][] getBoard() {
        return board;
    }

    public void setBoard(AbstractCell[][] board) {
        this.board = board;
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
