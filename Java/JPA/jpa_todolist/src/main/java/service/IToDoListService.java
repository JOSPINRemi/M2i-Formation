package service;

import entity.ToDo;
import entity.ToDoInfos;
import entity.ToDoStatus;

import java.sql.Date;
import java.util.List;

public interface IToDoListService {
    public ToDo createAndSaveToDo(String label, ToDoStatus status, ToDoInfos infos);
    public List<ToDo> readToDos();
    public ToDo readToDo(Long id);
    public  boolean updateToDo(ToDo toDo);
    public  boolean deleteToDo(Long id);

    public ToDoInfos createAndSaveToDoInfos(String description, Date echeance, Integer priorite);
}
