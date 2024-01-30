package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public interface Game {
    //Players[] getPlayers[];

    void play(Games game);
    void stop();
    void restart();
    // void playerTurn();
    boolean isOver();
}
