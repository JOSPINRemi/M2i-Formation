package org.example.demo_aop.controller;

import org.example.demo_aop.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HomeController {
    private final DemoService demoService;

    public HomeController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo")
    public ResponseEntity<String> get() {
        /*System.out.println("--- Boolean ---");
        demoService.methodReturnBoolean();*/

        /*System.out.println("--- Void avec exception ---");
        demoService.method();*/

        demoService.methodWithAnnotation();

        return ResponseEntity.ok("ok");
    }
}
