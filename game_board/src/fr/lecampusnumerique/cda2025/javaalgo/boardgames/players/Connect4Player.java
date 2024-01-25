package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Connect4Symbol;

public class Connect4Player extends AbstractPlayer {

    public Connect4Player(int number, Connect4Symbol symbol, boolean isArtificial) {
        super(number, symbol, isArtificial);
    }

    public void connect4ToeSymbol(Connect4Symbol symbol) {
        super.setSymbol(symbol);
    }

}
