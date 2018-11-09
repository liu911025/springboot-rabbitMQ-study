package com.spring.boot.mq.consume;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/30.
 */
@Component
@RabbitListener(queues = {"hello"})
public class HelloConsume {

    @RabbitHandler
    public void consume(String helllo) {
        System.out.println("consume:" + helllo);
    }
}
