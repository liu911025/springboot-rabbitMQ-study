package com.spring.boot.mq.consume;

import com.spring.boot.config.mq.FanoutConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/31.
 */
@Component
public class FanoutConsume {

    @RabbitListener(queues = {"fanout.a"})
    @RabbitHandler
    public void consumeA(String context) {
        System.out.println("consumeA >>>" + context);
    }

    @RabbitListener(queues = {"fanout.b"})
    @RabbitHandler
    public void consumeB(String context) {
        System.out.println("consumeB >>>" + context);
    }

    @RabbitListener(queues = {"fanout.c"})
    @RabbitHandler
    public void consumeC(String context) {
        System.out.println("consumeC >>>" + context);
    }
}
