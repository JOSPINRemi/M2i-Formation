package org.example.tp_jeudevinette.service;

import org.example.tp_jeudevinette.entity.Devinette;
import org.example.tp_jeudevinette.entity.Proposition;
import org.example.tp_jeudevinette.exception.RepositoryException;
import org.example.tp_jeudevinette.repository.DevinetteRepository;
import org.example.tp_jeudevinette.repository.PropositionRepository;
import org.example.tp_jeudevinette.repository.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DevinetteService {
    private SessionFactory sessionFactory;
    private Repository<Devinette> devinetteRepository;
    private Repository<Proposition> propositionRepository;
    public DevinetteService(SessionFactory sessionFactory, DevinetteRepository devinetteRepository, PropositionRepository propositionRepository) {
        this.sessionFactory = sessionFactory;
        this.devinetteRepository = devinetteRepository;
        this.propositionRepository = propositionRepository;
    }

    public boolean createDevinette(String question, String reponse) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        devinetteRepository.setSession(session);
        Devinette devinette = Devinette.builder()
                .question(question)
                .reponse(reponse)
                .build();
        session.beginTransaction();
        try {
            devinetteRepository.create(devinette);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }
        finally {
            session.close();
        }
        return result;
    }

    public boolean submitProposition(Long devinetteId, String propositionValue) throws RepositoryException {
        boolean result = false;
        Session session = sessionFactory.openSession();
        devinetteRepository.setSession(session);
        Devinette devinette = devinetteRepository.findById(devinetteId);
        Proposition proposition = Proposition.builder()
                .devinette(devinette)
                .valeur(propositionValue)
                .build();
        session.beginTransaction();
        try {
            propositionRepository.create(proposition);
            session.getTransaction().commit();
            result = true;
            if (!propositionValue.equals(devinette.getReponse())) {
                result = false;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new RepositoryException();
        }
        finally {
            session.close();
        }
        return result;
    }
}
