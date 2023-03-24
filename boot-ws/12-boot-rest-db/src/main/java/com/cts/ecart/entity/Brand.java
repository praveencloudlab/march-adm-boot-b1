package com.cts.ecart.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int brandId;
    private String brandName;

    //@Transient
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name="products_brands",joinColumns = {@JoinColumn(name="brandId")},
            inverseJoinColumns = {@JoinColumn(name ="productId" )})
    private List<Product> products=new ArrayList<>();

    public Brand(String brandName) {
        this.brandName = brandName;
    }
}
