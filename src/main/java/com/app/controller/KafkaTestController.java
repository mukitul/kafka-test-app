package com.app.controller;

import com.app.dto.CommonKafkaDto;
import com.app.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class KafkaTestController {

    private final ProducerService producerService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage(@RequestBody CommonKafkaDto commonKafkaDto) {
        return new ResponseEntity<>(producerService.publish(commonKafkaDto), HttpStatus.OK);
    }
}
