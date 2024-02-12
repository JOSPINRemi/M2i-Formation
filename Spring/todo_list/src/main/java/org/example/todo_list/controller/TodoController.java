package org.example.todo_list.controller;

import org.example.todo_list.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("/todo")
    public String getTodo(Model model){
        Todo todo = new Todo("test", "description", false);
        model.addAttribute("todo", todo);
        return "todo/details";
    }
}
