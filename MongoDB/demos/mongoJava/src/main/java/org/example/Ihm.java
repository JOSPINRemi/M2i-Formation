package org.example;

import org.example.model.TodoItem;
import org.example.service.TodoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private TodoService todoService;
    private Scanner scanner;

    public Ihm(TodoService todoService) {
        this.todoService = todoService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        TodoItem todo = new TodoItem();
        todo.setTitle("Courrir");
        todo.setDescription("C'est chiant");
        todo.setCompleted(false);
        todoService.addTodo(todo);

        TodoItem todo1 = new TodoItem();
        todo.setTitle("Manger");
        todo.setDescription("C'est cool");
        todo.setCompleted(false);
        todoService.addTodo(todo1);

        List<TodoItem> itemList = todoService.getAllTodos();
        itemList.forEach(System.out::println);
    }
}
