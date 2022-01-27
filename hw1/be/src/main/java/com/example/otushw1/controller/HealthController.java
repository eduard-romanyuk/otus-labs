package com.example.otushw1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public Map<String, String> health() {
        System.out.println("/health requested");
        return Map.of("status", "OK");
    }

    @GetMapping
    public String root() {
        System.out.println("/ requested");
        return "Hello there!";
    }
}
