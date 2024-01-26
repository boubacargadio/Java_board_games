package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;

public class Board {

    // *******
    // ************* ATTRIBUTES
    // *******

    private final int amountOfRows;
    private final int amountOfColumns;
    private final Symbols[] symbols;
    private final Cell[][] board;
    private boolean isFull;

    private Cell[] getOneRow() {
        Cell[] row = new Cell[amountOfColumns];

        for (int i = 0; i < amountOfColumns; i++) {
            row[i] = new Cell();
        }
        return row;
    }

    private void createBoard() {
        for (int i = 0; i < amountOfRows; i++) {
            this.board[i] = getOneRow();
        }
    }


    // *******
    // ************* CONSTRUCTOR
    // *******

    public Board(Symbols[] symbols, int amountOfRows, int amountOfColumns) {
        this.amountOfColumns = amountOfColumns;
        this.amountOfRows = amountOfRows;
        this.symbols = symbols;
        this.board = new Cell[amountOfRows][amountOfColumns];
        createBoard();
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

    public Symbols[] getSymbols() {
        return symbols;
    }

    public Cell[][] getBoard() {
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

    public Cell[] getRow(int row) {
        return board[row];
    }

    public Cell[] getColumn(int col) {
        return board[col];
    }

    public void clean() {
    }
}
