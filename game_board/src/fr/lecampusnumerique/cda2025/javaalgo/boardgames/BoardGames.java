package fr.lecampusnumerique.cda2025.javaalgo.boardgames;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.*;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;

public class BoardGames {
    private GameName selectedGame;
    private Game currentGame;

    private UserInteraction userInteraction = new UserInteraction();

    public BoardGames() {
    }

    public GameName getSelectedGame() {
        return selectedGame;
    }

    private void setSelectedGame(GameName selectedGame) {
        this.selectedGame = selectedGame;
    }

    private GameName findGame(int number){
        for(GameName game : GameName.values()){
            if(game.ordinal() == number) {
                return game;
            }
        }
        return GameName.TICTACTOE;
    }
    public void selectGame() {
        int playerSelection = userInteraction.getGameChoice();
        setSelectedGame(findGame(playerSelection));

        System.out.println("Perfect! Let's play " + getSelectedGame().getName());

        launchGame();
    }

    private void launchGame() {

        switch(selectedGame) {
            case Games.TICTACTOE:
                TicTacToeGame ticTacToeGame = new TicTacToeGame();
                ticTacToeGame.play(selectedGame);
                break;
            case Games.GOMOKU:
                GomokuGame gomokuGame = new GomokuGame();
                gomokuGame.play(selectedGame);
                break;
            case Games.CONNECT4:
                Connect4Game connect4Game = new Connect4Game();
                connect4Game.play(selectedGame);
                break;
            default:
                System.out.println("invalid selection");
        }
    }
}
