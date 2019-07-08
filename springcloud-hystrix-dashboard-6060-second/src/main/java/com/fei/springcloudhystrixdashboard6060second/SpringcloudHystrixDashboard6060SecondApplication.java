package com.fei.springcloudhystrixdashboard6060second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class SpringcloudHystrixDashboard6060SecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHystrixDashboard6060SecondApplication.class, args);
    }

}
