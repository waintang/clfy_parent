package xyz.clfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClfyConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClfyConsumerApplication.class, args);
    }
}
