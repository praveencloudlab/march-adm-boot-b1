package com.cts.ecart.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductrepositoryImpl {

    @Autowired
    private JdbcTemplate jt;

    



}
