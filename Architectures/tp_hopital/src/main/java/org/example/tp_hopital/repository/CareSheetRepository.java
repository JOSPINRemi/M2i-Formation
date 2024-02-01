package org.example.tp_hopital.repository;

import org.example.tp_hopital.entity.CareSheet;
import org.example.tp_hopital.entity.Patient;

import java.util.List;

public class CareSheetRepository extends Repository<CareSheet > {
    public CareSheetRepository() {

    }

    @Override
    public CareSheet findById(int id) {
        return session.get(CareSheet .class, id);
    }

    @Override
    public List<CareSheet> findAll() {
        return session.createQuery("from CareSheet ").list();
    }
}
