package com.example.candy_shop_exercise.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CandyOrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int qty;
    @ManyToOne
    private Candy candy;

    @ManyToOne
    private CandyOrder candyOrder;

    public void setCandy(Candy candy) {
        this.candy = candy;
        candy.setStock(candy.getStock()-qty);
    }
}
