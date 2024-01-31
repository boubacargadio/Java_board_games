package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.TicTacToeSymbol;

public class TicTacToeGame extends AbstractGame {

    public TicTacToeGame() {
        super(GameIdentity.TICTACTOE, 3, 3);
    }

    @Override
    void defineSymbols() {
        Symbol[] ticTacToeSymbols = new Symbol[]{TicTacToeSymbol.X, TicTacToeSymbol.O};
        setSymbols(ticTacToeSymbols);
    }

}

