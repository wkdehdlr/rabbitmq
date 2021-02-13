package com.example.demo;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "TEST_QUEUE")
    public void handler(String message) {
        log.info("receiveFromQueue :: {}", message);
    }

    public String receiveFrom() {
        return Objects.requireNonNull(rabbitTemplate.receiveAndConvert("TEST_QUEUE"))
            .toString();
    }
}