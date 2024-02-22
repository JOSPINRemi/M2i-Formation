package com.example.candy_shop_exercise.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;
    private String magicEffect;
    private int stock;
    private double price;


    @OneToMany(mappedBy = "candy")
    private List<Review> reviews;
}
