package com.crazy.openFeign.service;


import com.crazy.cloud.entity.CommonResult;
import com.crazy.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface IOrderFeignService {


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id);

//    @GetMapping(value = "/payment/feign/timeout")
//    public String paymentFeignTimeout();


}
