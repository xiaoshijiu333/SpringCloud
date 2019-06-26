package com.fei.springcloudprovide8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启向服务中心eureka发现和注册服务
public class SpringcloudProvide8001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProvide8001Application.class, args);
    }

}
