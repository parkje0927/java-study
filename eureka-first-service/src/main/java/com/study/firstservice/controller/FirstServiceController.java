package com.study.firstservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstServiceController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "first-service-welcome";
    }
}
