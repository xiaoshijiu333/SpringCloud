package com.fei.springcloudconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced //这个注解下RestTemplate才能向eureka中心调用服务
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
