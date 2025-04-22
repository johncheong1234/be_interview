package com.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greet(String name) {
        return "Hello " + name;
    }

    public String greet(String name, String suffix) {
        return greet(name) + (suffix != null ? suffix : "");
    }
}