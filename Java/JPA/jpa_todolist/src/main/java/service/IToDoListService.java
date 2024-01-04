package service;

import entity.ToDo;
import entity.ToDoInfos;
import entity.ToDoStatus;
import entity.User;

import java.sql.Date;
import java.util.List;

public interface IToDoListService {
    ToDo createAndSaveToDo(String label, ToDoStatus status, ToDoInfos infos);
    List<ToDo> readToDos();
    ToDo readToDo(Long id);
    boolean updateToDo(ToDo toDo);
    boolean deleteToDo(Long id);

    ToDoInfos createAndSaveToDoInfos(String description, Date echeance, Integer priorite);

    User createAndSaveUser(String name, List<ToDo> toDos);
    List<User> readUsers();
    User readUser(Long id);
    boolean deleteUser(Long id);
}
