package com.lcay.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class CloudTurbineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudTurbineServiceApplication.class, args);
    }

}
