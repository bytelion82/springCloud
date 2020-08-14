package com.crazylion.cloud.controller;


import com.crazylion.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @GetMapping("Hello")
    public CommonResult hello(){
        return new CommonResult(200,"success",null);
    }
}
