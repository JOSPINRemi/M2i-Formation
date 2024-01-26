package org.example.dao;

import org.example.model.TodoItem;

import java.util.List;

public interface TodoDao {
    void addTodo(TodoItem todoItem);
    List<TodoItem> getAllTodos();
}
