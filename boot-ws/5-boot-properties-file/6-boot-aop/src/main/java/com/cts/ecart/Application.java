package com.cts.ecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.cts.ecart.service.ProductServiceImpl;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		ProductServiceImpl ps = context.getBean(ProductServiceImpl.class);
		
		ps.productSave();
		
		
		
		/*
		ps.productSave();
		ps.productDelete();
		ps.productRowCount();
		ps.productBatch();
		//ps.findAllProducts();
		 */
	}

}
