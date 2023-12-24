package com.study.msa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaApplication.class, args);
    }

}
