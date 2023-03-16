package com.cts.ecart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

    public Brand(String brandName) {
        this.brandName = brandName;
    }
}
