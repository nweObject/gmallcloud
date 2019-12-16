package com.atguigu.gmall.manageui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GmallManageuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallManageuiApplication.class, args);
    }

}
