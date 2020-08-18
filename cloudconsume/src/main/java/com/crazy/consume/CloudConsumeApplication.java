package com.crazy.consume;


import com.crazy.selfRibborRules.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author de'l'l
 */

@EnableEurekaClient
@SpringBootApplication
//指定ribbon 的负载策略生效，自定义的随机策略，如果规则不生效 请检测name服务名
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
public class CloudConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeApplication.class,args);
    }
}
