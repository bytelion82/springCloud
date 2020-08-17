package com.crazy.consume.controller;

import com.crazy.common.entity.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {


    @GetMapping("hello")
    @ResponseBody
    public CommonResult hello(){
        return new CommonResult<>(200,"success",null);
    }
}
