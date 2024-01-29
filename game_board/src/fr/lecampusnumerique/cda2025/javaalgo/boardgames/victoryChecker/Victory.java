package fr.lecampusnumerique.cda2025.javaalgo.boardgames.victoryChecker;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.board.Cell;

public interface Victory {
    boolean isVictory(Cell[][] board);
}
