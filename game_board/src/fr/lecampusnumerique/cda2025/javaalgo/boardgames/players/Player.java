package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;

public interface Player {

    void setNumber(int number);

    Symbols getSymbol();

    void setSymbol(Symbols symbol);

    boolean isArtificial();

    void setArtificial(boolean artificial);

    String getRepresentation();

    int[] getPlayerMove(int[] move);
    void PlayerTurn();
}
