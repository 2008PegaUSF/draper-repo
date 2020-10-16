package com.revature.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BasicController {

	/*
	 * @Value retrieves configuration attirbutes form the config file. 
	 */
	
	//Dynamically creates configuration values. In this case message attribute does not exist in the config file.
	@Value("${message: Here is my special message, all the way from config!}")
	public String message;
	
	//This @Value is retrieving a config attribute called "server.port"
	@Value("${server.port}")
	public String serverPort;
	
	
	@GetMapping("/")
	public String hello() {
		return "Hello there, welcome to my service. We're currently in port number: " + serverPort;
	}
	
	@GetMapping("/message")
	public String message() {
		return message;
	}
	
}
