package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

public class GomokuGame extends AbstractGame {
    public GomokuGame() {
        super(GameIdentity.GOMOKU, GameIdentity.GOMOKU.getSize(), GameIdentity.GOMOKU.getSize());
    }
}
