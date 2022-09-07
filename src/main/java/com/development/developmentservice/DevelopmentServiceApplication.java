package com.development.developmentservice;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Log4j2
public class DevelopmentServiceApplication {

    @Value("${uri.party-service}")
    private static String serviceURI;

    public static void main(String[] args) {
        log.info("{}", serviceURI);
        SpringApplication.run(DevelopmentServiceApplication.class, args);
    }

}
