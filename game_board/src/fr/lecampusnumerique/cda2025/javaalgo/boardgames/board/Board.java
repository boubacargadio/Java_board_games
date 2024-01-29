package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

public class Board {

    // *******
    // ************* ATTRIBUTES
    // *******

    private final int amountOfRows;
    private final int amountOfColumns;
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

    public Board(int amountOfRows, int amountOfColumns) {
        this.amountOfColumns = amountOfColumns;
        this.amountOfRows = amountOfRows;
        this.board = new Cell[amountOfRows][amountOfColumns];
        createBoard();
        displayBoard();
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

    public void displayBoard() {
        String endRow = "|";
        StringBuilder horizontalBorder = new StringBuilder();
        horizontalBorder.append(" -----".repeat(amountOfColumns));

        System.out.println(horizontalBorder);

        for (Cell[] row : board) {
            for (Cell cell : row) {
                System.out.printf("|  " + cell.getSymbol().getRepresentation() + "  ");
            }
            System.out.printf(endRow);
            System.out.println();
            System.out.println(horizontalBorder);
        }
    }

    public Cell[] getRow(int row) {
        return board[row];
    }

    public Cell[] getColumn(int col) {
        Cell[] column = new Cell[amountOfRows];
        for (int i = 0; i < board.length ; i++) {
            column[i] = board[i][col];
        }

        return column;
    }

    public void clean() {
    }
}
