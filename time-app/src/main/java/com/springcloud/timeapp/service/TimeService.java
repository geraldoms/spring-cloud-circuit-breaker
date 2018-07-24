package com.springcloud.timeapp.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimeService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String getTime() {

        return restTemplate.getForEntity("http://time-service/current/time", String.class)
                           .getBody();
    }

    public String fallback() {

        return "Time Service is unavailable right now.";
    }
}
