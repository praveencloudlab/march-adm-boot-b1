package com.cts.ecart.repository;

import com.cts.ecart.entity.Price;
import com.cts.ecart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // DSL  ::: Domain Specif language
    List<Product> findByProductName(String name);
    List<Product> findByProductNameLike(String name);

    // filter products by price
    List<Product> findByPriceProductPriceGreaterThanEqual(double price);
   List<Product> findByPriceProductPriceBetween(double startPrice,double endPrice);
   List<Product> findByPriceProductPriceBetweenAndRatingGreaterThanEqual(double startPrice,double endPrice,double rating);


   // QUERY
   // =========
    //@Query(name = "q1",value = "select p1.product_id, p1.keywords,p1.price_id,p1.product_image,p1.product_name,p1.rating,p1.stock_id from com.cts.ecart.entity.Product p1 left join com.cts.ecart.entity.Price p2 on p2.price_id=p1.price_id where p2.product_price between ? and ? and p1.rating>=?")
    //List<Product> m1();





}