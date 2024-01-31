package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public class GameFactory {
    public static Game createGame(GameName gameName) {
        return switch(gameName) {
            case TICTACTOE -> new TicTacToeGame();
            case CONNECT4 -> new Connect4Game();
            case GOMOKU -> new GomokuGame();
        };
    }

    public static Game createGame(GameName gameName, int sizeGame) {
        return null;
    }
}
