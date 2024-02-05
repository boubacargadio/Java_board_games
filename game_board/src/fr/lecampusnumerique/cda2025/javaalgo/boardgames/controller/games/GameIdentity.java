package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Connect4Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.GomokuSymbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.Symbol;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.symbols.TicTacToeSymbol;

public enum GameIdentity {
    TICTACTOE("Tic Tac Toe", 3, 3, TicTacToeSymbol.O, TicTacToeSymbol.X),
    CONNECT4("Connect 4", 7, 4, Connect4Symbol.R, Connect4Symbol.Y),
    GOMOKU("Gomoku", 15, 5, GomokuSymbol.B, GomokuSymbol.N);
    
    private final String name;
    private final int size;
    private final int victorySize;
    private final Symbol symbol1;
    private final Symbol symbol2;

    public String getName() { return name;}
    public int getSize() { return size;}

    public int getVictorySize() {
        return victorySize;
    }

    public Symbol[] getSymbols() {
        return new Symbol[]{this.symbol1, this.symbol2};
    }

    GameIdentity(String name, int size, int victorySize, Symbol symbol1, Symbol symbol2) {
        this.name = name;
        this.size = size;
        this.victorySize = victorySize;
        this.symbol1 = symbol1;
        this.symbol2 = symbol2;
    }
}
