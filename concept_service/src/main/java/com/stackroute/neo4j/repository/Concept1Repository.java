package com.stackroute.neo4j.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stackroute.neo4j.domain.Concept1;


	@RepositoryRestResource(collectionResourceRel = "people", path = "level")
	public interface Concept1Repository extends PagingAndSortingRepository<Concept1, Long> {

	public Concept1 findByName(String name);
	
	

	}
	
