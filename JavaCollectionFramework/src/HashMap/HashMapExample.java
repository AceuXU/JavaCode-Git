package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String , Integer > numbersMapping= new HashMap<>();

        numbersMapping.put("One" , 1);
        numbersMapping.put("Two" , 2);
        numbersMapping.put("Three" , 3);
        numbersMapping.put("Four" , 4);

        System.out.println(numbersMapping);

        // Check if HashMap is empty or not
//        System.out.println(numbersMapping.isEmpty());

        // find size of HashMap
//        System.out.println(numbersMapping.size());

        // Check if key exists in HashMap
        if (numbersMapping.containsKey("Four")){
            System.out.println("Exist");
        }else {
            System.out.println("Not exist");
        }

        // Check if value exists in HashMap
        if (numbersMapping.containsValue(4)){
            System.out.println("Value exits");
        } else {
            System.out.println("Value does not exist");
        }

        // get value by key
        Integer i = numbersMapping.get("One");
//        System.out.println(i);

        // how to remove key from hashmap
//        numbersMapping.remove("One");
//        System.out.println(numbersMapping);

        // get only keys from HashMap
//        System.out.println(numbersMapping.keySet());

        // to get values from HashMap
//        System.out.println(numbersMapping.values());

        // diff ways to iterate in HashMap

        // For each
        for (Map.Entry<String, Integer> entry : numbersMapping.entrySet()){
            System.out.println("key " +entry.getKey() + " value " + entry.getValue());
        }

        // using iterator
//        Set<Map.Entry<String , Integer>> entries = numbersMapping.entrySet();
//        Iterator<Map.Entry<String , Integer>> iterator = entries.iterator();
//        Map.Entry<String, Integer> entry = iterator.next();
//        System.out.println("key " + entry.getKey() + "value " + entry.getValue());

        // using for each (in java 8)
      numbersMapping.forEach((K, V) ->{
          System.out.println("K " + V);
          System.out.println("V " + V);
      });


    }
}
