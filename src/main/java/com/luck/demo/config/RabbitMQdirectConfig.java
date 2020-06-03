package com.luck.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class RabbitMQdirectConfig {

    //    @Bean
//    public ConnectionFactory connectionFactory(){
//        return new CachingConnectionFactory();
//    }
//
//    @Bean
//    public RabbitAdmin rabbitAdmin(){
//        return new RabbitAdmin(connectionFactory());
//    }
    @Bean
    public TopicExchange bootExchange() {
        TopicExchange topicExchange = new TopicExchange("BOOT-EXCHANGE-1", true, false);
//        设置延时队列
        topicExchange.setDelayed(true);
        return topicExchange;
    }

    @Bean
    public Queue bootQueue() {
        return new Queue("boot.queue1", true);
    }


    /**
     * 绑定exchange & queue & routekey.
     *
     * @param queueMessage 队列
     * @param exchange     交换机
     * @param routekey     路由
     * @return
     */
//    public Binding bindingExchange(Queue queueMessage, TopicExchange exchange, String routekey) {
//        return BindingBuilder.bind(queueMessage).to(exchange).with(routekey);
//    }

//    @Bean("deadLetterExchange")
//    public Exchange deadLetterExchange() {
//        return ExchangeBuilder.directExchange("DL_EXCHANGE").durable(true).build();
//    }

//    @Bean("deadLetterQueue")
//    public Queue deadLetterQueue() {
//        Map<String, Object> args = new HashMap<>(2);
////       x-dead-letter-exchange    声明  死信交换机
//        args.put("x-dead-letter-exchange", "DL_EXCHANGE");
////       x-dead-letter-routing-key    声明 死信路由键
//        args.put("x-dead-letter-routing-key", "KEY_R");
//        return QueueBuilder.durable("DL_QUEUE").withArguments(args).build();
//    }
//
//    @Bean("redirectQueue")
//    public Queue redirectQueue() {
//        return QueueBuilder.durable("REDIRECT_QUEUE").build();
//    }
//
//    /**
//     * 死信路由通过 DL_KEY 绑定键绑定到死信队列上.
//     *
//     * @return the binding
//     */
//    @Bean
//    public Binding deadLetterBinding() {
//        return new Binding("DL_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "DL_KEY", null);
//
//    }
//
//    /**
//     * 死信路由通过 KEY_R 绑定键绑定到死信队列上.
//     *
//     * @return the binding
//     */
//    @Bean
//    public Binding redirectBinding() {
//        return new Binding("REDIRECT_QUEUE", Binding.DestinationType.QUEUE, "DL_EXCHANGE", "KEY_R", null);
//    }


}