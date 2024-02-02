package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.EmptySymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;

public class Cell {
    private Symbol symbol;
    public Cell() {
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
