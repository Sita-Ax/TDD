package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

//make a user
@RestController
public class AuthController {

    AuthService authService;
    //get Autowired in this
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    //do log in here and test it in AuthControllerTest
    public ResponseEntity<String> login(String username, String password) {
        try {
            return ResponseEntity.ok(authService.login(username, password));
        }catch (Exception e){
            return ResponseEntity.status(401).build();
        }
    }
}
