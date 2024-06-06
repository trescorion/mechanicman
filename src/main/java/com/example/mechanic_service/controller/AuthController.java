package com.example.mechanic_service.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.mechanic_service.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Value("${app.security.username}")
    private String username;

    @Value("${app.security.password}")
    private String password;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
        if (username.equals(loginRequest.getUsername()) && password.equals(loginRequest.getPasswordHash())) {
            String token = JWT.create()
                    .withSubject(username)
                    .withExpiresAt(new Date(System.currentTimeMillis() + 864_000_000)) // 10 days
                    .sign(Algorithm.HMAC512(password.getBytes()));

            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
