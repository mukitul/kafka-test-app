package com.app.service;

import com.app.dto.CommonKafkaDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {
    private final KafkaTemplate<String, CommonKafkaDto> kafkaTemplate;

    @Value(value = "${listner.test.app.topic}")
    private String topic;

    public boolean publish(CommonKafkaDto commonKafkaDto) {
        try {
            System.out.println("PUBLISHING_TOPIC: " + topic);
            ProducerRecord<String, CommonKafkaDto> producerRecord = new ProducerRecord<>(topic, commonKafkaDto);

            SendResult<String, CommonKafkaDto> result = kafkaTemplate.send(producerRecord).get();
            System.out.println(result.getRecordMetadata());
            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
            return false;
        }
    }
}


//            ListenableFuture<SendResult<String, CommonKafkaDto>> future = kafkaTemplate.send(producerRecord);
//
//            future.addCallback(new ListenableFutureCallback<SendResult<String, CommonKafkaDto>>() {
//
//                @Override
//                public void onSuccess(SendResult<String, CommonKafkaDto> result) {
//
//                }
//
//                @Override
//                public void onFailure(Throwable ex) {
//
//                }
//            });
