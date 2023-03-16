package com.cts.ecart;

import com.cts.ecart.entity.Product;
import com.cts.ecart.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

       ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
       ProductRepository prodRepo=context.getBean(ProductRepository.class);

       // save
        Product p1=new Product(12,"Mouse",1200);
        Product p2=new Product(13,"Book",543);
        Product p3=new Product(14,"Fan",1800);
        Product p4=new Product(15,"Watch",18000);
        Product p5=new Product(16,"Mobile",35000);

        List<Product> prods=Arrays.asList(p1,p2,p3,p4,p5);

        //prodRepo.save(p1);
       // prodRepo.saveAll(prods);

        // fetch all records;

      //  prodRepo.findAll().forEach(System.out::println);

        // pull out only one record
       // Product prod=prodRepo.findById(16).orElse(null);

        //System.out.println(prod);

        //Product p6=new Product(1982,"Mouse",1200);
       // prodRepo.save(p6);





    }

}
