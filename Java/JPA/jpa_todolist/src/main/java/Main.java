import service.ToDoListService;
import util.IHM;

public class Main {
    public static void main(String[] args) {
        new IHM(new ToDoListService()).start();
    }
}
