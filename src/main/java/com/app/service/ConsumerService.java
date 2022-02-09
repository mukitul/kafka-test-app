package com.app.service;

import com.app.dto.CommonKafkaDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    @KafkaListener(topics = "test-app", groupId = "test-group")
    public void consumeMessage(ConsumerRecord<String, CommonKafkaDto> consumerRecord) {
        System.out.println("Received Message: " + consumerRecord);
        System.out.println("Consumed Value: " + consumerRecord.value());
    }
}
