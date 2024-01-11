package com.study.firstservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaFirstServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFirstServiceApplication.class, args);
    }

}
