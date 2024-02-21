package com.example.exercice_boutique_bonbon.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Bonbon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String description;

    private String effet;

    private int stock;

    private double prix;

    @OneToMany(mappedBy = "bonbon")
    private List<Avis> avis;
}
