package com.fei.springcloudfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // 开启向服务中心eureka发现和注册服务
// 需要将feign接口所在包写上
@EnableFeignClients(basePackages = "feign.webservice")
public class SpringcloudFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFeignClientApplication.class, args);
    }

}
