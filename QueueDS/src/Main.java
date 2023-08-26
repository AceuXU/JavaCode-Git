import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Queue = FIFO data structure. (ex. A line of people)
        // A collection designed for holding elements prior to processing
        // it is liner DS

        Queue<String> queue = new LinkedList<>();

        queue.offer("Aceu");
        queue.offer("Ratan");
        queue.offer("Giyu");
        queue.offer("Jojo");

//        System.out.println(queue.peek());  // to check element which is present at first place

//        queue.poll();  // to remove elements
//        queue.poll();

//        System.out.println(queue.isEmpty()); // to check if queue is empty
//        System.out.println(queue.size()); // to check size of queue
//        System.out.println(queue.contains("Jojo")); // to check element by putting name
//        System.out.println(queue);

        // use-case of queue

        // 1. Keyword Buffer (letters should appear on the screen in the order they're pressed)
        // 2. Printer Queue (Print jobs should be completed in order)
        // 3. Used in LinkedLists, PriorityQueues, BFS.


        // PriorityQueue ------------------------------------------------------------

        // the difference between normal queue and Priority queue is that it serves elements
        // with the highest priorities first
        // before elements with lower priority

        PriorityQueue<Double> queue2 = new PriorityQueue<>(Collections.reverseOrder());

        // to reverse elements we can use Collections.reverseOrder();

        queue2.offer(5.0);
        queue2.offer(4.5);
        queue2.offer(2.3);
        queue2.offer(7.5);

        while (!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }

    }
}
