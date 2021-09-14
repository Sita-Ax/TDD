package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthControllerTest {

    //@Autowired makes the life easier and the springboot will take care of it

    @Autowired AuthController authController;

    //This makes to think like AuthService, but it is empty and not the real AuthService
    @MockBean AuthService authService;

    String testToken;
    @BeforeEach
    void setUp() {
        testToken = UUID.randomUUID().toString();
    }

    //with auth and login get me a token, get login in AuthController alt+enter
    //isolate this, because the mockBean is used
    @Test
    void name() {
        when(authService.login(anyString(), anyString())).thenReturn(testToken);
        String token = authController.login("Arne","Looser");
        //implementer ass
        assertEquals(testToken, token);
    }
}
