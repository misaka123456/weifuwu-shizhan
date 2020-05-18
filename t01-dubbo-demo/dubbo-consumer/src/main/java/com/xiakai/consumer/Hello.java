package com.xiakai.consumer;

import com.xiakai.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author xiakai
 * @create 2020-05-18 15:25
 */
public class Hello {

    public static void main(String[] args) throws IOException, InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        context.start();

        IUserService userService = (IUserService) context.getBean("userService");
        System.out.println("远程调用userService");
        while (true) {
            System.out.println(userService.hello());
            TimeUnit.SECONDS.sleep(1);
        }



    }

}
