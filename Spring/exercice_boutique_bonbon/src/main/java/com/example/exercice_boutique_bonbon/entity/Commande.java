package com.example.exercice_boutique_bonbon.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatutCommande statut;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> bonbons;
}
