package com.luck.demo;

import com.luck.demo.entity.UserInfo;
import com.luck.demo.utils.MQSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RabbitTemplate rabbitmq;


    @Autowired
    private MQSender mqSender;

    @Test
    public void send() {
        String msg = "hello spring boot";
        try {
            for (int i = 0; i < 15; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //mqSender.send(msg + ":" + i, null);
                mqSender.send("123", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void contextLoads() {
    }

    /**
     * @Description: 发送消息
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/26
     */
    @Test
    public void send(String message) {
        System.out.println("发送消息：" + message);
        rabbitmq.convertAndSend("direct", message);
    }

    /**
     * @Description: 接收消息
     * @Param:
     * @return:
     * @Author: bo.yan
     * @date: 2019/12/26
     */
    @Component
    @RabbitListener(queues = "direct")
    public class Receiver {

        @RabbitHandler
        public void handler(String message) {
            System.out.println("接收消息：" + message);
        }
    }

}
