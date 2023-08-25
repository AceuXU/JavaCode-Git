import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // stack = LIFO data structure. Last-in first out.
        //  store's objects into a sort of "Vertical tower"
        // push(); to add elements to the top.
        // pop (); to remove elements from top

        Stack<String> stack = new Stack<>();

//        System.out.println(stack.empty());

        stack.push("VAlORANT");
        stack.push("GTA 5");
        stack.push("CS GO");
        stack.push("Rocket League");
        stack.push("FALL GUYS");

        // this will remove FALL GUYS
        String myFavGame = stack.pop(); // removed element from stack and assigned to myFavGame
        System.out.println(myFavGame);


        System.out.println(stack.peek()); // peek method is used to check item at top without removing it

        System.out.println(stack.search("GTA 5")); // to search an item in a stack by position

        for (int i = 0; i < 10000; i++) {
            stack.push("APEX LEGENDS");  // this will add 10k copies of apex legends in stack
        }

        System.out.println(stack);

        // uses of stack data structure
        // 1. undo/redo features
        // 2. moving back/forward through browser history
        // 3. backtracking algorithms (maze, file directories)
        // 4. calling functions (call stack)

    }
}
