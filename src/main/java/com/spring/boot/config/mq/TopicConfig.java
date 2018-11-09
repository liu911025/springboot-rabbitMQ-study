package com.spring.boot.config.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/10/30.
 */
@Configuration
public class TopicConfig {

    private static String TOPIC_ROUTING_KEY_A = "topic.a";
    private static String TOPIC_ROUTING_KEY_B = "topic.b";

    private static String TOPIC_EXCHANGE = "topic.exchange";

    @Bean
    public Queue queueA() {
        return new Queue(TOPIC_ROUTING_KEY_A);
    }

    @Bean
    public Queue queueB() {
        return new Queue(TOPIC_ROUTING_KEY_B);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingExchangeQueueA(Queue queueA, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueA).to(topicExchange).with("topic.a");
    }

    @Bean
    public Binding bindingExchangeQueueB(Queue queueB, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueB).to(topicExchange).with("topic.#");
    }
}
