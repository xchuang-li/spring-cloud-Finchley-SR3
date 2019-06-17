package com.lcay.cloud.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 自定义Feign配置
 * 需注意：此配置类与@ComponentScan存在扫描冲突
 * */

@Configuration
public class FeignConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
