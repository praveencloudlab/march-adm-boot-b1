package com.cts.ecart.resource;

import com.cts.ecart.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductRestResource {



    @GetMapping
    public Product f1(){
        return new Product(1,"Pen",487.43);
    }

    @GetMapping(value = "/{id}")
    public String f11(@PathVariable int id){
        return "You have provided ID: "+id;
    }

    @GetMapping(value = "byName/{name}")
    public String f111(@PathVariable String name){
        return "You have provided NAME: "+name;
    }

    @PostMapping
    public Product f2(@RequestBody Product prod){
        System.out.println(prod);
        return prod;
    }

    @PutMapping
    public String f3(){
        return "PUT MAPPING";
    }

    @DeleteMapping
    public String f4(){
        return "DELETE MAPPING";
    }


}
