package com.stackroute.domain;

import org.springframework.data.mongodb.core.mapping.Document;

//Domain Concept Model
@Document(collection="domainconceptdatabase")
public class DomainConcept {
	private String domain;
	private String concept;

	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getConcept() {
		return concept;
	}
	public void setConcept(String concept) {
		this.concept = concept;
	}
	
	
	public DomainConcept() {
		
	}

}
