package com.luck.demo.utils;

import com.luck.demo.entity.UserInfo;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


@Component
public class MQReceiver {

//    @RabbitHandler
//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(value = "boot.queue1", durable = "true"),
//                    exchange = @Exchange(value = "BOOT-EXCHANGE-1", type = "topic", durable = "true", ignoreDeclarationExceptions = "true"),
//                    key = "boot.*"
//            )
//    )
//    public void onMessage(Message message, Channel channel) throws IOException {
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        //手工ack
//        channel.basicAck(deliveryTag, true);
//        System.out.println("receive--1: " + new String(message.getBody()));
//    }
//
//    @RabbitHandler
//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(value = "boot.queue1", durable = "true"),
//                    exchange = @Exchange(value = "BOOT-EXCHANGE-1", type = "topic", durable = "true", ignoreDeclarationExceptions = "true"),
//                    key = "boot.*"
//            )
//    )
//    public void onUserMessage(@Payload UserInfo user, Channel channel, @Headers Map<String, Object> headers) throws IOException {
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
//        //手工ack
//        channel.basicAck(deliveryTag, true);
//        System.out.println("receive--11: " + user.toString());
//    }
}
