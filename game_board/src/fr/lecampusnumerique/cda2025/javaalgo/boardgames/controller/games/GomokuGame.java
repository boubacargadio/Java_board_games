package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.GomokuSymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;

public class GomokuGame extends AbstractGame {
    public GomokuGame() {
        super(GameIdentity.GOMOKU, 15, 15, 5);
    }

    @Override
    void defineSymbols() {
        Symbol[] gomokuSymbols = new Symbol[]{GomokuSymbol.B, GomokuSymbol.N};
        setSymbols(gomokuSymbols);
    }
}
