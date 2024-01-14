package com.study.firstservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info("header = {}", header);
        return header;
    }

    @GetMapping("/check")
    public String check() {
        return "this is a message from first-service";
    }
}
