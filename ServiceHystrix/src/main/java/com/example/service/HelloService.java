package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.hello-service}")
    private String helloServiceUrl;

    @HystrixCommand(fallbackMethod = "getHelloFallback")
    public String getHello(String id) {
        return restTemplate.getForObject(helloServiceUrl + "/hello/{1}", String.class, id);
    }

    public String getHelloFallback(@PathVariable String id) {
        return "request hello service error : "+id;
    }
}
