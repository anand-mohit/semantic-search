package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.UrlFromGoogle;
import com.stackroute.neo4j.domain.UrlRelation;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.repository.SubconceptRepository;
import com.stackroute.neo4j.repository.UrlFromGoogleRepository;
import com.stackroute.neo4j.repository.UrlRelationRepository;
import com.stackroute.neo4j.repository.ConceptRepository;


@Service
public class UrlService {

	@Autowired
	UrlFromGoogleRepository urlFromGoogleRepository;
	
	@Autowired
	UrlRelationRepository urlRelationRepository;


	@Transactional(readOnly = true)
	public  Iterable<UrlRelation>  graph_url() {
		 Iterable<UrlRelation> result = urlRelationRepository.findAll();
		return result;
	}
	

	
	@Transactional(readOnly = true)
	public UrlRelation  postnode(UrlRelation subconcept) {

		UrlRelation result = urlRelationRepository.save(subconcept);
		return subconcept;
	}
	
	
	
	@Transactional(readOnly = true)
	public UrlFromGoogle  findlevelbyname(String name) {
		UrlFromGoogle result = urlFromGoogleRepository.findByName(name);
		return result;
	}


	
}
