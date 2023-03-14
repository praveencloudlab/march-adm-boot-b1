package com.cts.ecart.repository;

import com.cts.ecart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductrepositoryImpl {

    /**
     *  Domain Object Queries
     *  ========================
     *  1.RowMapper
     *  2.ResultSetExtractor
     *  3.RowCallBackHandler
     *
     *  1.RowMapper
     *  ================
     *  Spring provides a RowMapper interface for mapping a single row of a ResultSet to an object
     *      – Can be used for both single and multiple row queries
     *      – Parameterized as of Spring 3.0
     *      - must implement mapRow(ResultSet rs,int rowId)
     *      - jdbcTemplate.query() should be used for fetching multiple rows
     *      - jdbcTemplate.queryForObject() to fetch single record
     *
     *
     *      2.ResultSetExtractor
     *      ==========================
     *      • Spring provides a ResultSetExtractor interface for processing an entire ResultSet at once
                 – You are responsible for iterating the ResultSet
                 – e.g. for mapping entire ResultSet to a single object
                 - extractData(ResultSet rs) method should be implemented
                 - use jdbcTemplte.query method for fetching records


     *
     *
     *
     *
     */

    @Autowired
    private JdbcTemplate jt;


    // single row fetching
    public Product findById(int productId){
        Product prod=jt.queryForObject("select * from product where product_id=?",new RowMapperDemo(),productId);
        return  prod;
    }

    // fetch multiple records
    public List<Product> findAll(){
        return jt.query("select * from product",new RowMapperDemo());
    }

    // single row fetching using ResultSetExtractor
    public Product findByIdV1(int productId){
        return jt.query("select * from product where product_id=?",new ResultSetExtractorDemo(),productId);
    }

    // multiple records fetching using ResultSetExtractor
    public List<Product> findAllV1(){
        return jt.query("select * from product",new ResultSetExtractorDemoMultiple());
    }

}

class ResultSetExtractorDemoMultiple implements ResultSetExtractor<List<Product>>{

    @Override
    public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Product> products=new ArrayList<>();
        while (rs.next()){
            Product product=new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setSalary(rs.getDouble("price"));
            products.add(product);
        }

        return products;
    }
}
class ResultSetExtractorDemo implements ResultSetExtractor<Product> {

    @Override
    public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
        Product product=new Product();
        if(rs.next()){
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setSalary(rs.getDouble("price"));
        }
        return product;
    }
}

class RowMapperDemo implements RowMapper<Product>{
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product=new Product();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setSalary(rs.getDouble("price"));

        return product;
    }
}
