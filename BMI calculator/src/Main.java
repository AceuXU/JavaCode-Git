import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your weight (in kilogram): ");
        double weight = scanner.nextDouble();

        System.out.println("Enter you height (in meters): ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);

        System.out.println("Your BMI is : " + bmi);
        interpretBMI(bmi);

        scanner.close();
    }

    // function to calculate BMI
    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    // function to interpret BMI
    private static void interpretBMI(double bmi){
        if (bmi < 18.5) {
            System.out.println("You are underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Your weight is normal");
        } else if (bmi >= 24.9 && bmi < 29.9) {
            System.out.println("You are overweight");
        } else {
            System.out.println("You are fat");
        }

    }
}
