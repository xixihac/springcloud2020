package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@ResponseBody
@RequestMapping("/consumer")
public class OrderController {
    public static final String INVOKE_URL = "http://cloud-provider-service";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/zk")
    public Object invoke() {
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return forObject;
    }
}
