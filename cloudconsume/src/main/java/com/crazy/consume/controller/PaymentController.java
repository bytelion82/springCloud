package com.crazy.consume.controller;

import com.crazy.cloud.entity.CommonResult;
import com.crazy.cloud.entity.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
public class PaymentController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("hello")
    @ResponseBody
    public CommonResult hello(){
        return new CommonResult<>(200,"success",null);
    }


    @GetMapping("/consumer/payment/get/{id}")
    @ResponseBody
    public CommonResult getPayment(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        CommonResult result = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
        System.out.println(result);
        return result ;
    }

    @GetMapping("/consumer/payment/add")
    @ResponseBody
    public CommonResult<Payment> add( Payment payment){
        System.out.println(payment);
        CommonResult result = restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
        System.out.println(result);
        return result;
    }


    @GetMapping("/consumer/payment/getEntity/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Integer id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult(400,"error",entity.getStatusCode());
        }
    }

}
