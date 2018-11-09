package com.spring.boot.mq.send;

import com.spring.boot.config.mq.FanoutConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/10/31.
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendA (String context) {
        rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, FanoutConfig.FANOUT_QUEUE_A, context);
    }

    public void sendB (String context) {
        rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, FanoutConfig.FANOUT_QUEUE_B, context);
    }

    public void sendC (String context) {
        rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, FanoutConfig.FANOUT_QUEUE_C, context);
    }
}

