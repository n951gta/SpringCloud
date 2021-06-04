package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloService {
    @GetMapping("/hello/{id}")
    String getHello(@PathVariable String id);
}
