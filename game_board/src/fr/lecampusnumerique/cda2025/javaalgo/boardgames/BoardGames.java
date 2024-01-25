package fr.lecampusnumerique.cda2025.javaalgo.boardgames;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.Games;

public class BoardGames {
    private Games selectedGame;

    public BoardGames(Games game) {
        this.selectedGame = game;
    }

    public Games getSelectedGame() {
        return selectedGame;
    }

    public void setSelectedGame(Games selectedGame) {
        this.selectedGame = selectedGame;
    }

    public void playBoardGames() {

    }


}
