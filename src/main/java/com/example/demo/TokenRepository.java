package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface TokenRepository {

    Object createToken();
}
