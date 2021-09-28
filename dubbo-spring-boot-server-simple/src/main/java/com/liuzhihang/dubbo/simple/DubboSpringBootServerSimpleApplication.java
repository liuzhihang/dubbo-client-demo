package com.liuzhihang.dubbo.simple;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboSpringBootServerSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboSpringBootServerSimpleApplication.class, args);
    }

}
