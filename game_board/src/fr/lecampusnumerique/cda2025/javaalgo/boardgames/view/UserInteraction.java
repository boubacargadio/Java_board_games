package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.controller.games.GameIdentity;

import java.util.Scanner;


public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    // *************
    // ************* METHODS
    // *************

    private boolean isGameChoiceValid(int choice, int options) {
        return (choice <= options) && choice > 0;
    }

    private boolean isIntChoiceValid(int choice, int min, int max) {
        return (choice >= min) && (choice <= max);
    }

    public int getIntChoice(int min, int max) {
        boolean isRunning = true;
        int result = -1;

        while(isRunning){
            try {
                result = Integer.parseInt(scanner.next());

                if (isIntChoiceValid(result, min, max)) {
                    isRunning = false;
                } else {
                    System.out.println("You must choose a game between " + min + " and " + max);
                }

                isRunning = false;
            } catch (NumberFormatException e) {
                System.out.println("Entry invalid, try again:");
            }
        }
        return result;
    }

    public int getGameChoice() {
        GameIdentity[] gamesList = GameIdentity.values();
        boolean isRunning = true;
        int result = 0;

        System.out.println("Welcome to our boardgames platform. Which game do you want to play?");
        for (GameIdentity gameIdentity : gamesList) {
            int gameNumber = gameIdentity.ordinal() + 1;
            System.out.println("Press " + gameNumber + " to play " + gameIdentity.getName());
        }

        while (isRunning) {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if (isGameChoiceValid(result, gamesList.length)) {
                    isRunning = false;
                } else {
                    System.out.println("You must choose a game between 1 and " + gamesList.length);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entry invalid, try again:");
            }
        }
        return result - 1;
    }

    public int askPlayerForMove(String move) {
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
