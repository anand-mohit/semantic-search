package com.example.stemmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This REST API is used to stem the input query so that different forms of the same 
 * input search query is recognized by the computer to be the same
 */

@SpringBootApplication
public class StemmerApp {

	public static void main(String[] args) {
		SpringApplication.run(StemmerApp.class, args);
	}
}
