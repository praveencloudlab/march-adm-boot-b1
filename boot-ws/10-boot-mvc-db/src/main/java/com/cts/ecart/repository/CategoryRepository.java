package com.cts.ecart.repository;

import com.cts.ecart.entity.Brand;
import com.cts.ecart.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}