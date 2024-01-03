package service;

import dao.ToDoDAO;
import entity.ToDo;
import entity.ToDoStatus;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
    public ToDo createAndSaveToDo(String label, ToDoStatus status) {
        ToDo toDo = new ToDo(label, status);
        try {
            if (toDoDAO.save(toDo)) {
                return toDo;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<ToDo> readToDos() {
        try {
            return toDoDAO.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDo readToDo(Long id) {
        try {
            return toDoDAO.get(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateToDo(ToDo toDo) {
        try {
            return toDoDAO.update(toDo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteToDo(Long id) {
        try {
            return toDoDAO.remove(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
