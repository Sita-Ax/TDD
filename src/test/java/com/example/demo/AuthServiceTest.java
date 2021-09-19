package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    AuthService authService;

    @MockBean TokenRepository tokenRepository;
    @MockBean UserRepository userRepository;

    String testToken;

    @BeforeEach
    void setUp() {
        testToken = UUID.randomUUID().toString();
    }

    @Test
    void test_login_success() throws AuthFailedException {
        when(tokenRepository.createToken()).thenReturn(testToken);
        String token = authService.login("Arne", "Looser");
        assertEquals(testToken, token);
    }

    @Test
    void test_login_failed_because_wrong_username() throws AuthFailedException {
        User user = User.create("", new byte[0]);
        when(userRepository.findUserByUsername(anyString())).thenReturn(Optional.empty());
//        when(tokenRepository.createToken()).thenReturn(testToken);
        //this is a fail Exception
        AuthFailedException authFailedException = assertThrows(AuthFailedException.class, () -> authService.login("Arne", "Looser"));
        String token = authService.login("Arne", "Looser");
        assertEquals(testToken, token);
    }
}
