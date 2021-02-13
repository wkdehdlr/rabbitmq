package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class MQControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void MQControllerTest() {
        testRestTemplate.postForEntity("http://localhost:8080/mq/hello", null, String.class);

        ResponseEntity<String> response = testRestTemplate
            .getForEntity("http://localhost:8080/mq", String.class);

        assertEquals("hello", response.getBody());
    }
}