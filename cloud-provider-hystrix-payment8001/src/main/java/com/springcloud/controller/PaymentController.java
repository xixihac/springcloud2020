package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Autowired
    private PaymenService paymenService;

    @GetMapping("/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return paymenService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        System.out.println(id + "进入方法体timeout");
        return paymenService.paymentInfo_Timeout(id);
    }

    @GetMapping("/payment/circuit/{id}")
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

