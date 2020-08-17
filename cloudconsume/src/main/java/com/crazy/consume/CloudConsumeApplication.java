package com.crazy.consume;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author de'l'l
 */

@EnableEurekaClient
@SpringBootApplication
public class CloudConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumeApplication.class,args);
    }
}
