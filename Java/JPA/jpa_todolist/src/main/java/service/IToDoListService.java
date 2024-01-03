package service;

import entity.ToDo;
import entity.ToDoStatus;

import java.util.List;

public interface IToDoListService {
    public ToDo createAndSaveToDo(String label, ToDoStatus status);
    public List<ToDo> readToDos();
    public ToDo readToDo(Long id);
    public  boolean updateToDo(ToDo toDo);
    public  boolean deleteToDo(Long id);
}
