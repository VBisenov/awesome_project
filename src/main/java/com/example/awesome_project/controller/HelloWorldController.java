package com.example.awesome_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/awesome-application")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorldController() {
        return "Hello world";
    }

    //tgsdfgsdgf
}
