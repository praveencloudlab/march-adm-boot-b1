package com.cts.ecart.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
    private int productId;
    private String productName;
    private String productImage;
    private String keywords;
    private double rating;
    private String description;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "priceId")
    private Price price;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "stockId")
    private Stock stock;

    public Product(String productName, String productImage,String description, String keywords, double rating, Price price, Stock stock) {
        this.productName = productName;
        this.productImage = productImage;
        this.description=description;
        this.keywords = keywords;
        this.rating = rating;
        this.price = price;
        this.stock = stock;
    }
}
