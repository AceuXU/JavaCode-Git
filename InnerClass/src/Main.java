public class Main {
    public static void main(String[] args) {
        /* inner class = class inside another class.
        useful if a class should be limited in scope
        usually private, but not necessary
        helps in group classes that belong together
        precursor for anonymous liner classes
         */

        Outside out = new Outside();
        Outside.Inside in = out.new Inside();

        System.out.println(out.x + " " + in.y);
        in.Greeting(); // by getting output by creating method in inside class
    }

}
