package com.xiakai.weifuwu.search;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDubbo
@MapperScan("com.xiakai.weifuwu.mapper")
public class SearchServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchServiceApplication.class, args);

    }


}
