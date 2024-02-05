package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.*;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.GameFactory;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;

public class BoardGames {
    private GameIdentity selectedGame;

    private final UserInteraction userInteraction = new UserInteraction();

    public BoardGames() {
    }

    private void setSelectedGame(GameIdentity selectedGame) {
        this.selectedGame = selectedGame;
    }

    private GameIdentity findGame(int number){
        for(GameIdentity game : GameIdentity.values()){
            if(game.ordinal() == number) {
                return game;
            }
        }
        return GameIdentity.TICTACTOE;
    }

    public void selectGame() {
        int playerSelection = userInteraction.getGameChoice();
        setSelectedGame(findGame(playerSelection));
        launchGame();
    }

    private void launchGame() {
        IGame game = GameFactory.createGame(selectedGame);
        game.play();
    }
}
