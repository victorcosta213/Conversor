package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaMundoController {

    @GetMapping("/")
    public String olaMundo() {
        return "Olá Mundo!";
    }
}
