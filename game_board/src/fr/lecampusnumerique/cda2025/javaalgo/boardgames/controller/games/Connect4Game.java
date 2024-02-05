package fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.board.Board;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.cell.Cell;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.model.players.Player;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.view.View;

public class Connect4Game extends AbstractGame {

    Board board = getBoard();
    private final View view = new View();

    public Connect4Game() {
        super(GameIdentity.CONNECT4, GameIdentity.CONNECT4.getSize()-1, GameIdentity.CONNECT4.getSize());
    }

    private int setRowConnect4(int col) {
        Cell[][] board = this.board.getBoard();

        for (int row = board.length - 1; row >= 0; row--) {
            Cell cell = board[row][col];
            if (cell.isAvailable()) {
                return row;
            }
        }
        return -1;
    }

    @Override
    public void playerTurn(Player player) {
        boolean running = true;
        int[] move = new int[2];
        int amountOfColumns = board.getAmountOfColumns();

        while (running) {
            view.displayNewTurn(player);

            int col = player.getPlayerMoveForConnect4(amountOfColumns);
            int row = setRowConnect4(col);

            if (row == -1) {
              view.displayColumnIsFull();
            } else {
                move[0] = row;
                move[1] = col;
                running = false;
            }
        }
        Cell cell = board.getBoard()[move[0]][move[1]];
        cell.setSymbol(player.getSymbol());
    }

}
