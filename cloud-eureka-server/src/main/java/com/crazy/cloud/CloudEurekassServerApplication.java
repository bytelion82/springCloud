package com.crazy.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author de'l'l
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekassServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekassServerApplication.class,args);
    }
}
