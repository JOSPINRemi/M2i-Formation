import service.IToDoListService;
import service.ToDoListService;

public class Main {
    public static void main(String[] args) {
        IToDoListService toDoListService = new ToDoListService();
        String taskLabel = "test";
        System.out.println(toDoListService.createAndSaveToDo(taskLabel));
    }
}
