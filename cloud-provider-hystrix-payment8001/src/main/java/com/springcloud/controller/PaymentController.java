package com.springcloud.controller;

import com.springcloud.service.PaymenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}

