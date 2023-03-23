package com.cts.ecart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "brandsInfo",
            joinColumns = {@JoinColumn(name="categoryId")},
            inverseJoinColumns = {@JoinColumn(name="brandId")})
    private List<Brand> brandsInfo=new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}


