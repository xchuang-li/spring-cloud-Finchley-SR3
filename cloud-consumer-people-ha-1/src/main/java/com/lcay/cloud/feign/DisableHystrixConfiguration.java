package com.lcay.cloud.feign;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 局部
 * 禁用Hystrix
 * Feign默认整合了Hystrix，只需在application.yml中配置feign.hystrix.enabled=true即可
 * 如果想要单个FeignClient接口禁用Hystreix，只需引入该配置类@FeignClient(name="",configuration=DisableHystrixConfiguration.class)
 * */
@Component
public class DisableHystrixConfiguration {
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
}
