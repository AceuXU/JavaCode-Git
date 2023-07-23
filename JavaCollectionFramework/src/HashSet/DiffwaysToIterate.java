package HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DiffwaysToIterate {
    public static void main(String[] args) {
        Set<String> superCars = new HashSet<>();
        superCars.add("BMW");
        superCars.add("Audi");
        superCars.add("Buggati");

        // Enhanced for loop
        for (String cars : superCars){
            System.out.println(cars);
        }

        // Basic loop with iterator
        for (Iterator iterator = superCars.iterator(); iterator.hasNext();){
            String cars = (String) iterator.next();
//            System.out.println(cars);
        }

        // while loop with iterator
//        Iterator<String > iterator = superCars.iterator();
//        while (iterator.hasNext()){
//            String cars = (String) iterator.next();
//            System.out.println(cars);
//        }

        // JDK 8 for each
        superCars.forEach(cars -> System.out.println(cars));

    }
}
