package com.lcay.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientRefreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientRefreshApplication.class, args);
    }

}
