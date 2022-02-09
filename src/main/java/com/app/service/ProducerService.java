package com.app.service;

import com.app.dto.CommonKafkaDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, CommonKafkaDto> kafkaTemplate;

    public boolean publish(CommonKafkaDto commonKafkaDto) {
        try {
            String requestTopic = "test-app";
            ProducerRecord<String, CommonKafkaDto> producerRecord = new ProducerRecord<>(requestTopic, commonKafkaDto);
            kafkaTemplate.send(producerRecord);
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }
        return false;
    }
}
