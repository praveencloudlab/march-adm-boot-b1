package com.cts.ecart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int stockId;
    private int stockItems;

    public Stock(int stockItems) {
        this.stockItems = stockItems;
    }
}
