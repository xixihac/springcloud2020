package com.study.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {
    //记得要发送post请求http://localhost:3355/actuator/refresh才会刷新

    @Value("${config.info}")
    private String info;
    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getInfo() {
        return info+":"+port;
    }
}
