package com.example.otushw3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {
    @GetMapping
    public String hello() {
        return "Hello there!";
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "OK");
    }

    @GetMapping("/api/error")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void error() {
    }

}
