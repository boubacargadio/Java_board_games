package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.GameName;

import java.util.Scanner;


public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    public int getGameChoice() {
        GameName[] games = GameName.values();

        System.out.println("Welcome to our boardgames platform. Which game do you want to play?");
        for (int i = 0; i < games.length ; i++) {
            System.out.println("Press " + games[i].ordinal() + " to play " + games[i].getName());
        }

        return Integer.parseInt(scanner.nextLine());
    }
}
