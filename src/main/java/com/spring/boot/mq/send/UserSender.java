package com.spring.boot.mq.send;

import com.spring.boot.entry.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/30.
 */
@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        rabbitTemplate.convertAndSend("userQueue", user);
    }
}
