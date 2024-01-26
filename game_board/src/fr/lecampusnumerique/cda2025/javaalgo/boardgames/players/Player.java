package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbol;

public interface Player {

    void setNumber(int number);

    Symbol getSymbol();

    void setSymbol(Symbol symbol);

    boolean isArtificial();

    void setArtificial(boolean artificial);

    String getRepresentation();

    int[] getPlayerMove();
    void PlayerTurn();
}
