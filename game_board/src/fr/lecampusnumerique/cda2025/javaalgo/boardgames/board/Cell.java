package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.EmptySymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbol;

public class Cell {
    private Symbol symbol;
    protected Cell() {
        this.symbol = EmptySymbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    // *******
    // ************* OTHER METHODS
    // *******

    public boolean isValueCompatible() {
        return false;
    }

    public boolean isAvailable() {
        return false;
    }
}
