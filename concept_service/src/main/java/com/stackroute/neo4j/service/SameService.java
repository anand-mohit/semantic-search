package com.stackroute.neo4j.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.repository.Concept1Repository;
import com.stackroute.neo4j.repository.ConceptRepository;
import com.stackroute.neo4j.repository.SameRepository;


@Service
public class SameService {

	@Autowired
	SameRepository sameRepository;
	
	@Autowired
	ConceptRepository conceptRepository;
	
	@Autowired
	Concept1Repository concept1Repository;


	@Transactional(readOnly = true)
	public  Iterable<Same>  graph_terms(int limit) {
		 Iterable<Same> result = sameRepository.findAll();
		return result;
	}
	

	
	@Transactional(readOnly = true)
	public Same  postnode(Same same) {
		Same result = sameRepository.save(same);
		return same;
	}
	
	
	
	@Transactional(readOnly = true)
	public Concept2  findlevelbyname(String name) {
		Concept2 result = conceptRepository.findByName(name);
		return result;
	}


	@Transactional(readOnly = true)
	public Concept2 findlevelbynamee(String word) {

		//System.out.println("zor se bolo");
		Concept2 result = conceptRepository.findByName(word);
		System.out.println(result);	
		System.out.println(result.getName());
		System.out.println(result.getId());
		return result;
	}

	@Transactional(readOnly = true)
	public Concept1 findlevelbyname1(String word) {
		Concept1 result = null;
		//System.out.println("jai mata di");
		result = concept1Repository.findByName(word);
		System.out.println(result.getName());
		System.out.println(result.getId());

		return result;
	}
	
	
}
