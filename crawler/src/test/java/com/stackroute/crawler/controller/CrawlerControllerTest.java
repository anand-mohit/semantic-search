package com.stackroute.crawler.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.never;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.stackroute.crawler.controller.ApacheKafkaWebController;

import junit.framework.TestCase;

public class CrawlerControllerTest {

	@Spy
	private ApacheKafkaWebController apacheKafkaWebController;
	TestRestTemplate restTemplate = new TestRestTemplate();

	private String createURLWithPort() {
		return "http://localhost:8080";
	}

	//test to check that an xml file is being retrieved
	@Test
	public void testSaveUser() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ApacheKafkaWebController> entity = new HttpEntity<ApacheKafkaWebController>(apacheKafkaWebController,
				headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort(), HttpMethod.GET, entity,
				String.class);
		assertNotNull(response);

	}

}
