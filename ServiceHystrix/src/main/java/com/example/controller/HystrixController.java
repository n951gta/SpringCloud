package com.example.controller;

import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello/{id}")
    public String getHello(@PathVariable String id) {
        return helloService.getHello(id);
    }
}
