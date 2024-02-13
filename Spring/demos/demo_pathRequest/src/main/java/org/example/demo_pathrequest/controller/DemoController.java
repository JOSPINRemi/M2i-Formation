package org.example.demo_pathrequest.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo_pathrequest.model.Rabbit;
import org.example.demo_pathrequest.service.RabbitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {
    private final RabbitService rabbitService;

    @GetMapping
    public String homePage(Model model){
        List<Rabbit> rabbits = rabbitService.getRabbits();
        model.addAttribute("lapins", rabbits);
        return "pagea";
    }

    @GetMapping("/pageb")
    public String pageb(Model model){
        List<Rabbit> rabbits = rabbitService.getRabbits();
        Rabbit rabbit = rabbits.get(0);
        model.addAttribute("idLapin", rabbit.getId());
        return "pageb";
    }

    @GetMapping("/detail/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId")UUID id, Model model){
        Rabbit rabbit = rabbitService.getRabbitById(id);
        model.addAttribute("monlapin", rabbit);
        return "pagec";
    }
}