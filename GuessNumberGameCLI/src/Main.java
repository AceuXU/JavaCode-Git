import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scanner = new Scanner(System.in);

        // Create a Random object to generate a random number.
        Random random = new Random();

        // Define the lower and upper bounds for the random number.
        int lowerBound = 1;
        int upperBound = 100;

        // Generate a random number between lowerBound and upperBound (inclusive).
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Initialize variables to keep track of game state.
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        // Display a welcome message.
        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I've selected a number between 1 and 100. Try to guess it.");

        // Main game loop continues until the user guesses correctly.
        while (!hasGuessedCorrectly) {
            // Prompt the user to enter a guess.
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++; // Increment the number of attempts.

            // Check if the user's guess is outside the valid range.
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Please enter a number between 1 and 100.");
            }
            // Check if the user's guess is too low.
            else if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            }
            // Check if the user's guess is too high.
            else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            }
            // If none of the above conditions are met, the user guessed correctly.
            else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number in " + numberOfAttempts + " attempts.");
            }
        }

        // Close the Scanner object to free up resources.
        scanner.close();
    }
}
