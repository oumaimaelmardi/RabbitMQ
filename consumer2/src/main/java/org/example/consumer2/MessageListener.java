package org.example.consumer2;



import org.example.consumer2.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void listener(CustomMessage message) {
        System.out.println(message);
    }


}
