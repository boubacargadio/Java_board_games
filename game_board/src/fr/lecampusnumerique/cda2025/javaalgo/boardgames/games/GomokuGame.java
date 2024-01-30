package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.GomokuSymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.TicTacToeSymbol;

public class GomokuGame extends AbstractGame {
    public GomokuGame() {
        super(15, 15);
    }

    @Override
    void defineSymbols() {
        Symbol[] gomokuSymbols = new Symbol[]{GomokuSymbol.B, GomokuSymbol.N};
        setSymbols(gomokuSymbols);
    }
}
