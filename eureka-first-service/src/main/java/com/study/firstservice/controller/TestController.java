package com.study.firstservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    Environment environment;

    @Autowired
    public TestController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "first-service-welcome";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info("header = {}", header);
        return header;
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("port = {}", request.getServerPort());
        return "this is a message from first-service";
    }
}
