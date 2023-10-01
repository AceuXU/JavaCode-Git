import com.sun.source.tree.BreakTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word or phrase");
        String input = scanner.nextLine().toLowerCase().replaceAll("[^a-z]", "");

        if (isPalinddrome(input)) {
            System.out.println("It's a palindrome");
        } else {
            System.out.println("Its not a palindrome");
        }
        scanner.close();
    }

    // Function to check if a string is a palindrome
    private static boolean isPalinddrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }
}

