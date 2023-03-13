package com.cts.ecart.service;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
	
	public Object productRowCount() {
		return 100;
	}

	
	public void productBatch() {
		System.out.println("Pfroduct batch operations");
		throw new RuntimeException("Batch process has some issue");
	}
	public Boolean productSave() {
		System.out.println(">>>>> save Product method is being processed..");
		//throw new RuntimeException("some issue..");
		return true;
	}

	public void productUpdate() {
		System.out.println("update Product");

	}

	public void finfProductById() {
		System.out.println("find Product");
	}
	
	public void findAllProducts() {
		System.out.println("finding all products");
	}

	public void productDelete() {
		System.out.println("delete Product");

	}

}
