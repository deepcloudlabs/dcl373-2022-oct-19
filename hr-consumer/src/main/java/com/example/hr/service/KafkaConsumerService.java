package com.example.hr.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = "events", groupId = "apple")
	public void listenEvent(String event) {
		System.out.println("KafkaConsumerService: %s".formatted(event));
	}
}
