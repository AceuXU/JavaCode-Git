// Define a class called Car
class Car {
    // Attributes
    String make;
    String model;
    int year;

    // Methods
    void startEngine() {
        System.out.println("Engine started!");
    }

    void stopEngine() {
        System.out.println("Engine stopped!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an object of the Car class
        Car myCar = new Car();

        // Set attribute values
        myCar.make = "Toyota";
        myCar.model = "Camry";
        myCar.year = 2022;

        // Call methods on the object
        myCar.startEngine();
        myCar.stopEngine();
        System.out.println();
        System.out.print(myCar.make + " " + myCar.model + "-" + myCar.year);
    }
}