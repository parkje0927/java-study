package com.study.userservice.status.controller;

import com.study.userservice.status.vo.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatusController {

    private final Greeting greeting;
    private final Environment environment;

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's working in user service on port %s",
                environment.getProperty("local.server.port"));
    }
}
