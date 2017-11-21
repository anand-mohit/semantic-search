package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Related;
import com.stackroute.neo4j.repository.Concept1Repository;
import com.stackroute.neo4j.repository.ConceptRepository;
import com.stackroute.neo4j.repository.RelatedRepository;


@Service
public class RelatedService {

	@Autowired
	RelatedRepository relatedRepository;
	
	@Autowired
	ConceptRepository conceptRepository;
	
	@Autowired
	Concept1Repository concept1Repository;


	@Transactional(readOnly = true)
	public  Iterable<Related>  graph_terms(int limit) {
		 Iterable<Related> result = relatedRepository.findAll();
		return result;
	}
	

	
	@Transactional(readOnly = true)
	public Related  postnode(Related related) {
		Related result = relatedRepository.save(related);
		return related;
	}
	
	
	
	@Transactional(readOnly = true)
	public Concept2  findlevelbyname(String name) {
		Concept2 result = conceptRepository.findByName(name);
		return result;
	}

	
	@Transactional(readOnly = true)
	public Concept2 findlevelbynamee(String word) {

		System.out.println("inside related  service concept 2");
		Concept2 result = conceptRepository.findByName(word);
		System.out.println(result.getName());
		System.out.println(result.getId());
		return result;
	}

	@Transactional(readOnly = true)
	public Concept1 findlevelbyname1(String word) {
	//	Concept1 result = null;
		System.out.println("inside related service  concept 1");
		Concept1 result = concept1Repository.findByName(word);
		System.out.println(result.getName());
		System.out.println(result.getId());

		return result;
	}
	
	
}
