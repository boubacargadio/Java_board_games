package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.*;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.GameFactory;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.View;

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
        GameIdentity[] gamesList = GameIdentity.values();

        View.displayChooseGame(gamesList);
        int playerSelection = userInteraction.getIntChoice(1, gamesList.length);

        setSelectedGame(findGame(playerSelection - 1));
        launchGame();
    }

    private void launchGame() {
        IGame game = GameFactory.createGame(selectedGame);
        game.play();
    }
}
