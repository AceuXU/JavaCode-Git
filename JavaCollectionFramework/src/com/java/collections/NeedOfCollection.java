package com.java.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NeedOfCollection {
    public static void main(String[] args) {

        Collection<String > collection = new ArrayList<>();
        collection.add("Anushka");
        collection.add("Ratan");


        System.out.println(collection);

//        collection.forEach((element) -> {
//            System.out.println(element);
//        });

        ListDemo list = new ListDemo();
//        System.out.println(list.getList());


        }


    }


class ListDemo{
    List<String> list = new ArrayList<>();

    public List<String> getList() {
        // list can contain duplicate elements

        list.add("element1");
        list.add("element1");
        list.add("element2");
        list.add("element2");

        list.add(null);
        list.add(null);
        // list allows for null elements


        return list;




    }
}






