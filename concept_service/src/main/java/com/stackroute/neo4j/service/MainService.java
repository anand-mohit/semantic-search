package com.stackroute.neo4j.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.neo4j.controller.TermsController;
import com.stackroute.neo4j.domain.Concept1;
import com.stackroute.neo4j.domain.Concept2;
import com.stackroute.neo4j.domain.Related;
import com.stackroute.neo4j.domain.Same;
import com.stackroute.neo4j.domain.Subconcept;

@Service
public class MainService {
	
	@Autowired
	SubconceptService subconceptService;
	
	@Autowired
	RelatedService relatedService;

	@Autowired
	SameService sameService;
	
	public void saveNewSubconcept()
	{
		FileReader f, fe;
        try {
            f = new FileReader("/home/priya/Desktop/concepts.csv");
            BufferedReader br = new BufferedReader(f);
            TermsController t = new TermsController(subconceptService, relatedService, sameService);
            String header;
            header = br.readLine();
            String[] columnss = header.split(",");
            for (int i = 0; i < columnss.length; i++) {
                columnss[i] = columnss[i].trim();
            }
            String line2;
            while ((line2 = br.readLine()) != null) {
                String[] rows = line2.split(",");
                if (rows.length == 9) {
                    if (rows[5].equals("subconcept of")) {
                        fe = new FileReader("/home/priya/Desktop/concepts.csv");
                        BufferedReader bro = new BufferedReader(fe);
                        Subconcept subconcept = new Subconcept();
                        Concept1 concept1 = new Concept1(rows[1].trim(), rows[6].trim(), rows[8].trim());
                        subconcept.setConcept1(concept1);
                        String linee, levelname = "0", context = "0", description = "0";
                        while ((linee = bro.readLine()) != null) {
                            String[] rowss = linee.split(",");
                            if (rowss[0].equals(rows[2])) {
                                levelname = rowss[1];
                                context = rowss[6];
                                description = rowss[8];
                                break;
                            }
                        }
                        try {
                            Concept2 concept2 = t.graph_concept(levelname);
                            subconcept.setConcept2(concept2);
                            subconcept.getConcept2().getName();
                        } catch (NullPointerException e) {
                            Concept2 concept2 = new Concept2(levelname, context, description);
                            subconcept.setConcept2(concept2);
                            subconcept.getConcept2().getName();
                        }
                        t.saveNewSubconcept(subconcept);
                    }
                }
            }
        } 
        catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } 
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void saveNewSubconcept1()
	{
		FileReader f, fe;
        try {
            f = new FileReader("/home/priya/Desktop/concepts.csv");
            BufferedReader br = new BufferedReader(f);
            TermsController t = new TermsController(subconceptService, relatedService, sameService);
            String header;
            header = br.readLine();
            String[] columnss = header.split(",");
            for (int i = 0; i < columnss.length; i++) {
                columnss[i] = columnss[i].trim();
            }
            String line2;
            while ((line2 = br.readLine()) != null) {
                String[] rows = line2.split(",");
                if (rows.length == 9) {
                    if (rows[5].equals("related")) {
                        fe = new FileReader("/home/priya/Desktop/concepts.csv");
                        BufferedReader bro = new BufferedReader(fe);
                        Related related = new Related();
                        Concept1 concept1 = new Concept1(rows[1].trim(), rows[6].trim(), rows[8].trim());
                        related.setConcept1(concept1);
                        String linee, levelname = "0", context = "0", description = "0";
                        while ((linee = bro.readLine()) != null) {
                            String[] rowss = linee.split(",");
                            if (rowss[0].equals(rows[2])) {
                                levelname = rowss[1];
                                context = rowss[6];
                                description = rowss[8];
                                break;
                            }
                        }
                        try {
                            Concept2 concept2 = t.graph_concept(levelname);
                            related.setConcept2(concept2);
                            related.getConcept2().getName();
                        } catch (NullPointerException e) {
                            Concept2 concept2 = new Concept2(levelname, context, description);
                            related.setConcept2(concept2);
                            related.getConcept2().getName();
                        }
                        t.saveNewSubconcept1(related);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            // TODO Auto-generated catch block
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void saveNewSubconcept2()
	{
		FileReader f, fe;
        try {
            f = new FileReader("/home/priya/Desktop/concepts.csv");
            BufferedReader br = new BufferedReader(f);
            TermsController t = new TermsController(subconceptService, relatedService, sameService);
            String header;
            header = br.readLine();
            String[] columnss = header.split(",");
            for (int i = 0; i < columnss.length; i++) {
                columnss[i] = columnss[i].trim();
            }
            String line2;
            while ((line2 = br.readLine()) != null) {
                String[] rows = line2.split(",");
                if (rows.length == 9) {
                    if (rows[5].equals("same as")) {
                        fe = new FileReader("/home/priya/Desktop/concepts.csv");
                        BufferedReader bro = new BufferedReader(fe);
                        Same same = new Same();
                        Concept1 concept1 = new Concept1(rows[1].trim(), rows[6].trim(), rows[8].trim());
                        same.setConcept1(concept1);
                        String linee, levelname = "0", context = "0", description = "0";
                        while ((linee = bro.readLine()) != null) {
                            String[] rowss = linee.split(",");
                            if (rowss[0].equals(rows[2])) {
                                levelname = rowss[1];
                                context = rowss[6];
                                description = rowss[8];
                                break;
                            }
                        }
                        try {
                            Concept2 concept2 = t.graph_concept(levelname);
                            same.setConcept2(concept2);
                            same.getConcept2().getName();
                        } catch (NullPointerException e) {
                            Concept2 concept2 = new Concept2(levelname, context, description);
                            same.setConcept2(concept2);
                            same.getConcept2().getName();
                        }
                        t.saveNewSubconcept2(same);
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            // TODO Auto-generated catch block
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	}
	

