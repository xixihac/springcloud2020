package com.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymenService {

    public String paymentInfo_ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "  paymentInfo_ok,id   " + id;
    }

    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Timeout,id  " + id;
    }
}
