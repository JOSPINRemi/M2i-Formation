package org.example.demo_pathrequest.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo_pathrequest.model.Rabbit;
import org.example.demo_pathrequest.service.RabbitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {
    private final RabbitService rabbitService;

    @GetMapping
    public List<Rabbit> getAllRabbits(){
        return rabbitService.getRabbits();
    }
}
