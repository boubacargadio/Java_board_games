package fr.lecampusnumerique.cda2025.javaalgo.boardgames;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.Games;

import java.util.Scanner;

public class BoardGames {
    private Games selectedGame;
    private final Games[] availableGames = new Games[]{Games.TICTACTOE, Games.CONNECT4, Games.GOMOKU};
    private final Scanner scanner = new Scanner(System.in);

    public BoardGames() {
    }

    public Games getSelectedGame() {
        return selectedGame;
    }

    private void setSelectedGame(Games selectedGame) {
        this.selectedGame = selectedGame;
    }

    public Games findGame(int number){
        for(Games game : Games.values()){
            if(game.ordinal() == number) {
                return game;
            }
        }
        return Games.TICTACTOE;
    }
    public Games selectGame() {
        System.out.println("Welcome to our boardgames platform. Which game do you want to play?");
        for (int i = 0; i < availableGames.length ; i++) {
            System.out.println("Press " + availableGames[i].ordinal() + " to play " + availableGames[i].getName());
        }

        int playerSelection = Integer.parseInt(scanner.nextLine());
        setSelectedGame(findGame(playerSelection));

        System.out.println("Perfect! Let's play " + getSelectedGame().getName());
        return findGame(playerSelection);
    }


}
