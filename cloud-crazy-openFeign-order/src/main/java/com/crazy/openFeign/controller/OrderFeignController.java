package com.crazy.openFeign.controller;


import com.crazy.cloud.entity.CommonResult;
import com.crazy.cloud.entity.Payment;
import com.crazy.openFeign.service.IOrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Slf4j
@RestController
public class OrderFeignController {

    @Resource
    private IOrderFeignService orderFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id)
    {
        log.info(" serverPort=66  id={}",id);
        return orderFeignService.getPaymentById(id);
    }


}
