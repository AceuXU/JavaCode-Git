import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        // Hashtable = A data structure that stores unique keys to values ex.<Integer, String>

        // Each key/value pair is known as an Entry
        // FAST insertion, look up, deletion of key/value pairs
        // Not ideal for small data sets, great with large data sets

        // hashing = Takes a key and computes an integer (formula will vary based on key & data type)

        // In a Hashtable, we use the hash % capacity to calculate an index number
        // key.hashCode() % capacity = index

        // bucket = an indexed storage location for one or more Entries
        // can store multiple Entries in case of a collision (linked similarly a LinkedList)

        // collision = hash function generates the same index for more than one key
        //less collisions = more efficiency

        // Runtime complexity: Best Case O(1)
        // Worst Case O(n)


        Hashtable<String , String> table = new Hashtable<>(40, 0.5f);

        table.put("100", "Batman");
        table.put("150", "SpiderMan");
        table.put("123", "IronMan");
        table.put("621", "Hulk");
        table.put("342", "Thanos");
        table.put("774", "Thor");

//        table.remove(753);

        for (String key : table.keySet()){
            System.out.println(key.hashCode() % 10 + " "  + key + " " + table.get(key));

            // different data types will have diff hash formula.

        }
    }
}
