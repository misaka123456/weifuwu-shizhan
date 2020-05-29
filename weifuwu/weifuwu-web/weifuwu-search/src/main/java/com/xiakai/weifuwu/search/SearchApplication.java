package com.xiakai.weifuwu.search;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiakai
 * @create 2020-05-24 22:46
 */
@SpringBootApplication
@EnableDubbo
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);

    }

}
