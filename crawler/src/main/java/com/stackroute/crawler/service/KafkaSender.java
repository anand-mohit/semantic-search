package com.stackroute.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);
	
	
	String kafkaTopic = "crawlerproducer";
	
	public void send(String message) {
	    kafkaTemplate.send(kafkaTopic, message);
	}
}