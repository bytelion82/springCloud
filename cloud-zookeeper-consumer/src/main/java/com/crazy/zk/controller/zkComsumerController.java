package com.crazy.zk.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * zookeeper 服务消费者即远程调用
 * @author de'l'l
 */
@RestController
public class zkComsumerController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        String template = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return template;
    }

}
