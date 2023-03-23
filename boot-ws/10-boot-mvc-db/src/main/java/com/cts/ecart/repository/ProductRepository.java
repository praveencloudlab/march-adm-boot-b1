package com.cts.ecart.repository;

import com.cts.ecart.entity.Price;
import com.cts.ecart.entity.Product;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query(name = "q1",value = "from Product")
    List<Product> getProducts();

    // find by name
    @Query(name = "q2",value = "from Product as p  where p.productName like ?1")
    List<Product> searchByName(String pname);

    @Query(name = "q2",value = "from Product as p  where p.productName like:pname")
    List<Product> searchByNamev1(String pname);

    @Query(name = "q2",value = "from Product as p  where p.productName like:prodName")
    List<Product> searchByNameV3(@Param("prodName")  String s1);

    @Query(name = "q2",value = "from Product as p  where p.productName like:#{#prod.productName}")
    List<Product> searchByNameV4(@Param("prod")  Product prod);

    // get
    // price of a given product ID
    @Query(name = "q3",value = "select p.price.productPrice from Product p where p.productId=:productId")
    double getPrice(int productId);

    @Query(name = "q4",value = "select p2.productPrice from Product p1 join Price p2 on p2.priceId=p1.price.priceId where p1.productId=:prodId")
    double getPriceV1(int prodId);

  // select productPrice from Price pr ,Product prod where pr.priceId = prod.priceId and productId :=?







}