package HashSet;

// to remove element from HashSet
// remove() to remove an element from a HashSet
// removeAll() to remove all the element from HashSet that exist in a given collection of HashSet.
// clear() to remove HashSet Completely by removing all the elements

import java.util.HashSet;
import java.util.Set;

public class HashSetHowToRemove {
    public static void main(String[] args) {

        Set<Integer> elements = new HashSet<>();
        elements.add(10);
        elements.add(30);
        elements.add(20);
        elements.add(40);

         boolean result = elements.remove(20);
        System.out.println(result);

        // using removeAll()

        Set<Integer> elements2 = new HashSet<>();
        elements2.add(100);
        elements2.add(200);

        boolean b = elements2.removeAll(elements2);
        System.out.println(b);

        // clear()
//        elements.clear();
//        System.out.println(elements);


    }
}
