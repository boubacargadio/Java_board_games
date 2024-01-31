package fr.lecampusnumerique.cda2025.javaalgo.boardgames;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.*;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.UserInteraction;

public class BoardGames {
    private GameName selectedGame;

    private final UserInteraction userInteraction = new UserInteraction();

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
        Game currentGame = GameFactory.createGame(selectedGame);
        currentGame.play();
    }
}
