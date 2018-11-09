package com.spring.boot.mq.consume;

import com.spring.boot.entry.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/30.
 */
@Component
@RabbitListener(queues = {"userQueue"})
public class UserConsume {

    @RabbitHandler
    public void consume(User user) {
        System.out.println("UserConsume :" + user.toString());
    }
}
