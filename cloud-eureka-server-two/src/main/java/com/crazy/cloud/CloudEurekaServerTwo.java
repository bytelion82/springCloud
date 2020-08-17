package com.crazy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author de'l'l
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerTwo {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerTwo.class,args);
    }
}
