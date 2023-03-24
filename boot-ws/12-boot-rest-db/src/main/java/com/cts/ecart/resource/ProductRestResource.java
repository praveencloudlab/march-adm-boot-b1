package com.cts.ecart.resource;

import com.cts.ecart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cts.ecart.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@CrossOrigin
public class ProductRestResource {

    @Autowired
    private ProductRepository prodRepo;

    @GetMapping
    public List<Product> findAllProducts(){
        List<Product> prods=prodRepo.findAll();
        return prods;
    }

    @GetMapping("/{productId}")
    public Product findById(@PathVariable int productId){
        return prodRepo.findById(productId).orElse(null);
    }








}
