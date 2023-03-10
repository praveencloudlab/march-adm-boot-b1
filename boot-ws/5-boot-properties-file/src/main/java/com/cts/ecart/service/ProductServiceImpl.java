package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
	
	@Value("${name}")
	private String personName;
	
	
	
	@Bean
	@Profile(value = "dev")
	void f1() {
		System.out.println("Person name - f1 :: "+personName);
	}
	
	@Bean
	@Profile(value = "test")
	void f2() {
		System.out.println("Person name - f2 :: "+personName);
	}

}
