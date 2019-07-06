package com.fei.springcloudconsumefeign.config;

import com.fei.feign.ribbon.config.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.fei.common.constant.ServerContant;

/**
 * @Author: xiaoshijiu
 * @Date: 2019/6/21
 * @Description: RestTemplate配置类
 * @RibbonClient: 指定为某个服务加载自己的自定义算法（没有该注解的话表明对所有服务生效）
 */
@Configuration
@RibbonClient(name = ServerContant.SERVER_PROVIDER, configuration = MyRule.class)
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
