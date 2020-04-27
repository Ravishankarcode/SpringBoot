package com.ravicode.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloServiceMain{

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceMain.class, args);
	}
}