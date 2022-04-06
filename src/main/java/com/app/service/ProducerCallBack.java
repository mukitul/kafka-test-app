package com.app.service;

import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerCallBack implements Callback {
    @SneakyThrows
    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if(null!=e){
            throw new Exception("Failed to write message in kafka");
        }
    }
}
