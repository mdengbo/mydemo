package com.example.rabbitmq.one2many;

import com.example.rabbitmq.exchange.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author madengbo
 * @create 2019-04-10 11:05
 * @desc 多个消费者消费同一个生产者 QUEUE 时  消费是负载均衡的
 * @Version 1.0
 **/
@Component
@Slf4j
public class MsgReceiverC_one {

    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void process(String content) {
        log.info("处理器one接收处理队列A当中的消息： " + content);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.QUEUE_B)
    public void processB(String content) {
        log.info("处理器one接收处理队列B当中的消息： " + content);
    }
}
