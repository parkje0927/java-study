package com.study.msaorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaOrderServiceApplication.class, args);
    }

}
