package com.lcay.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan(basePackages = "com.lcay.cloud.mapper")
@EnableDiscoveryClient
public class CloudProviderMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderMovieApplication.class, args);
    }

}
