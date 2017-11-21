package com.stackroute.index.messenger;

import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.index.exception.NoInputException;
import com.stackroute.index.model.IndexerModel;
import com.stackroute.index.model.Indicator;
import com.stackroute.index.model.ParserModel;
import com.stackroute.index.service.IndexService;

public class Listener {
	Logger log = Logger.getLogger(getClass());

	@Autowired
	IndexService indexservice;

	@Autowired
	private IndexerModel indexermodel;

	Collection<Indicator> termweight;

	public Collection<Indicator> getTermweight() {
		return termweight;
	}

	public void setTermweight(Collection<Indicator> termweight) {
		this.termweight = termweight;
	}

	@Autowired
	Sender sender;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	// public final CountDownLatch countDownLatch2 = new CountDownLatch(2);

	// listen term score for intent from parser
	@KafkaListener(topics = "${semantic.kafka.topic.consumer1}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(ParserModel record) throws NoInputException {
		
		log.info("Received Data " + record);

		log.info("Url : " + record.getUrl());
		log.info("domain : " + record.getDomain());
		log.info("concept : " + record.getConcept());
		log.info("title : " + record.getTitle());
		log.info("snippet : " + record.getSnippet());
		log.info("map : " + record.getTerms());

		IndexerModel indexmodel = new IndexerModel();

		indexmodel.setUrl(record.getUrl());
		indexmodel.setDomain(record.getDomain());
		indexmodel.setConcept(record.getConcept());
		indexmodel.setTitle(record.getTitle());
		indexmodel.setSnipet(record.getSnippet());

		indexmodel.setCsmap(indexservice.getScore(record.getTerms()));

		setIndexermodel(indexmodel);

		log.info("output: " + indexmodel.getCsmap());

		sender.send(indexmodel);

		countDownLatch1.countDown();
	}

	public IndexerModel getIndexermodel() {
		return indexermodel;
	}

	public void setIndexermodel(IndexerModel indexermodel) {
		this.indexermodel = indexermodel;
	}

	// get intent term weight for neo4j intent graph
	// @KafkaListener(topics = "",containerFactory="kafkaListenerContainerFactoryneo")
	// public void listen(Collection<Indicator> record) {
	// log.info("Received Data " + record);
	// setTermweight(record);

	// log.info("Id: " + record.getId());
	// log.info("Weight: " + record.getWeight());
	// log.info("Terms: " + record.getTerms());
	// log.info("Levels: " + record.getLevel());
	// }
}
