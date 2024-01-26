package fr.lecampusnumerique.cda2025.javaalgo.boardgames.cell;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;

public class AbstractCell implements Cell {
    private Symbols symbol;

    protected AbstractCell(Symbols symbol) {
        this.symbol = symbol;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }

    public boolean isValueCompatible() {
        return false;
    }

    public boolean isAvailable() {
        return false;
    }
}
