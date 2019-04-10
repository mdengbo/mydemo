package com.example.rabbitmq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author madnegbo
 * @create 2019/3/25.
 */
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver : " + hello);
    }

    @RabbitHandler
    @RabbitListener(queues = "hello0001")
    public void process00(String hello) {
        System.out.println("Receiver0000 : " + hello);
    }

}
