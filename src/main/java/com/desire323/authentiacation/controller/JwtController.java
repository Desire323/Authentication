package com.desire323.authentiacation.controller;

import com.desire323.authentiacation.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtController {
    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/email/{token}")
    public ResponseEntity<String> extractEmail(@PathVariable("token") String token) {
        return ResponseEntity.ok(jwtService.extractUsername(token));
    }

}
