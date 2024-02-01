package org.example.tp_hopital.service;

import org.example.tp_hopital.entity.Patient;
import org.example.tp_hopital.exception.RepositoryException;
import org.example.tp_hopital.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class PatientService {
    Repository<Patient> patientRepository;
    SessionFactory sessionFactory;
    public PatientService(SessionFactory sessionFactory, Repository<Patient> patientRepository) {
        this.patientRepository = patientRepository;
        this.sessionFactory = sessionFactory;
    }

    public boolean createPatient(String lastName, String firstName, Date birthDate, byte[] picture) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        Patient patient = Patient.builder()
                .lastName(lastName)
                .firstName(firstName)
                .birthDate(birthDate)
                .picture(picture)
                .build();
        session.beginTransaction();
        try {
            patientRepository.create(patient);
            session.getTransaction().commit();
            result = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }finally {
            session.close();
        }
        return result;
    }

    public Patient findById(int id){
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        Patient patient = patientRepository.findById(id);
        session.close();
        return patient;
    }

    public List<Patient> findAll(){
        Session session = sessionFactory.openSession();
        patientRepository.setSession(session);
        List<Patient> patients = patientRepository.findAll();
        session.close();
        return patients;
    }
}
