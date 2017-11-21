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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jcabi.aspects.Loggable;
import com.stackroute.neo4j.domain.Subconcept;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Related;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.service.MainService;
import com.stackroute.neo4j.service.RelatedService;
import com.stackroute.neo4j.service.SameService;
import com.stackroute.neo4j.service.SubconceptService;
//main controller class
@RestController
@RequestMapping("/v1.0/semantic/neo4jconceptservice")
public class TermsController {
	
	int i=0;
	String[] query= {"JVM","Libraries", "Object","Waterfall", "Tcl"};
	
    final SubconceptService subconceptService;
    final RelatedService relatedService;
    final SameService sameService;
    
    
    @Autowired
	MainService mainService ;
	
    
    
    // constructor to set services by autowiring
    @Autowired
    public TermsController(SubconceptService subconceptService, RelatedService relatedService,
            SameService sameService) {
        this.subconceptService = subconceptService;
        this.relatedService = relatedService;
        this.sameService = sameService;
    }
    // fetch all the concepts of the graph
    @RequestMapping("/graphconcept/{name}")
    public Concept2 graph_concept(@PathVariable("name") String name) {
        try {
            return subconceptService.findlevelbyname(name);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    
    
//    @GetMapping("/graphconcep")
//    public  ResponseEntity<String> graph_concep() {
//    	
//    	
//    //	for (String word:query)
//    //	System.out.println(word);
//        try {
//        	for (String word:query) {
//        	//	switch(i) {
//         	
//        	//	case 0:
//        			Concept2 c2=subconceptService.findlevelbynamee(word);
//
//        		 if (isNull(c2)){
//        				System.out.println("are you even working");
//        				Concept1 c1=subconceptService.findlevelbyname1(word);
//        				System.out.println(c1.getName());
//        			
//        			
//        		}
//        	//	}
////        		case 1:
////        			Concept2 c3=relatedService.findlevelbynamee(word);
////
////        			if(isNull(c3)) {
////        				System.out.println("are you even working");
////        				Concept1 c1=relatedService.findlevelbyname1(word);
////        				System.out.println(c1.getName());
////
////        			}
////        		case 2:
////        			Concept2 c4=sameService.findlevelbynamee(word);
////
////        			if(isNull(c4)) {
////        				//System.out.println("are you even working");
////        				Concept1 c1=sameService.findlevelbyname1(word);
////        				System.out.println(c1.getName());
////
////        			}
////        			
////        		}
//        	//return new ResponseEntity<String>("found", HttpStatus.OK);	
//        		
//        	}
//            return new ResponseEntity<String>("found", HttpStatus.OK);
//            }
//        catch (Exception e) {
//            e.getMessage();
//            return null;
//        }
//    }
//    
    private boolean isNull(Concept1 c2) {
        return c2 == null;
    }
    
    
    @GetMapping("/graphconcep")
    public  ResponseEntity<String> graph_concep() {
    	
    //	for (String word:query)
    //	System.out.println(word);
        try {
        	for (String word:query) {
        //	   System.out.println("wjksfao;skjfdlk");     	
//            Concept2 c2=subconceptService.findlevelbynamee(word);
//           System.out.println(c2);
           // System.out.println("aaaaaaaaaaaaaaa");
          
           // 	System.out.println("are you even working");
            	Concept1 c1=subconceptService.findlevelbyname1(word);
            	System.out.println("found in concept 1");
//            	if (isNull(c1)) {
//            		Concept2 c2=subconceptService.findlevelbynamee(word);
//                 System.out.println("found in concept 2");
//            	}
            
        	}
            return new ResponseEntity<String>("found", HttpStatus.OK);
            } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    
    
    // post relationship subconcept
    @CrossOrigin("*")
    @PostMapping("/postsubconcept")
    public @ResponseBody ResponseEntity<?> saveNewSubconcept(@RequestBody Subconcept subconcept) {
        try {
        System.out.println(subconcept.getName());
            return new ResponseEntity<Subconcept>(subconceptService.postnode(subconcept), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/postsubconcept1")
    public @ResponseBody ResponseEntity<?> saveNewSubconcept1(@RequestBody Related related) {
        try {
            return new ResponseEntity<Related>(relatedService.postnode(related), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/postsubconcept2")
    public @ResponseBody ResponseEntity<?> saveNewSubconcept2(@RequestBody Same same) {
        try {
            return new ResponseEntity<Same>(sameService.postnode(same), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    
    // post all relationships from csv
    @PostMapping("/postcsvsubconcept")
    public @ResponseBody ResponseEntity<String> savefromcsv(@RequestParam String csvname) {
    	
    	mainService.saveNewSubconcept();
    	mainService.saveNewSubconcept1();
    	mainService.saveNewSubconcept2();
        return new ResponseEntity<String>("all nodes created from csv", HttpStatus.OK);
    }
    
    
    
    
        
}