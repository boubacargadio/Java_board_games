package fr.lecampusnumerique.cda2025.javaalgo.boardgames.PlayerTurns;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.players.Player;

import java.util.Scanner;

public interface PlayerTurns {
    Player switchPlayer();

    boolean checkMove();
    boolean boardIsFull();

    Scanner getMove();
}
