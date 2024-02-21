package com.example.exercice_boutique_bonbon.repository;

import com.example.exercice_boutique_bonbon.entity.Commande;
import org.springframework.data.repository.CrudRepository;

public interface CommandeRepository extends CrudRepository<Commande, Long> {
}
