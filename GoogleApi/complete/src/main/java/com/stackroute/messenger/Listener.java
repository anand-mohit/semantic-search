package com.stackroute.messenger;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.domain.DomainConcept;
import com.stackroute.domain.SearchResultsModel;
import com.stackroute.repository.ApiRepository;
import com.stackroute.services.ApiService;

public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
	
	
	@Autowired
	Sender kafkaSender;
	
	@Autowired
	ApiRepository domainrepository;

	
	DomainConcept dc;
	
	

	
	 @Autowired 
	 ApiService service;
	
	 @KafkaListener(topics = "concept3")
	public void listen(DomainConcept record) {
		 
		 
    	
    	service.setDomconc(record.getDomain(), record.getConcept());
//    	domainrepository.save(savedc);
//    	service.saveDC(record);
    	
    	try {
    		
    		 JSONParser parser = new JSONParser();
    	        Object object = parser.parse(new FileReader("/home/harsh/Dry Run/semanticsearch-master-d8cd5d12209c82456dae8768a9d869026482b5e0/GoogleApi/complete/src/main/java/com/stackroute/github/services/apikeys.json"));
    	        
    	        JSONObject jsonobject = (JSONObject)object;
    	        List<String> list = new ArrayList<>();
    	        JSONArray apikeys = (JSONArray)jsonobject.get("apikeys");
    	        System.out.println(record.getDomain());
    	        System.out.println(record.getConcept());
    	        
    	        
    	        for(Object apik : apikeys) {
//    	        	System.out.println(apik.toString());
    	        	list.add(apik.toString());
    	        }
    	        
    	        int startIndex = 1;
    	        for(int j =0;j<2;j++) {
    	        	String apikey = list.get(j);
    	        	System.out.println(apikey);
    	        	SearchResultsModel a  = service.callAPI(apikey, startIndex);
        	
    	            
    	        	kafkaSender.send(a);
    	        	
    	        	System.out.println(a.getItems().get(0).getDisplayLink());
    	            startIndex = startIndex +10;
    	           
    	            
//    	            userRepository.save(results);
    	        }

    		
		} catch (Exception e) {
			
			
		}
		countDownLatch1.countDown();
	}
}