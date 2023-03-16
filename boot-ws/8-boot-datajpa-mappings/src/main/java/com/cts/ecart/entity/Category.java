package com.cts.ecart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int categoryId;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}


