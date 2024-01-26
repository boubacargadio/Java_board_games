package fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols;

public enum GomokuSymbol implements Symbol {
    N("N"),
    B("B");

    private String representation;


    @Override
    public String getRepresentation() {
        return representation;
    }

    GomokuSymbol(String representation) {
        this.representation = representation;
    }
}
