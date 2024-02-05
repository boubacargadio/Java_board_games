package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.*;

public class GameFactory {

    public static IGame createGame(GameIdentity gameIdentity) {
        int size = gameIdentity.getSize();

        return switch(gameIdentity) {
            case TICTACTOE, GOMOKU -> new Game(gameIdentity, size, size);
            case CONNECT4 -> new Game(gameIdentity, size-1, size);
        };
    }
}
