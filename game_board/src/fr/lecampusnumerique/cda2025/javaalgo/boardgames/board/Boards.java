package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

public interface Boards {
    // Ne contient que des méthodes dont on a besoin pour utiliser un board
    int getAmountOfColumns();
    int getAmountOfRows();
    boolean isFull();
    void clean();
    String[] getRow(int row);
    String[] getColumn(int col);
}