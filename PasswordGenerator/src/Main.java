import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Define character sets
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialSymbols = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        // Combine character sets into a master string
        String allCharacters = uppercaseLetters + lowercaseLetters + digits + specialSymbols;

        // Created a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        int passwordLength;

        // Prompt the user for password length with input validation
        while (true) {
            System.out.print("Enter the desired password (an integer): ");

            if (scanner.hasNextInt()) {
                passwordLength = scanner.nextInt();
                break; // Exit the loop if a valid integer is entered
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        // Generate and display the password
        String generatedPassword = generatePassword(passwordLength, allCharacters);
        System.out.println("Generated Password: " + generatedPassword);

        // Close the scanner
        scanner.close();

    }

    // Password generation method
    public static String generatePassword(int length, String characters) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
