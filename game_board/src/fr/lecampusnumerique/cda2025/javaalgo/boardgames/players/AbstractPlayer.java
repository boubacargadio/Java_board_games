package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.Game;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.Games;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;

public abstract class AbstractPlayer implements Player {
    private int number;
    private Symbols symbol;
    private boolean isArtificial;

    public AbstractPlayer(int number, Symbols symbol, boolean isArtificial) {
        this.number = number;
        this.symbol = symbol;
        this.isArtificial = isArtificial;
    }

    // **
    // *****
    // ********* METHODS
    // *****
    // **

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Symbols getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }

    public boolean isArtificial() {
        return isArtificial;
    }

    public void setArtificial(boolean artificial) {
        isArtificial = artificial;
    }

    public String getRepresentation() {
        return getSymbol().getRepresentation();
    }

    public int[] getPlayerMove(int[] move) {
        return move;
    }
}
