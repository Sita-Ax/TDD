package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.Optional;

//if there is a user return it
@Component
public class UserRepository {
    Optional<User> findUserByUsername(String username) {
        return Optional.empty();
    }
}
