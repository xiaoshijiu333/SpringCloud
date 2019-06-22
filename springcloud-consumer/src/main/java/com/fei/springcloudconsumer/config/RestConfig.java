package com.fei.springcloudconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: RestTemplate配置类
 */
@Configuration
public class RestConfig {

    /**
     * 向容器里面添加RestTemplate组件
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
