package com.xiakai.weifuwuproductservice;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.xiakai.weifuwu.mapper")
public class WeifuwuProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeifuwuProductServiceApplication.class, args);
    }

}
