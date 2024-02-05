package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.*;

public class GameFactory {

    public static IGame createGame(GameIdentity gameIdentity) {
        return switch(gameIdentity) {
            case TICTACTOE -> new TicTacToeGame();
            case CONNECT4 -> new Connect4Game();
            case GOMOKU -> new GomokuGame();
        };
    }
}
