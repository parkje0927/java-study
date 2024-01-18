package com.study.firstservice.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Greeting {

    @Value("${greeting.message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
