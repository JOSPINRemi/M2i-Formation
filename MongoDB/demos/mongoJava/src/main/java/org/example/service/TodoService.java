package org.example.service;

import org.example.dao.TodoDao;
import org.example.model.TodoItem;

import java.util.List;

public class TodoService {
    private TodoDao _todoDao;

    public TodoService(TodoDao todoDao) {
        _todoDao = todoDao;
    }

    public void addTodo(TodoItem todoItem) {
        _todoDao.addTodo(todoItem);
    }

    public List<TodoItem> getAllTodos() {
        return _todoDao.getAllTodos();
    }
}
