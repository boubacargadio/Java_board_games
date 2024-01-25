package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

public abstract class Board implements Boards {
    private int amountOfColumns;
    private int amountOfRows;
    private boolean isFull;


    protected int getAmountOfColumns(int amountOfColumns){return this.amountOfColumns = amountOfColumns;};
    protected int getAmountOfRows(int amountOfRows){return this.amountOfRows = amountOfRows;};
    protected boolean setIsFull(boolean isFull){ return this.isFull = isFull;};
//    void clean(){};
//    String[] getRow(int row){};
//    String[] getColumn(int row){};
}

