package com.desire323.authentiacation.controller;

import com.desire323.authentiacation.service.AuthenticationService;
import com.desire323.authentiacation.DTO.AuthenticationDTO;
import com.desire323.authentiacation.DTO.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationDTO request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping("/register")
    public ResponseEntity<String> showRegistrationPage() {
        return ResponseEntity.ok("Registration page");
    }

    @GetMapping("/login")
    public ResponseEntity<String> showLoginPage() {
        return ResponseEntity.ok("Login page");
    }
}