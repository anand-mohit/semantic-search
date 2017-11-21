package com.stackroute.neo4j.messenger;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.neo4j.domain.Indicator;

@Service
public class Sender {
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Collection<Indicator>> kafkaTemplate1;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	
	String kafkaTopic = "neoproducer1";
	String kafkaTopic1 = "intent";
	
//	public void send(String message) {
//	    kafkaTemplate.send(kafkaTopic, message);
//	}
	
	public void sendclass(String user) {
//		System.out.println(user[0]);
		kafkaTemplate.send(kafkaTopic,user);
	}
	
	public void sendclass(Collection<Indicator> user) {
//		System.out.println(user[0]);
		kafkaTemplate1.send(kafkaTopic1,user);
	}
}