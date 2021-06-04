package com.example.controller;

import com.example.client.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello/{id}")
    public String getHello(@PathVariable String id) {
        return helloService.getHello(id);
    }
}
