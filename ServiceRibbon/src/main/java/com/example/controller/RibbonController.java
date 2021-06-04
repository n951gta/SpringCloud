package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.hello-service}")
    private String helloServiceUrl;

    @GetMapping("/hello/{id}")
    public String getUser(@PathVariable String id) {
        return restTemplate.getForObject(helloServiceUrl + "/hello/{1}", String.class, id);
    }
}
