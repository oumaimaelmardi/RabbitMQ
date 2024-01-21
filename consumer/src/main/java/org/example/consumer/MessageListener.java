package org.example.consumer;


import org.example.consumer.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }


}
