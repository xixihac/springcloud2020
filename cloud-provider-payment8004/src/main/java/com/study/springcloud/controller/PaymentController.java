package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
@RequestMapping("/payment")
@ResponseBody
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/zk")
    public String paymentZk() {
        return serverPort + UUID.randomUUID().toString();
    }


}
