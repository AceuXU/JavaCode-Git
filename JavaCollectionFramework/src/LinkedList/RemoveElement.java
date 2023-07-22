package LinkedList;

// How to remove first element in LinkedList
// How to remove last element in LinkedLIst
// How to remove fist occurrence of a given element in the LinkedList
// How to clear the LinkedList completely

import java.io.LineNumberReader;
import java.util.LinkedList;

public class RemoveElement {
    public static void main(String[] args) {

        LinkedList<String> fruitList = new LinkedList<>();
        fruitList.add("Apple");
        fruitList.add("Banana");
        fruitList.add("Watermelon");
        fruitList.add("Orange");

        // Remove the first element in LinkedList

        String firstElement = fruitList.removeFirst();

        // Remove the last element in LinkedList

        String lastElement = fruitList.removeLast();

        // Remove at first occurrence
        fruitList.remove("Watermelon");

//        System.out.println(fruitList);

        // Remove all element from the LinkedList

        fruitList.clear();

//        System.out.println(fruitList);

    }
}
