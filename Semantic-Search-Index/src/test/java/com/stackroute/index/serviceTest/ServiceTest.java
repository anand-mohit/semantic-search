package com.stackroute.index.serviceTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stackroute.index.exception.TermNotFoundException;
import com.stackroute.index.service.ScoreService;

public class ServiceTest {

	ScoreService indexService=new ScoreService();
	
	@Test
	public void testNotNull() {
		try {
			assertNotNull(indexService.findWeight(" beginner"));
		} catch (TermNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testToCheckCS() {
		
		String json ="{\"https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App\":0,\"angular\":36,\"install\":46,\"angular-cli\":3}";
		Map<String, Integer> map = new Gson().fromJson(json, new TypeToken<Map<String, Integer>>(){}.getType());
		List<Double> list= new ArrayList<Double>();
		try {
			list=indexService.findWeight(" beginner");
		} catch (TermNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Double> expectedList= new ArrayList<Double>();
		expectedList.add(0.9);
		expectedList.add(0.7);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		expectedList.add(0.0);
		
		 assertEquals(expectedList,list);		
	}
	
	@Test
	public void testToCheckCSNegative() {
		
		String json ="{\"https://coursetro.com/posts/code/55/How-to-Install-an-Angular-4-App\":0,\"angular\":36,\"install\":46,\"angular-cli\":3}";
		Map<String, Integer> map = new Gson().fromJson(json, new TypeToken<Map<String, Integer>>(){}.getType());
		List<Double> list= new ArrayList<Double>();
		try {
			list=indexService.findWeight(" angular");
		} catch (TermNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Double> expectedList= new ArrayList<Double>();
		expectedList.add(0.0);
		expectedList.add(0.6);
		expectedList.add(0.0);
		
		 assertNotEquals(expectedList,list);
	}

}
