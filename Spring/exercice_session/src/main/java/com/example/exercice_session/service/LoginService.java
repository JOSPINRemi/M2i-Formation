package com.example.exercice_session.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final String USERNAME = "username";

    private final String PASSWORD = "password";

    @Autowired
    private HttpSession _httpSession;

    public boolean login(String username, String password) {
        if (username.equals(this.USERNAME) && password.equals(this.PASSWORD)) {
            _httpSession.setAttribute("login", "ok");
            return true;
        }
        return false;
    }

    public boolean isLogged() {
        try {
            String loginAttribute = _httpSession.getAttribute("login").toString();
            return loginAttribute.equals("ok");
        } catch (Exception e) {
            return false;
        }
    }

    public void logout(){
        _httpSession.removeAttribute("login");
    }
}
