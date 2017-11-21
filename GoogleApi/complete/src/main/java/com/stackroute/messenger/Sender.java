package com.stackroute.messenger;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.stackroute.domain.SearchResultsModel;

@Service
public class Sender {
	
	@Autowired
	private KafkaTemplate<String,SearchResultsModel > kafkaTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	
	String kafkaTopic = "tatte";
	

	public void send(SearchResultsModel a) {
		System.out.println("sending message"+a);
	    kafkaTemplate.send(kafkaTopic, a);
		
	}
}