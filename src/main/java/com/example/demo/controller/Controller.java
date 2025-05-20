package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
