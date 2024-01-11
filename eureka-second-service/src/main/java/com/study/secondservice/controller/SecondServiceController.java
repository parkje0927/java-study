package com.study.secondservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "second-service-welcome";
    }
}
