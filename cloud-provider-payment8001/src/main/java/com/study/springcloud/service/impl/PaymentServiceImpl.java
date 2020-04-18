package com.study.springcloud.service.impl;

import com.study.springcloud.entities.Payment;
import com.study.springcloud.mapper.PaymentMapper;
import com.study.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        Payment payment = paymentMapper.getPaymentById(id);

        return payment;
    }
}
