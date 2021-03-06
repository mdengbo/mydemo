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
 * @create 2019-04-10 11:06
 * @desc
 * @Version 1.0
 **/
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
@Slf4j
public class MsgReceiverC_two {
    @RabbitHandler
    public void process(String content) {
        log.info("处理器two接收处理队列A当中的消息： " + content);
    }

}
