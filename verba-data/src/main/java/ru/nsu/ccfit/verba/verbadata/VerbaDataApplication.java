package ru.nsu.ccfit.verba.verbadata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VerbaDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerbaDataApplication.class, args);
    }

}
