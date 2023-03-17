package com.cts.ecart.repository;

import com.cts.ecart.entity.Price;
import com.cts.ecart.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
}