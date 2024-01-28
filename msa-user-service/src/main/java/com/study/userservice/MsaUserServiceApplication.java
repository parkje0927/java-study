package com.study.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaUserServiceApplication.class, args);
    }

}
