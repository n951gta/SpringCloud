package com.example.client;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String getHello(String id) {
        return "request hello service error : "+id;
    }
}
