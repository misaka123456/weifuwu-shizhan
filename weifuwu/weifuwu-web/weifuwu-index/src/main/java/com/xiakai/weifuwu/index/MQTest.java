package com.xiakai.weifuwu.index;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiakai
 * @create 2020-05-29 15:29
 */
public class MQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {


        rabbitTemplate.convertAndSend("cent-product", "product.add", "1111");
    }

    public void receive() {


    }


}
