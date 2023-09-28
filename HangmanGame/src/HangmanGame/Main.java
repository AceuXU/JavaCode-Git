package HangmanGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GUi gUi;
        String[] wordList = {"Apple","MacBook","Ipad","Iphone",};
        String chosenWord = wordList[(int) (Math.random() * wordList.length)];
        StringBuilder currentWordState = new StringBuilder("_".repeat(chosenWord.length()));
        int maxAttempts = 5;
        int attemptsLeft = maxAttempts;

        // Created A Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to HangMan!");
        while (attemptsLeft > 0){
            System.out.println("CurrentWord" + currentWordState.toString());
            System.out.println("Attempts left" + attemptsLeft);
            System.out.println("Enter a letter");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            // check if the guessed letter is in the word
            boolean found = false;
            for (int i = 0; i < chosenWord.length(); i++){
                if (chosenWord.charAt(i) == guess){
                    currentWordState.setCharAt(i, guess);
                    found = true;
                }
            }
            if (!found){
                attemptsLeft--;
                System.out.println("Incorrect guess.");
            }
            if (currentWordState.toString().equals(chosenWord)){
                System.out.println("Congratulations! You're correct" + chosenWord);
                break;
            }
            if (attemptsLeft == 0){
                System.out.println("Sorry, you've run of attempts. The word was:" + chosenWord);
            }
        }
        scanner.close();
    }
}
