package cloud.controller;



import cloud.service.IPaymentService;
import com.crazy.cloud.entity.CommonResult;
import com.crazy.cloud.entity.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 必须加上@PathVariable 否则取不到数据
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println(payment);
        return new CommonResult(200,"serverPort:"+serverPort,payment);
    }

    /**
     * 数据增加，这里必须加上@RequestBody,否者取不到数据
     * @param payment
     * @return
     */
    @RequestMapping("/payment/add")
    public CommonResult add(Payment payment){
        System.out.println(payment);
        try {
            int i = paymentService.create(payment);
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(200,"serverPort:"+serverPort,null);
        }
        return new CommonResult(200,"serverPort:"+serverPort,1);
    }

    @GetMapping("/payment/feign/timeout")
    public String OpenfeignSleep(){
        log.info("openfeign");

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
