package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

public interface IGame {
    //Players[] getPlayers[];

    void play();
    void stop();
    void restart();
    // void playerTurn();
    boolean isOver();
}
