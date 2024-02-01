package org.example.tp_hopital.repository;

import org.example.tp_hopital.entity.MedicalConsultation;
import org.example.tp_hopital.entity.Patient;

import java.util.List;

public class MedialConsultationRepository extends Repository<MedicalConsultation> {
    public MedialConsultationRepository() {

    }

    @Override
    public MedicalConsultation findById(int id) {
        return session.get(MedicalConsultation.class, id);
    }

    @Override
    public List<MedicalConsultation> findAll() {
        return session.createQuery("from MedicalConsultation ").list();
    }
}
