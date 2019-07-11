package com.fei.springcloudzuul5000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 启动zuul
public class SpringcloudZuul5000Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuul5000Application.class, args);
    }

}
