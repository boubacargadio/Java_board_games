package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols;

public enum Connect4Symbol implements Symbol {
    R("R"),
    Y("Y");

    private String representation;
    @Override
    public String getRepresentation() {
        return representation;
    }

    Connect4Symbol(String representation) { this.representation = representation;}
}
