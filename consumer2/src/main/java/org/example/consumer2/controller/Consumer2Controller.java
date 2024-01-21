package org.example.consumer2.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2Controller {
    @RabbitListener(queues = "queueTwo")
    public void consumeMessage(String message) {
        System.out.println("Consumer 2: " + message);
    }
}