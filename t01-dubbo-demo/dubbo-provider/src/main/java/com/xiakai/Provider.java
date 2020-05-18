package com.xiakai;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author xiakai
 * @create 2020-05-18 15:09
 */
public class Provider {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
        context.start();
        System.out.println("发布服务成功  04");
        System.in.read();

    }

}
