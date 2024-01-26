package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public abstract class AbstractGame implements Game {
    public boolean isOver() {
        return false;
    }


    public void play(Games game) {
        System.out.println(" We are playing " + game.getName());
    }

    public void stop() {

    }

    public void restart() {

    }

    public void playRound() {

    }

    public void PlayTurns() {

    }
}