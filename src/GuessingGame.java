/*
Java game “Guess a Number” that allows user to guess a random number that has been generated.

source: https://hackr.io/blog/java-projects
*/

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        while (userAnswer != computerNumber) {
            System.out.println("Enter a guess between 1 and 100: ");
            String response = System.console().readLine();
            userAnswer = Integer.parseInt(response);
            System.out.println(determineGuess(userAnswer, computerNumber, count));
            count++;
        }
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
