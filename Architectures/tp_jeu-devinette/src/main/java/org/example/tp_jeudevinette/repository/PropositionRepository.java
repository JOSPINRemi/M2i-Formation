package org.example.tp_jeudevinette.repository;

import org.example.tp_jeudevinette.entity.Devinette;
import org.example.tp_jeudevinette.entity.Proposition;

import java.util.List;

public class PropositionRepository extends Repository<Proposition> {
    @Override
    Proposition findById(Long id) {
        return session.get(Proposition.class, id);
    }

    @Override
    List<Proposition> findAll() {
        return session.createQuery("from Proposition ").list();
    }
}
