package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope("prototype")
@Lazy(value = true)
public class ProductServiceImpl {

	
	public static void test() {}
	
	@Autowired
	private Environment env;
	
	public ProductServiceImpl() {
		System.out.println(">>>> 1.ProductServiceImpl object creted on "+this.hashCode());
	}
	
	// post construct
	@PostConstruct
	public void f1() {
		System.out.println(">>>> 2.post construct on "+this.hashCode());
	}
	

    // bean
    @Bean // creates new object in-case of prototype scope for non static bean type
    // bean doesn't work in-case of lazy type
    static void f2() {
        System.out.println(">>>> 3.bean :: f2 ");
        
    }
    
    @Bean // creates new object in-case of prototype scope for non static bean type
    // bean doesn't work in-case of lazy type
    static void f22() {
        System.out.println(">>>> 3.bean :: f22 ");
    }
    
    
    public void f33() {
    	System.out.println("name:: "+env.getProperty("pname"));
    }
 


    // pre-destroy
    @PreDestroy // prototype scope, PreDestroy will not work
    void f3() {
    	System.out.println(">>>> 4.pre-destroy on "+this.hashCode());
    }
	

}
