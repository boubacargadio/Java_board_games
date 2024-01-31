package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.GameIdentity;

import java.util.Scanner;


public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    public int getGameChoice() {
        GameIdentity[] gamesList = GameIdentity.values();

        System.out.println("Welcome to our boardgames platform. Which game do you want to play?");
        for (int i = 0; i < gamesList.length ; i++) {
            System.out.println("Press " + gamesList[i].ordinal() + " to play " + gamesList[i].getName());
        }

        return Integer.parseInt(scanner.nextLine());
    }
}
