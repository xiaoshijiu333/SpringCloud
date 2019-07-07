package com.fei.springcloudfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 这里额外指定@ComponentScan，则默认的包扫描规则不再生效
 * @ComponentScan(basePackages = { "feign.hystrix", "feign.webservice" })
 */
@SpringBootApplication
// 开启向服务中心eureka发现和注册服务
@EnableEurekaClient
// 需要将feign接口所在包写上（不然扫描不到，注入不了）
@EnableFeignClients(basePackages = "feign.webservice")
public class SpringcloudFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignClientApplication.class, args);
    }

}
