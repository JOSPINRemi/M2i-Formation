package com.example.exercice_session.controller;

import com.example.exercice_session.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping
    public String showForm() {
        return "authentication/form";
    }

    @PostMapping
    public String submitForm(@RequestParam String username, @RequestParam String password) {
        if (loginService.login(username, password)) {
            return "redirect:/home";
        }
        return "authentication/form";
    }

    @GetMapping("/home")
    public String homePage() {
        if (loginService.isLogged()) {
            return "home";
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        loginService.logout();
        return "redirect:/";
    }
}
