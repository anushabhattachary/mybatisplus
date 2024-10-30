package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.demo.mapper")
@EnableTransactionManagement
@EnableCaching(proxyTargetClass = true)
public class SpringMainApplication {
    //通过反射加载SpringMainApplication类对象启动服务
    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }
}
