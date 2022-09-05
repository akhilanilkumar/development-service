package com.development.developmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DevelopmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopmentServiceApplication.class, args);
    }

}
