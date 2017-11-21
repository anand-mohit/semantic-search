**﻿Semantic Search**

A Semantic Search Engine built on top of Google Search to improve search accuracy by understanding the searcher's intent and the contextual meaning of terms. This Search Engine automatically populates the ontology based on Domain Expert's input.

**Functional Services**

Details of all the functional services being used.


> Google Service (Harsh Jadav) 

Rest Endpoint Documentation

GET
172.23.238.215:8080/v1/semanticsearch/googleservice

Response:
{

	}


Micro Service Kafka Documentation

Publishing Data Into Kafka

    Kafka Topic: "google"
    Message: 
		{
		  Url result (“https://www.sourceforge.net)
		}



>  Crawler Service (Anjali Moharir)

Rest Endpoint Documentation

GET
172.23.238.215:8080/v1/semanticsearch/ crawlerservice

Request:
{
}


Micro Service Kafka Documentation

Publishing Data Into Kafka

    Kafka Topic: "crawlerproducer"
    Message: 
		{
		    "Url":"www.gogle.com",
		   Page Source document (String)
		}

Consuming Data from Kafka

    Kafka Topic: "google"
    Message: 
		{
			Url result (“https://www.sourceforge.net”)	
		}



>  Parser Service (Mohit Anand))

Rest Endpoint Documentation

GET
172.23.238.212:8080 /v1/semanticsearch/  parserservice
Request:
{
}


Micro Service Kafka Documentation

Publishing Data Into Kafka

    Kafka Topic: "parserproducer"
    Message: 
		{
	              Termscore (Json )
		}

Consuming Data from Kafka

    Kafka Topic: "crawlerproducer"
    Message: 
		{
		          "url":"www.facebook.com"
	              Page Document (String)
		}



>  Indexing Service (Aditya)

Rest Endpoint Documentation

GET
172.23.238.220:8080 /v1/semanticsearch/indexservice
Request:
{
}


Micro Service Kafka Documentation

Consuming Data from Kafka

    Kafka Topic: "parserproducer"
    Message: 
		{
			Termscore (json)	
		}


