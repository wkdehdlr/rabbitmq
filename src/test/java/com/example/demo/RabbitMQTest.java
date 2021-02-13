package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void MQ에_넣고_MQ에서_가져오기() {
        rabbitTemplate.convertAndSend("TEST_QUEUE", "hello world");
        String receiveMessage = rabbitTemplate.receiveAndConvert("TEST_QUEUE").toString();
        assertEquals("hello world", receiveMessage);
    }
}