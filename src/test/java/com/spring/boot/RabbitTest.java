package com.spring.boot;

import com.spring.boot.entry.User;
import com.spring.boot.mq.send.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2018/10/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTest {

    @Autowired
    HelloSender helloSender;

    @Autowired
    HelloSender2 helloSender2;

    @Autowired
    UserSender userSender;

    @Autowired
    TopicSenderA topicSenderA;

    @Autowired
    TopicSenderB topicSenderB;

    @Autowired
    FanoutSender fanoutSender;

    @Test
    public void test_01() {
        for (int i = 0; i < 100; i++){
            helloSender.send("hello " + i);
        }
    }

    //多个发送者还是均匀接收
    @Test
    public void test_02() {
        for (int i = 0; i < 100; i++){
            helloSender.send("hello " + i);
            helloSender2.send("world" + i);
        }
    }


    //发送接收对象
    @Test
    public void test_03() {
        for (int i = 0; i < 100; i++){
            User user = new User();
            user.setId(i);
            user.setName("pp>>>" + i);
            user.setAge((short) i);
            userSender.send(user);
        }

    }

    /**
     *  A 路由键为topic.a,只能接收A发送的消息
     *  B 路由键为topic.#,可以同时匹配A,B发送的消息
     */
    @Test
    public void test_04() {
        for (int i = 0; i < 10; i++) {
            topicSenderA.send("topicA:" + i);
            topicSenderB.send("topicB:" + i);
        }
    }

    /**
     *  广播模式也叫订阅模式
     */
    @Test
    public void test_05() {
        for (int i = 0; i < 10; i++) {
            fanoutSender.sendA(i + "");
        }
    }
}
