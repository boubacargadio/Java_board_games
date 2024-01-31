package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Connect4Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.GomokuSymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbol;

public class Connect4Game extends AbstractGame {
    public Connect4Game() {
        super(GameName.CONNECT4, 6, 7);
    }

    @Override
    void defineSymbols() {
        Symbol[] connectSymbols = new Symbol[]{Connect4Symbol.R, Connect4Symbol.Y};
        setSymbols(connectSymbols);
    }
}
