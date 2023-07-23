package HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashsetExample {
    public static void main(String[] args) {
        Set<String > proglang = new HashSet<>();
        proglang.add("java");
        proglang.add("c++");
        proglang.add("python");
        proglang.add("JS");

        System.out.println(proglang);
    }
}
