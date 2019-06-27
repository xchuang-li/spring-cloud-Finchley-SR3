package com.lcay.cloud.feign;

import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EnabledHystrixConfiguration {
    @Bean
    @Scope("prototype")
    public HystrixFeign.Builder feignBuilder(){
        return HystrixFeign.builder();
    }
}
