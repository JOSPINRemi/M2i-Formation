package org.example.demo_form.controller;


import org.example.demo_form.model.Rabbit;
import org.example.demo_form.service.RabbitService;
import lombok.RequiredArgsConstructor;
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
    public List<Rabbit> getAllRabbit(){
        return rabbitService.getRabbits();
    }


}
