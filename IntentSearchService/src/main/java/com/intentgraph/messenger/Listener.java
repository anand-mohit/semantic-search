package com.intentgraph.messenger;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.intentgraph.controller.IntentController;
import com.intentgraph.domain.IntentSearchResult;
import com.intentgraph.domain.NerModel;
import com.intentgraph.service.MainService;
import com.intentgraph.service.SameAsInterface;
import com.intentgraph.service.SameAsService;

@Service
public class Listener {

	@Autowired
	SameAsInterface sameAsService;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@KafkaListener(topics = "nerproducer5")

	public void listen(NerModel record) {
		System.out.println("Intent Service is listening");

		// for (int i=0;i<record.getQuery().length;i++)
		// System.out.println(record.getConcepts()[i]);
		//
		// String[] query= {"define", "interface"};

		System.out.println("intent search is listening");
		String words = "";
		IntentSearchResult intentSearchResult = new IntentSearchResult();
		String intent = "default";

		for (int i = 0; i < record.getWords().size(); i++) {
			words = record.getWords().get(i);
			try {
				System.out.println(words);
				intent = sameAsService.findquerybyname(words);
				System.out.println("intenttt" + intent);

			} catch (NullPointerException e) {
				e.getMessage();
			}
			
		}
		if(intent=="default")
			intent="Basic";

		intentSearchResult.setIntent(intent);
		String concept = "";
		ArrayList keywords=record.getKeywords();
		for (int anj=0;anj<record.getKeywords().size();anj++) {
			System.out.println(keywords.get(anj));
				concept+=keywords.get(anj)+" ";
		}
		intentSearchResult.setConcept(concept);
		System.out.println("listening?" + intent);
		System.out.println("CONCEPT" + concept);
		countDownLatch1.countDown();
	}
}
