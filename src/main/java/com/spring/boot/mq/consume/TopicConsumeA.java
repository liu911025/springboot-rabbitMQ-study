package com.spring.boot.mq.consume;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/30.
 */
@Component
//@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "topic.a"),exchange = @Exchange(value = "topic.exchange", type = ExchangeTypes.TOPIC)))
public class TopicConsumeA {

    @RabbitListener(queues = {"topic.a"})
    @RabbitHandler
    public void consumeA(String helllo) {
        System.out.println("consume>>>A--->" + helllo);
    }

    @RabbitListener(queues = {"topic.b"})
    @RabbitHandler
    public void consumeB(String helllo) {
        System.out.println("consume>>>B:--->" + helllo);
    }
}
