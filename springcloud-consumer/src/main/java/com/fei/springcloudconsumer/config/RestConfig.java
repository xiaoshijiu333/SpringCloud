package com.fei.springcloudconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: RestTemplate配置类
 * @RibbonClient: 加载自己的自定义算法（指定为某个服务）
 */
@Configuration
@RibbonClient(name = "SPRINGCLOUD-EMPLOYEE-PROVIDER", configuration = MyRule.class)
public class RestConfig {

    /**
     * 向容器里面添加RestTemplate组件
     * @LoadBalanced: 如何调用多个微服务，负载均衡，这里默认是轮询算法
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 使用随机负载均衡算法
     */
    // @Bean
    // public RandomRule randomRule() {
    // return new RandomRule();
    // }

    /**
     * 自定义负载均衡算法，每个服务轮询3次
     */
    @Bean
    public MyRule myRule() {
        return new MyRule();
    }

}
