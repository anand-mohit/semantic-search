package com.stackroute.Parser.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.stackroute.Parser.Services.ParserServices;

@RestController
public class ParserController  {

	ParserServices parserServices =new ParserServices();
	String[] keywords = { "angular-cli","angular","install" };
	String url="https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App";
	
	public String getOneResults1(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
	WebClient webclient = new WebClient();
	webclient.getOptions().setJavaScriptEnabled(false);
	HtmlPage page = webclient.getPage(url);
	String pageContent = page.asXml();
	return pageContent;
	}
	
	
	@RequestMapping("/result")
	public ResponseEntity<?> getOneResults() throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		Map<String,Integer> queryResult=parserServices.QueryResult(getOneResults1(url),keywords);
		return new ResponseEntity<Map<String,Integer>>(queryResult,HttpStatus.OK);
	}
	
	@RequestMapping("/meta")
	public ResponseEntity<?> getMetatags() throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		Map<String, Integer> queryResult=parserServices.MetaKeywords(getOneResults1(url), keywords);
		return new ResponseEntity<Map<String,Integer>>(queryResult,HttpStatus.OK);
	}
	
	@RequestMapping()
	public ResponseEntity<?> getUrlScore() throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		getMetatags();
		getOneResults();
		int contentscore=parserServices.titleScore(url, keywords)+
				parserServices.h1Score(url, keywords)+
				parserServices.h2Score(url, keywords)+
				parserServices.h3Score(url, keywords)+
				parserServices.h4Score(url, keywords)+
				parserServices.h5Score(url, keywords)+
				parserServices.h6Score(url, keywords)+
				parserServices.pScore(url, keywords)
				;
		
		
		int score=  contentscore+ parserServices.score();
		return new ResponseEntity<Integer>(score,HttpStatus.OK);
	}
	
	
}
