package org.example.producer.controller;

import org.example.producer.CustomMessage;
import org.example.producer.config.RabbitConfig;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange firstExchange;
    private final DirectExchange secondExchange;

    public ProducerController(RabbitTemplate rabbitTemplate, DirectExchange firstExchange, DirectExchange secondExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.firstExchange = firstExchange;
        this.secondExchange = secondExchange;
    }

    @PostMapping("/publish/{routingKey}")
    public String publishMessage(@PathVariable String routingKey, @RequestBody CustomMessage message) {
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,
                routingKey, message);

        return "Message Published to Consumer with Routing Key:"+ routingKey;
    }
}

