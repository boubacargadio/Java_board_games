package fr.lecampusnumerique.cda2025.javaalgo.boardgames.view;

import java.util.Scanner;


public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    // *************
    // ************* METHODS
    // *************

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
            } catch (NumberFormatException e) {
                System.out.println("Entry invalid, try again:");
            }
        }
        return result;
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
            }
        } while (running);
        return answer;
    }

}
