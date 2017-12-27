package ke.co.safaricom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StkServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(StkServiceApplication.class, args);
    }
}
