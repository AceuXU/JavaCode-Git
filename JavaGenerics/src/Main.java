import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // bounded types = you can create the objects of generic class to have data of specific derived types

        GenericsClass<Integer,Integer> intClass = new GenericsClass(1,4);
        GenericsClass<Double,Double> doubleClass = new GenericsClass<>(3.14, 32.3);
//        GenericsClass<Character, Character > charClass = new GenericsClass('A', 'R');
//        GenericsClass<String, String  > stringClass = new GenericsClass<>("Anushka", "Ratan");

        ArrayList<String > Friends = new ArrayList<>();

        System.out.println(intClass.getValue());
        System.out.println(doubleClass.getValue());
//        System.out.println(charClass.getValue());
//        System.out.println(stringClass.getValue());



    }
}
