package com.fei.springcloudeurekaservice7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //表明这个eureka的服务端（服务中心）
public class SpringcloudEurekaService7001Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaService7001Application.class, args);
    }

}
