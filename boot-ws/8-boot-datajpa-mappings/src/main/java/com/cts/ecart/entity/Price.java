package com.cts.ecart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int priceId;
    private double productPrice;

    public Price(double productPrice) {
        this.productPrice = productPrice;
    }
}
