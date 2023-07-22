package LinkedList;

// add()
// add(2, element)
// addFirst()
// add last()

import java.util.LinkedList;

public class linkedListExample {
    public static void main(String[] args) {
        LinkedList<String> fruit = new LinkedList<>();
        fruit.add("Banana");
        fruit.add("apple");

        // adding element at specified position in the linked list

        fruit.add(2,"Watermelon");
        System.out.println("after adding watermelon " + fruit);

        //adding element at beginning of linkedlist

        fruit.addFirst("Strawberry");

        // adding element at the end of the list

        fruit.addLast("Mango");


    }
}
