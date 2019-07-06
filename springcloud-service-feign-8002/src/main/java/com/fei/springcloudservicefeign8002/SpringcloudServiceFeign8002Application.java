package com.fei.springcloudservicefeign8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启向服务中心eureka发现和注册服务
public class SpringcloudServiceFeign8002Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceFeign8002Application.class, args);
    }

}
