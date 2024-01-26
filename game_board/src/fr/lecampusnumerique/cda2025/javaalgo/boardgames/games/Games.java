package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public enum Games {
    TICTACTOE("Tic Tac Toe", "TicTacToeGame"),
    CONNECT4("Connect 4", "Connect4Game"),
    GOMOKU("Gomoku", "GomokuGame");
    
    private String name;
    private String className;

    public String getName() { return name;}
    public String getClassName() { return className;}

    Games(String name, String className) {
        this.name = name;
        this.className = className;
    }
}
