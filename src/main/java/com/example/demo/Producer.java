package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    public void sendTo(String message){
        rabbitTemplate.convertAndSend("TEST_QUEUE",message);
    }
}
