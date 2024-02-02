package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.victoryChecker;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;

public interface Victory {
    boolean isVictory(Cell[][] board);
}
