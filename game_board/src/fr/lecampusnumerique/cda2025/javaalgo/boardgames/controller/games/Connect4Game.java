package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Connect4Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;

public class Connect4Game extends AbstractGame {
    public Connect4Game() {
        super(GameIdentity.CONNECT4, 6, 7, 4);
    }

    @Override
    void defineSymbols() {
        Symbol[] connectSymbols = new Symbol[]{Connect4Symbol.R, Connect4Symbol.Y};
        setSymbols(connectSymbols);
    }
}
