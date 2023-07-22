package LinkedList;

// How to get first element in LinkedList
// How to get last element in LinkedList
// How to get element at given index in the LinkedList
// How to get all the elements from LinkedList

import java.util.LinkedList;

public class RetrieveElement {
    public static void main(String[] args) {

        LinkedList<String > fruit = new LinkedList<>();
        fruit.add("mango");
        fruit.add("Orange");
        fruit.add("Apple");

        // Getting the first element in the LinkedList
        String firstElement  = fruit.getFirst();

        // Getting last element in the LinkedList

        String  lastElement = fruit.getLast();

        // Getting element at given position

        String givenPosition = fruit.get(2);

        // to get all elements using forEach loop

        for (String fruits : fruit){
            System.out.println(fruits);
        }


    }
}
