package com.stackroute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.domain.DomainConcept;
import com.stackroute.domain.SearchResultsModel;

//Crud Repository
@Repository
public interface ApiRepository extends CrudRepository<DomainConcept,Long> {

	

}
