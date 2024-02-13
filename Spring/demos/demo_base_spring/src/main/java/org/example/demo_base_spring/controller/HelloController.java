package org.example.demo_base_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    @RequestMapping(value = "/")
    public String sayHello() {
        System.out.println("Coucou");
        return "hello";
    }

    @RequestMapping(value = "/coucou")
    @ResponseBody
    public List<String> getPersons() {
        return List.of(
                "John Doe",
                "Jane Doe",
                "Jonnie Doe",
                "Janie Doe",
                "Baby Doe"
        );
    }

    @RequestMapping(value = "toto")
    public String showToto() {
        return "toto";
    }

    @RequestMapping("/home/person")
    public String personName(Model model) {
        model.addAttribute("firstName", "John");
        model.addAttribute("lastName", "DOE");

        List<String> persons = List.of("John DOE", "Jane DOE", "Baby DOE");
//        List<String> persons = List.of();
        model.addAttribute("persons", persons);
        return "person/details";
    }
}
