package com.fei.springcloudzuulconfig5001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 启动zuul
public class SpringcloudZuulConfig5001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulConfig5001Application.class, args);
    }

}
