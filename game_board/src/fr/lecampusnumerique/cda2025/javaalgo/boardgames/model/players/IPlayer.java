package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;

public interface IPlayer {

    void setNumber(int number);

    Symbol getSymbol();

    void setSymbol(Symbol symbol);

    boolean isArtificial();

    void setArtificial(boolean artificial);

    String getRepresentation();

    int[] getPlayerMove(int max);
    void playerTurn();
}
