package com.example.demo;

import lombok.Value;

@Value(staticConstructor = "create")
public class User {
    String username;
    byte [] encryptedPassword;
}
