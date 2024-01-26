package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.AbstractCell;

public interface Board {
    int getAmountOfColumns();
    int getAmountOfRows();
    void buildBoard();
    boolean isFull();
    void clean();
    AbstractCell[] getRow(int row);
    AbstractCell[]getColumn(int col);
}