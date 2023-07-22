package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

public class SearchAndIterateInLinkedList {
    public static void main(String[] args) {
        LinkedList<String> progLang = new LinkedList<>();

        progLang.add("Java");
        progLang.add("C++");
        progLang.add("Python");
        progLang.add(".Net");

        boolean result = progLang.contains("Java");
//        System.out.println(result);

        // How to find the index of firstOccurrence of an element in the LinkedList

        int index = progLang.indexOf("Python");
//        System.out.println(index);

        // How to find lastOccurrence of an element in LinkedList

        int lastIndex = progLang.lastIndexOf(".Net");
//        System.out.println(lastIndex);

        // to Iterate in linked list :
        // iterator

        Iterator<String> iterator = progLang.iterator();
        while (iterator.hasNext())
        {
            String prog = (String) iterator.next();
//            System.out.println(prog);
        }

        // forEach


        progLang.forEach((element) -> {
//            System.out.println(element);
        });


        // for each advanced Loop

        for (String e : progLang){
//            System.out.println(e);
        }

        // Simple for loop

        for (int i = 0; i<progLang.size(); i++){
//            System.out.println(progLang.get(i));


        }

    }
}
