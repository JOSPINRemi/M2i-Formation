package org.example.tp_jeudevinette.repository;

import org.example.tp_jeudevinette.entity.Devinette;

import java.util.List;

public class DevinetteRepository extends Repository<Devinette> {
    @Override
    Devinette findById(Long id) {
        return session.get(Devinette.class, id);
    }

    @Override
    List<Devinette> findAll() {
        return session.createQuery("from Devinette").list();
    }
}
