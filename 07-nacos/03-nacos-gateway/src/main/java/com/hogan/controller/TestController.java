package com.hogan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("discovery")
    public String test() {
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        System.out.println(instances);

        instances = discoveryClient.getInstances("nacos-client-a");
        System.out.println(instances);

        return "ok";
    }
}
