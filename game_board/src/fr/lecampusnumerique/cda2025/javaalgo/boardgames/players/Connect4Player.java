package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Connect4Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.TicTacToeSymbol;

public class Connect4Player extends Player {

    public Connect4Player(int number, Connect4Symbol symbol, boolean isArtificial) {
        super(number, symbol, isArtificial);
    }

    public void connect4ToeSymbol(Connect4Symbol symbol) {
        super.setSymbol(symbol);
    }

}
