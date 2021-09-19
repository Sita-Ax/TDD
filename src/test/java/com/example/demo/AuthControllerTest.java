package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthControllerTest {

    //--ctrl + alt + L = create class ctrl + p = implMeth
    // --alt + insert = make a func
    // --ctrl + alt + L = Formatting
    //--alt + enter to make a method
    //@Autowired makes the life easier get server on a silver-plate and the springboot will take care of it
    @Autowired
    AuthController authController;

    //This makes to think like AuthService, but it is empty and not the real AuthService
    @MockBean
    AuthService authService;

    //return a string in test log in
    String testToken;

    //this is the one in @Test
    @BeforeEach
    void setUp() {
        testToken = UUID.randomUUID().toString();
    }

    //with auth and login get me a token, get login in AuthController alt+enter
    //isolate this, because the mockBean is used
    //this will log in success
    @Test
    void test_login_success() throws AuthFailedException{
        //Given -- get this
        when(authService.login(anyString(), anyString())).thenReturn(testToken);
        //When -- do this
        ResponseEntity<String> token = authController.login("Arne", "Looser");
        //implementer assertE --> then -- expect this -- crashed?
//        assertEquals(testToken, token.getBody());
//        assertEquals(0, token.getStatusCodeValue());  failed
        assertEquals(200, token.getStatusCodeValue());
        assertEquals(testToken, token.getBody());
    }

    //this will throw a fail 401
    @Test
    void test_login_failed() throws AuthFailedException {
        //Given -- get this
        when(authService.login(anyString(), anyString())).thenThrow(new AuthFailedException());
        //When -- do this
        ResponseEntity<String> token = authController.login("Arne", "Looser");
        //implementer assertE --> then -- expect this
        assertEquals(401, token.getStatusCodeValue());
        assertNull(token.getBody());
    }
}
