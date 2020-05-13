package com.ravicode.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravicode.example.model.HelloObject;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class HelloController {
    private AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public HelloObject getHelloWordObject() {
        HelloObject hello = new HelloObject();
        hello.setMessage("Hi there! you are number " + counter.incrementAndGet());
        return hello;
    }
}