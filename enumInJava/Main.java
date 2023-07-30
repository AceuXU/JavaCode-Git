package enumInJava;

enum Planet {
    MERCURY, VENUS, EARTH, MARS, JUPITER;
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
                break;
            default:
                System.out.println("You can't live here");
                break;

        }
    }

}
