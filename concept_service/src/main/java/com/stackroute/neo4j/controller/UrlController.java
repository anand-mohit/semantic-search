package com.stackroute.neo4j.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jcabi.aspects.Loggable;
import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.UrlFromGoogle;
import com.stackroute.neo4j.domain.UrlRelation;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Related;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.service.RelatedService;
import com.stackroute.neo4j.service.SameService;
import com.stackroute.neo4j.service.SubconceptService;
import com.stackroute.neo4j.service.UrlService;

//url controller class

@Controller
@RequestMapping("/v1.0/semantic/neo4jconceptservice")
public class UrlController {

	final UrlService urlService;

	@Autowired
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}

	@CrossOrigin("*")
	@RequestMapping("/geturl")
	public Iterable<UrlRelation> graph_url() {
		return urlService.graph_url();
	}

	@RequestMapping("/graphurl/{name}")
	public UrlFromGoogle graph_concept(@PathVariable("name") String name) {
		try {
			return urlService.findlevelbyname(name);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	@PostMapping("/posturl")
	public @ResponseBody ResponseEntity<UrlRelation> saveNewSubconcept(@RequestBody UrlRelation urlRelation) {
		try {
			return new ResponseEntity<UrlRelation>(urlService.postnode(urlRelation), HttpStatus.OK);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
}
