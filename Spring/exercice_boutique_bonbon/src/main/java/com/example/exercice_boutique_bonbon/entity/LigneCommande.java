package com.example.exercice_boutique_bonbon.entity;

import jakarta.persistence.*;

@Entity
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantite;

    @ManyToOne
    private Bonbon bonbon;

    @ManyToOne
    private Commande commande;

    public void setBonbon(Bonbon bonbon) {
        this.bonbon = bonbon;
        bonbon.setStock(bonbon.getStock() - quantite);
    }
}
