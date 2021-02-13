package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/mq")
@RestController
@RequiredArgsConstructor
public class MQController {
    private final Producer producer;
    private final Consumer consumer;

    @PostMapping("/{value}")
    public ResponseEntity<String> createPost(@PathVariable String value){
        producer.sendTo(value);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> getValue(){
        return ResponseEntity.ok(consumer.receiveFrom());
    }
}
