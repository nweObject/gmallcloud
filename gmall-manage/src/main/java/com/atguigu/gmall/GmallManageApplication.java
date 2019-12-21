package com.atguigu.gmall;

import com.atguigu.gmall.config.ActiveMQConfig;
import com.atguigu.gmall.config.WebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@MapperScan("com.atguigu.gmall.manage.mapper")
@SpringBootApplication
@EnableFeignClients
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ActiveMQConfig.class, WebMvcConfiguration.class})})
public class GmallManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallManageApplication.class, args);
    }

}
