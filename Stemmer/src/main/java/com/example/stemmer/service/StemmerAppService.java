package com.example.stemmer.service;

import org.tartarus.snowball.ext.PorterStemmer;

import com.example.stemmer.domain.StemmedQuery;

/*
 * The Service class for the REST API where the query is parsed and stemmed. Porter's algorithm
 * as provided by SnowBall is used for stemming the query.
 */
public class StemmerAppService {

	PorterStemmer stemmer = new PorterStemmer();
	StemmedQuery stemmedQuery = new StemmedQuery();

	public StemmedQuery getStemmedQuery(String query) {
		
		String result="";
		
//		Breaking the query into individual words to parse the query and stem it
		String[] input = query.split(" ");
		for (String word : input) {

			stemmer.setCurrent(word);
			stemmer.stem();
			result += stemmer.getCurrent()+" ";
			
		}
		result = result.trim();
		stemmedQuery.setStemmerQuery(result);
		return stemmedQuery;
	}
}
