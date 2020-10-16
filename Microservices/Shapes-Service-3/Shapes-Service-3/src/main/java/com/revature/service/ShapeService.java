package com.revature.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revature.model.Shape;

@Service
public class ShapeService {

	//These are dependencies
	//private ShapeDao sDao;
	private final RestTemplate restTemplate;
	
	public ShapeService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "goodAllReliable")
	public List<Shape> getShapeList(){
		
		//Defines the URI
		URI uri = URI.create("http://localhost:8100/api/getShapes");
		
		//initialy we have to pass in the URI and we'll receive List<Object>
		//This right here , is us levaraging other services. 
		List<Shape> shapes = (List<Shape>) this.restTemplate.getForObject(uri, List.class);
		
		return shapes;
	}
	
	@HystrixCommand(fallbackMethod = "goodAllReliable")
	public List<Shape> getShapes(){
		
		//Defines the URI
		URI uri = URI.create("http://localhost:8100/shapes/getShapes");
		
		//initialy we have to pass in the URI and we'll receive List<Object>
		//This right here , is us levaraging other services. 
		List<Shape> shapes = (List<Shape>) this.restTemplate.getForObject(uri, List.class);
		
		return shapes;
	}
	
	public String insertShapes() {

		//Defines the URI
		URI uri = URI.create("http://localhost:8100/shapes/insertShapes");
		
		return "Success!";
	}
	
	public List<Shape> goodAllReliable(){
		List<Shape> fakeList = new ArrayList<Shape>();
		
		fakeList.add(new Shape(-1000,"Fakey Fake",0,false));
		
		return fakeList;
	}
}
