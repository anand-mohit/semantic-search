package com.stackroute.crawler.controller;



import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.stackroute.crawler.exception.UrlNotFound;
import com.stackroute.crawler.service.CrawlerServices;
import com.stackroute.crawler.service.KafkaSender;

@RestController
@RequestMapping()
public class ApacheKafkaWebController {

	//to create KafkaSender object
	@Autowired
	KafkaSender kafkaSender;

	//to create CrawlerServices object
	CrawlerServices crawlerServices=new CrawlerServices();
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	//method to retrieve xml page and send to kafka
	@RequestMapping()
	public ResponseEntity<?> getOneResults() throws FailingHttpStatusCodeException, MalformedURLException, IOException, UrlNotFound {

		String url="https://sourceforge.net/";
		
		//to retrieve xml page
		String pageContent=crawlerServices.PageContent(url);
		if(pageContent == null )throw new UrlNotFound("Url Cannot Be Crawled");
//		System.out.println(pageContent);
		else {
		//to send to kafka
		kafkaSender.send(pageContent);
		return new ResponseEntity<String>(pageContent, HttpStatus.OK);}
	}
	
	

}