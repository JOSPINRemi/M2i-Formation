package com.example.exercice_boutique_bonbon.entity;

import jakarta.persistence.*;

@Entity
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int score;

    @ManyToOne
    private Bonbon bonbon;
}
