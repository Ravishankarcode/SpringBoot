package com.ravicode.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloWebClientServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(HelloWebClientServiceMain.class, args);
	}
}