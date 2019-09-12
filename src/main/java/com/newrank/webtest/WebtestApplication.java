package com.newrank.webtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class WebtestApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebtestApplication.class, args);
        System.out.println("test");
    }

}
