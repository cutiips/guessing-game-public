/*
Java game "Guess a Number" that allows user to guess a random number that has been generated.

source: https://hackr.io/blog/java-projects
*/

import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your difficulty level (1: Easy, 2: Hard): ");
        int difficulty = scanner.nextInt();

        int upperLimit;
        if (difficulty == 1) {
            upperLimit = 50;
        } else {
            upperLimit = 100;
        }

        int computerNumber = (int) (Math.random() * upperLimit + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        while (userAnswer != computerNumber) {
            System.out.println("Enter a guess between 1 and " + upperLimit + ": ");
            userAnswer = scanner.nextInt();
            System.out.println(determineGuess(userAnswer, computerNumber, count));
            count++;
            if (count == 4) {
                if (computerNumber % 2 == 0) {
                    System.out.println("Hint: The number is even.");
                } else {
                    System.out.println("Hint: The number is odd.");
                }
            }
        }

        scanner.close();
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count) {
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        } else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}