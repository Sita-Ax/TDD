package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

//make a user
@RestController
public class AuthController {

    AuthService authService;

    //get Autowired in this
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public String login(String username, String password) {
        return authService.login(username, password);
    }
}
