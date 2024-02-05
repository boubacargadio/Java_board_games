package fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols;

public enum TicTacToeSymbol implements Symbol {
    X("X"),
    O("O");

    private String representation;


    @Override
    public String getRepresentation() {
        return representation;
    }

    TicTacToeSymbol(String representation) { this.representation = representation;}
}
