package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.players.Player;

public abstract class AbstractGame implements Game {
    private Player[] playerList;
    private final Board board;
    private boolean isOver;

    public AbstractGame(int amountOfRows, int amountOfColumns) {
        this.board = new Board(amountOfRows, amountOfColumns);
    }

    protected boolean getIsOver() {
        return this.isOver;
    }

    protected void setIsOver(boolean isOver) {
        this.isOver = isOver;
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