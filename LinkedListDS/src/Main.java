import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.push("A"); // to push in stack
        linkedList.push("C");
        linkedList.push("B");

        linkedList.offer("UWU");

        linkedList.add(3, "U");
        linkedList.remove("U");

//        System.out.println(linkedList.indexOf("B")); // to check element's index
//        System.out.println(linkedList.peekFirst()); // to check first element
//        System.out.println(linkedList.peekLast()); // to check last element

        linkedList.addFirst("happy");
        linkedList.addLast("coding");

//        String first = linkedList.removeFirst();
//        String last = linkedList.removeLast();

//        linkedList.poll();
//        linkedList.pop();

        System.out.println(linkedList);

    }
}

// LinkedList =  Nodes are in 2 parts (data + address)
// Nodes are in non-consecutive memory locations Elements are linked using pointers

//    advantages:
//    1. Dynamic Data Structure (allocates needed memory while running)
//    2. Insertion and Deletion of Nodes is easy. O(1)
//    3. No/Low memory waste

//    disadvantages:
//    1. Greater memory usage (additional pointer)
//    2. No random access of elements (no index [i])
//    3. Accessing/searching elements is more time consuming. O(n)

//    uses:
//    1. implement Stacks/Queues
//    2. GPS navigation
//    3. music playlist

// small data LinkedList = BAD
//large data set + lots of searching: LinkedList = BAD
//large data set + lots of inserting/deleting: LinkedList = GOOD