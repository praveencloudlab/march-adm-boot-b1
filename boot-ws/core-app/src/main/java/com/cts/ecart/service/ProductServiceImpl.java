package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.ProductDaoImpl;

//dependent 
@Service
public class ProductServiceImpl {
	
	// get total bill of a cart
	
	/*
	 * 
	 * note
	 * ======
	 * 1.never ever create dependency object in the dependent class directly
	 * 
	 * How to implement IoC?
	 * ==========================
	 * => using Dependency injection
	 * 
	 *  what is Dependency injection?
	 *  ================================
	 *  -> injecting /passing dependency obj to the dependent
	 *  
	 *  how many ways DI can be implemented?
	 *  =======================================
	 *  1.setter based 
	 *  2.constructor based
	 *  
	 *  1.setter based 
	 *  ==================
	 *  => use this technique, incase if you wanted to inject multiple times 
	 *     on top of same obj
	 *     
	 *     Rules
	 *     ========
	 *     1. define dependency obj ref at class level
	 *     2. generate setter for abve defined ref obj
	 *  
	 * 
	 */
	
	@Autowired
	private ProductDaoImpl price;
	
	
	/*
	public void setPrice(ProductDaoImpl price) {
		this.price = price;
	}
	*/


	public double getCartTotal(String[] cart) {
		
		//ProductDaoImpl price=new ProductDaoImpl();// IoC : inversion of control
		// never create, find object. instead, ask some one (container) to inject : (IoC)
		double total=0.0;
		for(String itemCode:cart) {
			total=total+price.findItemPrice(itemCode);
		}
		
		return total;
		
		
	}
	
	

}
