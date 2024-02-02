package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.GameIdentity;

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

    public int askPlayerForMove(String move){
        boolean running = true;
        int answer = 0;
        do {
            System.out.println("Enter a " + move);
            try {
                answer = Integer.parseInt(scanner.next());
                System.out.println(move + " is: " + answer);
                running = false;
            } catch (Exception e) {
                System.out.println("Entry a number!");
                continue;
            }
        } while (running);
        return answer;
    }

}
