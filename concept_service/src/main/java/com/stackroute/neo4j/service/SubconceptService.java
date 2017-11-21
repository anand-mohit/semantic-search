package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.repository.SubconceptRepository;
import com.stackroute.neo4j.repository.Concept1Repository;
import com.stackroute.neo4j.repository.ConceptRepository;


@Service
public class SubconceptService {

	@Autowired
	SubconceptRepository subconceptRepository;
	
	@Autowired
	ConceptRepository conceptRepository;
	
	@Autowired
	Concept1Repository concept1Repository;


	@Transactional(readOnly = true)
	public  Iterable<Subconcept>  graph_terms(int limit) {
		 Iterable<Subconcept> result = subconceptRepository.findAll();
		return result;
	}
	

	
	@Transactional(readOnly = true)
	public Subconcept  postnode(Subconcept subconcept) {
		Subconcept result = subconceptRepository.save(subconcept);
		return subconcept;
	}
	
	
	
	@Transactional(readOnly = true)
	public Concept2  findlevelbyname(String name) {
		Concept2 result = conceptRepository.findByName(name);
		System.out.println(result.getName());
		System.out.println(result.getId());
		return result;
	}
	
	@Transactional(readOnly = true)
	public Concept2 findlevelbynamee(String word) {

	//	System.out.println("inside Concept 2");
		Concept2 result = conceptRepository.findByName(word);
		//System.out.println(result);	
		System.out.println(result.getName());
		System.out.println(result.getId());
		return result;
	}

	@Transactional(readOnly = true)
	public Concept1 findlevelbyname1(String word) {
		Concept1 result = null;
	//	System.out.println("inside Concept 1");
		result = concept1Repository.findByName(word);
		System.out.println(result.getName());
		System.out.println(result.getId());

		return result;
	}


	
}
