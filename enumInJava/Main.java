package enumInJava;

enum Planet {
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5);

    int number;

    Planet(int number) {
        this.number = number;
    }
}

public class Main {
    public static void main(String[] args) {
        Planet myPlanet = Planet.EARTH;

        canILiveHere(myPlanet);
    }

    static void canILiveHere(Planet myPlanet) {
        switch (myPlanet) {
            case MARS:
                System.out.println("You can live here");
                System.out.println("This is plant # " + myPlanet.number);
                break;
            default:
                System.out.println("You can't live here");
                System.out.println("This is plant # " + myPlanet.number);
                break;

        }
    }

}
