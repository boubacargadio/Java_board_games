package fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols;

public enum GomokuSymbol implements Symbols {
    X("N"),
    O("B");

    private String representation;


    @Override
    public String getRepresentation() {
        return representation;
    }

    GomokuSymbol(String representation) {
        this.representation = representation;
    }
}
