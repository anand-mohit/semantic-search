package com.stackroute.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.stackroute.domain.DomainConcept;
import com.stackroute.domain.SearchResultsModel;

//Interface for all the services

public interface ApiService{
	
	public SearchResultsModel callAPI(String apikey,int startIndex) throws Exception;

	public void setDomconc(String domain, String concept);

	public Iterable<DomainConcept> fetchresults() throws Exception;
	
}
