package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players.Player;

public interface IGame {
    void play();
    void stop();
    void restart();
    void playerTurn(Player player);
    boolean isOver();
}
