package fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols;

public enum Connect4Symbol implements Symbols {
    EMPTY(""),
    RED("R"),
    YELLOW("Y");

    private String representation;
    @Override
    public String getRepresentation() {
        return representation;
    }

    Connect4Symbol(String representation) { this.representation = representation;}
}
