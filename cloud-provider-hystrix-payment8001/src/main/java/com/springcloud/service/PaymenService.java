package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymenService {

    public String paymentInfo_ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "  paymentInfo_ok,id   " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHander", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "500")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Timeout,id  " + id;
    }

    public String paymentInfo_TimeoutHander(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_Timeout,id  " + id + "/(ㄒoㄒ)/~~";
    }
}
