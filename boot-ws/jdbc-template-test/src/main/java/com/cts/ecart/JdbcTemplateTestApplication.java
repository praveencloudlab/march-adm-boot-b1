package com.cts.ecart;

import com.cts.ecart.lambda.MyInter;
import com.cts.ecart.model.Product;
import com.cts.ecart.repository.ProductrepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

@SpringBootApplication
public class JdbcTemplateTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(JdbcTemplateTestApplication.class, args);
        ProductrepositoryImpl prodRepo=context.getBean(ProductrepositoryImpl.class);
       // Product product=prodRepo.findById(3);

       // if(product!=null){
         //   System.out.println(product);
       // }

       // prodRepo.findAll().forEach(System.out::println);
        //Product prod=prodRepo.findByIdV1(1);
        //System.out.println(prod);
       // prodRepo.findAllV1().forEach(System.out::println);

/*
        MyInter mi=(j, i)->i+j;

        int res=mi.f1(100,200);
        System.out.println(res);

*/

    }

}
