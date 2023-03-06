package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.config.AppConfig;
import com.cts.ecart.service.ProductServiceImpl;

public class Test {
	
	/*
	 * Types of Java Objects? : 2 types
	 * ===========================================
	 * 1.dependency: never depend on any other objects.
	 * 2.dependent : always depends on dependency
	 * 
	 * 
	 * 
	 */

	public static void main(String[] args) {
		
		String[] cart1= {"P001","P002"};
		
		//==========================================================
		//ProductDaoImpl price=new ProductDaoImpl();
		
		//ProductServiceImpl prodService=new ProductServiceImpl();
		//===========================================================
		
		 ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		// prodService needs price object to get item price 
	
		 ProductServiceImpl prodService=ac.getBean(ProductServiceImpl.class);
		 
		 //prodService.setPrice(price); // DI : Injecting dependency(price) to the dependent(prodService) object
		
		double  cartTotal=prodService.getCartTotal(cart1);
		System.out.println("cart1 total: "+cartTotal);
		
		 

	}

}
