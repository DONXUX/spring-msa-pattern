package com.donxux.consumerserver.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "outbox-events", groupId = "group")
    public void listen(String message) {
        System.out.println("kafka message : " + message);
    }
}
