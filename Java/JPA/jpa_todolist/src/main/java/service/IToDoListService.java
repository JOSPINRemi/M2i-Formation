package service;

import entity.ToDo;

public interface IToDoListService {
    public ToDo createAndSaveToDo(String label);
}
