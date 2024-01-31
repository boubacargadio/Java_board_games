package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public enum GameIdentity {
    TICTACTOE("Tic Tac Toe", 3),
    CONNECT4("Connect 4", 7),
    GOMOKU("Gomoku", 15);
    
    private final String name;
    private final int size;

    public String getName() { return name;}
    public int getSize() { return size;}

    GameIdentity(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
