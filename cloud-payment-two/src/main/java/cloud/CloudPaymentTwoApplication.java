package cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author de'l'l
 */

@EnableEurekaClient
@SpringBootApplication
public class CloudPaymentTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudPaymentTwoApplication.class,args);
    }
}
