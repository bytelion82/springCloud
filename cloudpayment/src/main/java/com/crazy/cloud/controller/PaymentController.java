package com.crazy.cloud.controller;



import com.crazy.cloud.entity.CommonResult;
import com.crazy.cloud.entity.Payment;
import com.crazy.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    @GetMapping("/detail")
    public CommonResult hello(Integer id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println(payment);
        return new CommonResult(200,"payment",payment);
    }

    /**
     * 数据增加
     * @param payment
     * @return
     */
    @RequestMapping("/add")
    public CommonResult add(Payment payment){
        try {
            int i = paymentService.create(payment);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(200,"fail",null);
        }
        return new CommonResult(200,"success",1);
    }
}
