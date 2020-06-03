package com.luck.demo.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@Component
public class MQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {

        //        消息确认机制。确认消息是否正常投放。
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.out.println("correlationData: " + correlationData);
//            System.out.println("ack: " + ack);
            if (!ack) {
                System.out.println("异常处理....");
            }
        }

    };
    //    通过实现 ReturnCallback 接口，启动消息失败返回，比如路由不到队列时触发回调
    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {

        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
            System.out.println("return exchange: " + exchange + ", routingKey: "
                    + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };

    //发送消息方法调用: 构建Message消息
    public void send(Object message, Map<String, Object> properties) throws Exception {
        MessageProperties mp = new MessageProperties();
        //在生产环境中这里不用Message，而是使用 fastJson 等工具将对象转换为 json 格式发送
        Message msg = new Message(message.toString().getBytes(), mp);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);//id + 时间戳 全局唯一
//        expiration
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm")));
        CorrelationData correlationData = new CorrelationData("1234567890" + new Date());
//        correlationData  消息唯一标识
        //发送消息 设置消息过期时间
//        rabbitTemplate.convertAndSend("BOOT-EXCHANGE-1", "boot.save", msg, m -> {
//            //设置10秒过期
//            m.getMessageProperties().setExpiration("10000");
//            m.getMessageProperties().setContentEncoding("utf-8");
////            设置延迟
//            m.getMessageProperties().setDelay(6000);
//            return m;
//        });
        rabbitTemplate.convertAndSend("BOOT-EXCHANGE-1", "boot.save", msg, correlationData);
    }
//    //发送消息方法调用: 构建Message消息
//    public void sendUser(UserInfo user) throws Exception {
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setConfirmCallback(confirmCallback);
//        rabbitTemplate.setReturnCallback(returnCallback);
//        //id + 时间戳 全局唯一
//        HashMap<Object, Object> userMap = new HashMap<>();
//        userMap.put("username", user.getUsername());
//        userMap.put("age", user.getAge());
//        String s = userMap.toString();
//        CorrelationData correlationData = new CorrelationData("1234567890" + new Date());
//        rabbitTemplate.convertAndSend("BOOT-EXCHANGE-1111", "boot.save111", s, correlationData);
//    }
}
