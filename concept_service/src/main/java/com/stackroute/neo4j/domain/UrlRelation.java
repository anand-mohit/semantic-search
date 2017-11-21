package com.stackroute.neo4j.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "url_of")
public class UrlRelation {

	@GraphId
	private Long id;
	
	private float basicsscore;
	
	private float tutorialscore;
	
	private float examplescore;
	
	private float completereferencesscore;

	private float troubleshootingsscore;

	@StartNode
	private UrlFromGoogle urlFromGoogle;

	@EndNode
	private Concept2 concept2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getBasicsscore() {
		return basicsscore;
	}

	public void setBasicsscore(float basicsscore) {
		this.basicsscore = basicsscore;
	}

	public float getTutorialscore() {
		return tutorialscore;
	}

	public void setTutorialscore(float tutorialscore) {
		this.tutorialscore = tutorialscore;
	}

	public float getExamplescore() {
		return examplescore;
	}

	public void setExamplescore(float examplescore) {
		this.examplescore = examplescore;
	}

	public float getCompletereferencesscore() {
		return completereferencesscore;
	}

	public void setCompletereferencesscore(float completereferencesscore) {
		this.completereferencesscore = completereferencesscore;
	}

	public float getTroubleshootingsscore() {
		return troubleshootingsscore;
	}

	public void setTroubleshootingsscore(float troubleshootingsscore) {
		this.troubleshootingsscore = troubleshootingsscore;
	}

	public UrlFromGoogle getUrlFromGoogle() {
		return urlFromGoogle;
	}

	public void setUrlFromGoogle(UrlFromGoogle urlFromGoogle) {
		this.urlFromGoogle = urlFromGoogle;
	}

	public Concept2 getConcept2() {
		return concept2;
	}

	public void setConcept2(Concept2 concept2) {
		this.concept2 = concept2;
	}

	public UrlRelation() {
		super();
	}

	public UrlRelation(float basicsscore, float tutorialscore, float examplescore, float completereferencesscore,
			float troubleshootingsscore, UrlFromGoogle urlFromGoogle, Concept2 concept2) {
		super();
		this.basicsscore = basicsscore;
		this.tutorialscore = tutorialscore;
		this.examplescore = examplescore;
		this.completereferencesscore = completereferencesscore;
		this.troubleshootingsscore = troubleshootingsscore;
		this.urlFromGoogle = urlFromGoogle;
		this.concept2 = concept2;
	}


}

