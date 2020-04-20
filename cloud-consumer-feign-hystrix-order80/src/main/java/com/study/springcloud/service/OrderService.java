package com.study.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-hystrix-service",fallback = OrderServiceCallback.class)
public interface OrderService {

    @GetMapping("/payment/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id);
}
