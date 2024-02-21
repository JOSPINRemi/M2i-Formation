package com.example.exercice_boutique_bonbon.repository;

import com.example.exercice_boutique_bonbon.entity.Bonbon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BonbonRepository extends CrudRepository<Bonbon, Long> {
    List<Bonbon> findAllByNom(String nom);

    List<Bonbon> findAllByEffet(String effet);

    List<Bonbon> findAllByPrixBetween(double min, double max);
}
