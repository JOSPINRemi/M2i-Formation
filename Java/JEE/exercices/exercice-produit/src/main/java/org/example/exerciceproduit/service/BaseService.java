package org.example.exerciceproduit.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class BaseService {
    protected StandardServiceRegistry registry;
    protected SessionFactory sessionFactory;
    protected Session session;

    protected Transaction transaction;
    public BaseService() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    protected void beginSession(){
        session = sessionFactory.openSession();
    }

    protected void endSession(){
        session.close();
    }

    protected void beginTransaction(){
        transaction = session.beginTransaction();
    }

    protected void commitTransaction(){
        transaction.commit();
    }
}
