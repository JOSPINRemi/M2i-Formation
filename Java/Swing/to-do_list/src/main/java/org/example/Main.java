package org.example;

import org.example.component.TodoList;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoList todoList = new TodoList();
            todoList.setVisible(true);
        });
    }
}