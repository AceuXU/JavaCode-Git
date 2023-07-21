package arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DiffWaysToIterate {
    public static void main(String[] args) {
        List<String> phones = Arrays.asList("Iphone", "Samsung", "Redmi", "Oppo");

        // for loop
//        for (int i= 0; i<phones.size(); i++){
//            System.out.println(phones.get(i));

        // Enhanced for loop
//        for (String mob : phones){
//            System.out.println(mob);
//        }


        // basic loop with iterator
//        for (Iterator iterator = phones.iterator(); iterator.hasNext();){
//            String mob = (String) iterator.next();
//            System.out.println(mob);
//        }

//         iterator with while loop
        Iterator iterator = phones.iterator();
        while (iterator.hasNext()){
            String mob = (String) iterator.next();
            System.out.println(mob);
        }

        // java 8 stream + lamda example
//        phones.stream().forEach(mob ->System.out.println(mob));

        // java 8 forEach + Lambda example
//        phones.forEach(mob ->System.out.println(mob));



        }

    }

