package org.example.tp_hopital.repository;

import org.example.tp_hopital.entity.MedicalPrescription;

import java.util.List;

public class MedialPrescriptionRepository extends Repository<MedicalPrescription> {
    public MedialPrescriptionRepository() {

    }

    @Override
    public MedicalPrescription findById(int id) {
        return session.get(MedicalPrescription.class, id);
    }

    @Override
    public List<MedicalPrescription> findAll() {
        return session.createQuery("from MedicalPrescription ").list();
    }
}
