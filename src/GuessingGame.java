/*
Java game "Guess a Number" that allows user to guess a random number that has been generated.

source: https://hackr.io/blog/java-projects
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame {
    private static final int MIN_VALUE = 1;
    private static final int EASY_UPPER_LIMIT = 50;
    private static final int HARD_UPPER_LIMIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your difficulty level (1: Easy, 2: Hard): ");
        int difficulty = getIntInput(scanner);

        int upperLimit;
        if (difficulty == 1) {
            upperLimit = EASY_UPPER_LIMIT;
        } else {
            upperLimit = HARD_UPPER_LIMIT;
        }

        int computerNumber = (int) (Math.random() * upperLimit + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        do {
            System.out.println("Enter a guess between " + MIN_VALUE + " and " + upperLimit + ": ");
            userAnswer = getIntInput(scanner);
            System.out.println(determineGuess(userAnswer, computerNumber, count));
            count++;
            if (count == 4) {
                if (computerNumber % 2 == 0) {
                    System.out.println("Hint: The number is even.");
                } else {
                    System.out.println("Hint: The number is odd.");
                }
            }
        } while (userAnswer != computerNumber);

        System.out.println("Congratulations! You guessed the correct number.");
        System.out.println("Total Guesses: " + count);
        
        scanner.close();
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer < MIN_VALUE || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!";
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        } else {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
    }

    private static int getIntInput(Scanner scanner) {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the input buffer
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;
    }
}
