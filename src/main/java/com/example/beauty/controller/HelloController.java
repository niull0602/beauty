package com.example.beauty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by NiuLilu on 2020-04-15 19:30.
 */
@RestController
public class HelloController {
    @GetMapping
    public String get(){
        return "Hello";
    }
}
