package com.lcay.cloud.feign;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 自定义Feign配置
 * 需注意：此配置类与@ComponentScan存在扫描冲突
 * */

@Configuration
public class FeignConfiguration {
    //开启Feign的FULL日志级别
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    //请求重试
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(1000,3000,3);
    }
}
