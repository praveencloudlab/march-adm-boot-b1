package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cts.ecart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier(value = "productOracleRepositoryImpl")
	private final ProductRepository prodRepo=null;
	
	//constructor based autowiring


	//public ProductServiceImpl(ProductRepository prodRepo) {
	//	this.prodRepo = prodRepo;
	//}

	@Override
	public void saveProduct() {
		// repository save method
		System.out.println("ProductServiceImpl :: saveProduct");
		prodRepo.save();
	}

	
}
