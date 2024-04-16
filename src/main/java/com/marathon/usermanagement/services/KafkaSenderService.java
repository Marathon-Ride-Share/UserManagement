package com.marathon.usermanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSenderService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUser(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}