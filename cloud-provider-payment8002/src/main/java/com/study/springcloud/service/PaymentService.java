package com.study.springcloud.service;


import com.study.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Integer id);
}
