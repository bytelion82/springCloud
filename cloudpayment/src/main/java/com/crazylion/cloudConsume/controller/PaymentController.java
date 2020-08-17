package com.crazylion.cloudConsume.controller;



import com.crazylion.cloudConsume.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @GetMapping("/hello")
    public CommonResult hello(){
        return new CommonResult(200,"payment",null);
    }
}
