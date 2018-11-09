package com.spring.boot.mq.send;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/30.
 */
@Component
public class TopicSenderB {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String context) {
        //System.out.println("send:" + context );
        rabbitTemplate.convertAndSend("topic.exchange","topic.b", context);
    }
}
