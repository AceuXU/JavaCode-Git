public class GenericsClass <Thing extends Number, Thing2> {

    Thing x;
    Thing2 y;

    GenericsClass(Thing x, Thing2 y){
        this.x = x;
        this.y = y;
    }

    public Thing2 getValue() {
        return y;


    }
}
