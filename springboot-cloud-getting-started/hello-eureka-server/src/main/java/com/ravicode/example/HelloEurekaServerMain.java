package com.ravicode.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HelloEurekaServerMain {
    public static void main(String[] args) {
        SpringApplication.run(HelloEurekaServerMain.class, args);
    }
}