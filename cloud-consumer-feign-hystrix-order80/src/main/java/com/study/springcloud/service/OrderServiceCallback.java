package com.study.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceCallback implements OrderService {
    @Override
    public String paymentOk(Integer id) {
        return "OrderServiceCallback---paymentok";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "OrderServiceCallback---paymenttimeout";
    }
}
