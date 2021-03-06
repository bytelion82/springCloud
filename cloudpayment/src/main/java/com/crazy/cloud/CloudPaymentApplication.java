package com.crazy.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author de'l'l
 */
@EnableDiscoveryClient   //服务发现功能
@EnableEurekaClient
@SpringBootApplication
public class CloudPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentApplication.class,args);
    }
}
