package HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashsetFromCollection {
    public static void main(String[] args) {
        List<Integer> numbers= new ArrayList<>();  // HashSet with arraylist object
//        Set<Integer> numbers = new HashSet<>();
        numbers.add(7);
        numbers.add(2);
        numbers.add(3);

       //Set<Integer> numbers2 = new HashSet<>();

        //creating hashset from arraylist object

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(23);
        numbers2.add(55);

        // A HashSet from another collection using the HashSet() constructor
        numbers2.addAll(numbers);
        System.out.println(numbers2);


    }
}
