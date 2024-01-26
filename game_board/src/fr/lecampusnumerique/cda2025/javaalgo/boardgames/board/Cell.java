package fr.lecampusnumerique.cda2025.javaalgo.boardgames.board;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.EmptySymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;

public class Cell {
    private Symbols symbol;
    protected Cell() {
        this.symbol = EmptySymbol.EMPTY;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbols symbol) {
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
