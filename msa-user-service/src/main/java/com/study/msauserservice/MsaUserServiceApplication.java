package com.study.msauserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsaUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaUserServiceApplication.class, args);
	}

}
