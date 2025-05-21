package com.example.demo.controller;

import dto.HelloRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/public/hello")
    public ResponseEntity<String> getPublicGreetings() {
        return ResponseEntity.ok("Hello from a public endpoint!");
    }

    @GetMapping("/protected/hello")
    public ResponseEntity<String> getProtectedGreetings() {
        return ResponseEntity.ok("Hello from a protected endpoint!");
    }

    @PostMapping("/protected/hello")
    public ResponseEntity<String> postProtectedGreetings(@Valid @RequestBody HelloRequest request) {
        return ResponseEntity.ok(String.format("Hello %s, from a protected endpoint!", request.name()));
    }

}
