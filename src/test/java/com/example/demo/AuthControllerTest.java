package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AuthControllerTest {

    //@Autowired makes the life easier and the springboot will take care of it
    @Autowired AuthController authController;

    String testToken;
    @BeforeEach
    void setUp() {
        testToken = UUID.randomUUID().toString();
    }

    //with auth and login get me a token, get login in AuthController alt+enter
    @Test
    void name() {
        String token = authController.login("Arne","Looser");
        //imlementera
        assertEquals(testToken, token);
    }
}
