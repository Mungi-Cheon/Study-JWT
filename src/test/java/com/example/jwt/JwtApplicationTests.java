package com.example.jwt;

import com.example.jwt.service.JwtService;
import java.time.LocalDateTime;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtApplicationTests {

    @Autowired
    private JwtService jwtService;

    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate() {
        var claims = new HashMap<String, Object>();
        claims.put("user_id", "923");
        var expiredAt = LocalDateTime.now().plusMinutes(10);
        var jwtToken = jwtService.create(claims, expiredAt);
        System.out.println(jwtToken);
    }

    @Test
    void tokenValidation() {
        var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiOTIzIiwiZXhwIjoxNzE2MTc1NTYwfQ.9ZIbmJ6sUTGiVkKvNsPLV5eIsxud553rE_sL7cprHw8";
        jwtService.validation(token);
    }

}
