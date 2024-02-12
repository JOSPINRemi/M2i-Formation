package org.example.todo_list.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Todo {
    private String name;
    private String description;
    private boolean done;
}
