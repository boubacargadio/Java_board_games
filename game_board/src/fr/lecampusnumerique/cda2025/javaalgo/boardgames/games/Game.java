package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public interface Game {
    //Players[] getPlayers[];
    boolean isOver();

    void play();
    void stop();
    void restart();
    void playRound();
    void PlayTurns();

}
