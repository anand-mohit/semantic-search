package com.example.stemmer.domain;

/*
 * Contains the final stemmed query obtained after stemming as the only property
 * which is stored here
 */

public class StemmedQuery {

	String stemmerQuery;
	
	public StemmedQuery(String stemmerQuery) {
		super();
		this.stemmerQuery = stemmerQuery;
	}
	
	public StemmedQuery() {
		
	}

	public String getStemmerQuery() {
		return stemmerQuery;
	}

	public void setStemmerQuery(String stemmerQuery) {
		this.stemmerQuery = stemmerQuery;
	}

	@Override
	public String toString() {
		return "StemmedQuery [stemmerQuery=" + stemmerQuery + "]";
	}
	
}
