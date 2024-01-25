package org.example.tpjee_hopital.services;

import org.example.tpjee_hopital.entities.Patient;
import org.example.tpjee_hopital.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService extends BaseService implements Repository<Patient> {
    @Override
    public boolean createOrUpdate(Patient o) {
        beginSession();
        beginTransaction();
        session.saveOrUpdate(o);
        commitTransaction();
        endSession();
        return true;
    }

    @Override
    public List<Patient> findAll() {
        beginSession();
        Query<Patient> patientQuery = session.createQuery("from Patient");
        endSession();
        return patientQuery.list();
    }

    @Override
    public Patient findById(Long id) {
        beginSession();
        Patient patient = session.get(Patient.class, id);
        endSession();
        return patient;
    }

    @Override
    public boolean delete(Patient o) {
        beginSession();
        beginTransaction();
        session.delete(o);
        commitTransaction();
        endSession();
        return true;
    }
}
