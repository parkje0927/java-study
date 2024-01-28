package com.study.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaSecondServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaSecondServiceApplication.class, args);
    }

}
