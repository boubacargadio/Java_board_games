package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.AbstractCell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell.Cell;

public interface Board {
    // Ne contient que des méthodes dont on a besoin pour utiliser un board
    int getAmountOfColumns();
    int getAmountOfRows();
    void buildBoard();
    boolean isFull();
    void clean();
    AbstractCell[] getRow(int row);
    AbstractCell[]getColumn(int col);
}