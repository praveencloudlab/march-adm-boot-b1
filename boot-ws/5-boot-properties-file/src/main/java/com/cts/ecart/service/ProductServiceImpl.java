package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
	
	//@Value("${name}")
	//private String personName;
	
	@Autowired
	private Environment env;
	
	
	
	@Bean
	@Profile(value = "dev")
	void f1() {
		System.out.println("Person name - f1 :: "+env.getProperty("name"));
	}
	
	@Bean
	@Profile(value = "test")
	void f2() {
		System.out.println("Person name - f2 :: "+env.getProperty("name"));
	}

}
