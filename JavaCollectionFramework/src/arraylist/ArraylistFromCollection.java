package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArraylistFromCollection {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(7);
        integerList.add(9);

        List<Integer> integerList2 = new ArrayList<>(integerList);  // added arraylist parametersized consturctor

        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(13);
        integerList3.add(42);
        integerList3.add(31);
        integerList3.add(77);


        integerList2.addAll(integerList3);
        // CREATED ARRAYLIST USING ADD ON METHOD

        System.out.println(integerList2);


    }
}
