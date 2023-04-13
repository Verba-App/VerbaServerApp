package ru.nsu.ccfit.verba.verbaauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VerbaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerbaAuthApplication.class, args);
    }

}
