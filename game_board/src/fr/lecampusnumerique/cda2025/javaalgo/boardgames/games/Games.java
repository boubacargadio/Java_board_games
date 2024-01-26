package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public enum Games {
    DEFAULT("Undefined"),
    TICTACTOE("Tic Tac Toe"),
    CONNECT4("Connect 4"),
    GOMOKU("Gomoku");
    
    private String name;

    public String getName() { return name;}

    Games(String name) {
        this.name = name;
    }
}
