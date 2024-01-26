package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public interface Game {
    //Players[] getPlayers[];
    boolean isOver();

    void play(Games game);
    void stop();
    void restart();
    void playRound();
    void PlayTurns();

}
