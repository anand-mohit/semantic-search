package com.example.stemmer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tartarus.snowball.SnowballProgram;
import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.EnglishStemmer;
import org.tartarus.snowball.ext.PorterStemmer;
import org.tartarus.snowball.ext.englishStemmer;

import com.example.stemmer.domain.StemmedQuery;
import com.example.stemmer.service.StemmerAppService;

import java.io.IOException;

import org.apache.log4j.*;
/*
 * Controller for the entire REST API
 */

@RestController
@RequestMapping("/stem")

public class StemmerAppController {

	StemmerAppService stemmerAppService = new StemmerAppService();
	
//	The below method routes the flow of execution and stems the input query
	@RequestMapping(method=RequestMethod.GET)
		public ResponseEntity<?> stemmedWord(){
			StemmedQuery stemmedQuery = new StemmedQuery();
			String query="configuring starter sleeping breathed";
			String result = stemmerAppService.getStemmedQuery(query).getStemmerQuery();
			stemmedQuery.setStemmerQuery(result);
			//System.out.println(stemmedQuery.getStemmerQuery());
			Logger logger = Logger.getLogger(getClass());
			logger.info(stemmedQuery.getStemmerQuery());
			return new ResponseEntity(stemmedQuery, HttpStatus.OK);
		}
	}