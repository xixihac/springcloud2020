package com.study.springcloud.controller;

import com.study.springcloud.entities.CommonResult;
import com.study.springcloud.entities.Payment;
import com.study.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consumer")
@ResponseBody
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return paymentService.getPaymentById(id);
    }

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        System.out.println(payment.getSerial());
        return paymentService.create(payment);
    }


}
