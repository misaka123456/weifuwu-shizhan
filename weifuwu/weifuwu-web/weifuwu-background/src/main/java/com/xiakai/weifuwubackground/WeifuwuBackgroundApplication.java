package com.xiakai.weifuwubackground;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class WeifuwuBackgroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeifuwuBackgroundApplication.class, args);


    }

}
