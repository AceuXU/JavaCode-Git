import java.lang.reflect.Array;
import java.util.ArrayList;

public class TodoLogic {

    //Using ArrayList to Store the items which will be added in todoList.
    private ArrayList<String> tasks;

    public TodoLogic() {
        tasks = new ArrayList<>();

    }

    //Method to add a task to the list
    public void addTask(String task) {
        tasks.add(task);
    }

    //Method to edit a task at a specific index
    public void editTask(int index, String newTask){
        if (index >= 0 && index < tasks.size()){
            tasks.set(index, newTask);
        }
    }

    // method to delete a task at a specific index
    public void deleteTask(int index){
        if (index >= 0 && index < tasks.size()){
            tasks.remove(index);
        }
    }
    public ArrayList<String > getTasks(){
        return tasks;
    }
}
