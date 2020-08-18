package com.crazy.cloud.controller;



import com.crazy.cloud.entity.CommonResult;
import com.crazy.cloud.entity.Payment;
import com.crazy.cloud.service.IPaymentService;
import com.mysql.jdbc.TimeUtil;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 作为eureka的server 层，这里接口参数必须加上注解才能取出client请求时穿过的数据
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> hello(@PathVariable("id") Integer id){
        System.out.println("id="+id);
        Payment payment = paymentService.getPaymentById(id);
        System.out.println(payment);
        System.out.println("serverport:{}"+serverPort);
        return new CommonResult(200,"serverPort："+serverPort,payment);
    }

    /**
     * 数据增加，必须加上@RequestBody ,否者取不到数据，这里过eureka注册中心内容分发获取数据
     * @param payment
     * @return
     */
    @RequestMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        System.out.println(payment);
        try {
            int i = paymentService.create(payment);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(400,"serverPort"+serverPort,null);
        }
        return new CommonResult(200,"serverPort"+serverPort,"success add data");
    }

    /**
     * Through the @EnableDiscovery annotation, the discoveryclient can specify the relevant information of the microservice
     * @return
     */
    @GetMapping("cloud/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(element ->log.info("element:"+element));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance->log.info("instance uri:"+instance.getUri()));
        return this.discoveryClient;
    }


    @GetMapping("/payment/feign/timeout")
    public String OpenfeignSleep(){
        Time.sleep(3000);
        return serverPort;
    }
}
