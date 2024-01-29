package fr.lecampusnumerique.cda2025.javaalgo.boardgames.players;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.symbols.Symbols;

import java.util.Scanner;

public abstract class AbstractPlayer implements Player {
    private int number;
    private Symbols symbol;
    private boolean isArtificial;

    Scanner scanner = new Scanner(System.in);

    public AbstractPlayer(int number, Symbols symbol, boolean isArtificial) {
        this.number = number;
        this.symbol = symbol;
        this.isArtificial = isArtificial;
    }

    // **
    // *****
    // ********* METHODS
    // *****
    // **

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Symbols getSymbol() {
        return this.symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }

    public boolean isArtificial() {
        return isArtificial;
    }

    public void setArtificial(boolean artificial) {
        isArtificial = artificial;
    }

    public String getRepresentation() {
        return getSymbol().getRepresentation();
    }

    private int getColumnMove() {
        do {
            System.out.println("Entrez une colonne :");
            try {
                return Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
        } while (true);
    }

    private int getRowMove() {
        do {
            System.out.println("Choisissez une ligne :");
            try {
                return Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
        } while (true);
    }


    public int[] getPlayerMove() {
        int[] playerMove = new int[]{};
                playerMove[0] = getColumnMove();
                playerMove[1] = getRowMove();

        return playerMove;
    }
    public void playerTurn(){}
}
