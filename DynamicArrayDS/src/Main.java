import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray(5);

        dynamicArray.add("A");
        dynamicArray.add("B");
        dynamicArray.add("C");
        dynamicArray.add("D");
        dynamicArray.add("E");
        dynamicArray.add("G");

//        dynamicArray.delete("A"); // to shrink array to its original size.
//        dynamicArray.delete("B");
//        dynamicArray.delete("C");

//        dynamicArray.insert(0, "X");
//        dynamicArray.delete("A");
//        System.out.println( dynamicArray.search("C"));


//        System.out.println("empty: " + dynamicArray.isEmpty());
        System.out.println("size: " + dynamicArray.size);
        System.out.println("capacity: " + dynamicArray.capacity);
        System.out.println(dynamicArray);


    }
}
