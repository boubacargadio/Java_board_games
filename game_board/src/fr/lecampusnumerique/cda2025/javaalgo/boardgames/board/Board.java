package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.EmptySymbol;

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

    protected boolean isBoardFull(){
        boolean isFull = true;
       for (Cell[] row : board) {
           for (Cell cell: row) {
               if (cell.getSymbol() == EmptySymbol.EMPTY){
                   isFull = false;
               }
           }
       }
        setIsFull(isFull);
       return isFull;
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
        createBoard();
    }
}
