package arraylist;

import java.util.*;

public class SortList {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(70);

//        Collections.sort(list);  // ascending order
//        System.out.println(list);
//        Collections.reverse(list); // descending order
//        System.out.println(list);


        List<CustomSort> customSorts = new ArrayList<>();
        customSorts.add(new CustomSort(10,"Harkirat",35,40000));
        customSorts.add(new CustomSort(10,"Aceu",21,772000));
        customSorts.add(new CustomSort(10,"harry",25,32000));
        customSorts.add(new CustomSort(10,"virat",35,230000));

//        Collections.sort(customSorts, new MySort()); //ascending order
//        System.out.println(customSorts);
//
//        Collections.sort(customSorts, new MySort()); //descending order
//        System.out.println(customSorts);

       // normal way

        Collections.sort(customSorts, new Comparator<CustomSort>() {
            @Override
            public int compare(CustomSort o1, CustomSort o2) {
                return (o1.getName().compareTo(o1.getName()));
            }
        });
        // for string
        Collections.sort(customSorts, ( o1,  o2) ->(o1.getName().compareTo(o2.getName())));
        System.out.println(customSorts);

   // lambda expression
//        Collections.sort(customSorts,((o1, o2) -> o2.getSalary() - o1.getSalary()));
//        System.out.println(customSorts);

    }
}
class MySort implements Comparator<CustomSort>{

    @Override
    public int compare(CustomSort o1, CustomSort o2) {
        return (int) o2.getSalary() - o1.getSalary();
    }
}
