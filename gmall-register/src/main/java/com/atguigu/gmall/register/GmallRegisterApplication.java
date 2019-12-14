package com.atguigu.gmall.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class GmallRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallRegisterApplication.class, args);
    }

}
