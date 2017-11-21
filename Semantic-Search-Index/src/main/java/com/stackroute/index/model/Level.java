package com.stackroute.index.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;

public class Level {

	@GraphId
	private Long id;

	@Property(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Level(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level() {
	}

}
