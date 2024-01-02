package service;

import dao.ToDoDAO;
import entity.ToDo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ToDoListService implements IToDoListService {
    private EntityManagerFactory emf;
    private ToDoDAO toDoDAO;

    public ToDoListService() {
        try {
            emf = Persistence.createEntityManagerFactory("jpa_todolist");
            toDoDAO = new ToDoDAO(emf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDo createAndSaveToDo(String label) {
        ToDo toDo = new ToDo(label);
        try {
            if (toDoDAO.save(toDo)){
                return toDo;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
