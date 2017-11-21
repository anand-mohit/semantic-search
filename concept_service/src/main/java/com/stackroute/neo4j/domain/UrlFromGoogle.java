package com.stackroute.neo4j.domain;



import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
public class UrlFromGoogle {

	public UrlFromGoogle() {
		super();
	}

	@GraphId
	private Long id;

	@Property(name="name")
	private String name;

	public UrlFromGoogle(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
