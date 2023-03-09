package com.cts.ecart.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
//@Primary
public class ProductMySQLRepositoryImpl implements ProductRepository {
	
	@Override
	public void save() {
		System.out.println("ProductMySQLRepositoryImpl :: save");
	}
	

}
