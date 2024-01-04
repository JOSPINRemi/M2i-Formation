package service;

import dao.ToDoDAO;
import dao.ToDoInfosDAO;
import dao.UserDAO;
import entity.ToDo;
import entity.ToDoInfos;
import entity.ToDoStatus;
import entity.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.util.List;

public class ToDoListService implements IToDoListService {
    private EntityManagerFactory emf;
    private ToDoDAO toDoDAO;
    private ToDoInfosDAO toDoInfosDAO;
    private UserDAO userDAO;

    public ToDoListService() {
        try {
            emf = Persistence.createEntityManagerFactory("jpa_todolist");
            toDoDAO = new ToDoDAO(emf);
            toDoInfosDAO = new ToDoInfosDAO(emf);
            userDAO = new UserDAO(emf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ToDo createAndSaveToDo(String label, ToDoStatus status, ToDoInfos infos) {
        ToDo toDo = new ToDo(label, status);
        toDo.setInfos(infos);
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

    @Override
    public ToDoInfos createAndSaveToDoInfos(String description, Date echeance, Integer priorite) {
        ToDoInfos toDoInfos = new ToDoInfos();
        try {
            toDoInfos.setDescription(description);
            toDoInfos.setEcheance(echeance);
            toDoInfos.setPriorite(priorite);
            if (toDoInfosDAO.save(toDoInfos)){
                return toDoInfos;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public User createAndSaveUser(String name, List<ToDo> toDos) {
        User user = new User();
        user.setName(name);
        user.setToDos(toDos);
        try {
            if (userDAO.save(user)){
                return user;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> readUsers() {
        try {
            return userDAO.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User readUser(Long id) {
        try {
            return userDAO.get(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            return userDAO.remove(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
