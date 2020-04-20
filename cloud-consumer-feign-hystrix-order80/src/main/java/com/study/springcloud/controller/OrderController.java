package com.study.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.study.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@DefaultProperties(defaultFallback = "globalDefaultFallbackMethod")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return orderService.paymentOk(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    @HystrixCommand
    public String paymentTimeout(@PathVariable("id") Integer id) {
        int i = 10 / 0;
        return orderService.paymentTimeout(id);
    }

    @GetMapping("/consumer/payment/circuit/{id}")
    //熔断配置
    @HystrixCommand(defaultFallback = "globalDefaultFallbackMethod",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public String circuit(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负");
        }
        String string = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "circuit:" + id + string;
    }

    public String globalDefaultFallbackMethod() {
        return "这是全局处理/(ㄒoㄒ)/~~";
    }
}
