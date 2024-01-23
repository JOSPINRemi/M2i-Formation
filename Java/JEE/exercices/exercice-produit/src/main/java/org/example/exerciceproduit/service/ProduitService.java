package org.example.exerciceproduit.service;

import org.example.exerciceproduit.entities.Produit;
import org.example.exerciceproduit.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.List;

public class ProduitService extends BaseService implements Repository<Produit> {
    @Override
    public boolean delete(Produit o) {
        beginSession();
        beginTransaction();
        session.delete(o);
        commitTransaction();
        endSession();
        return true;
    }

    @Override
    public Produit findById(int id) {
        beginSession();
        Produit produit = session.get(Produit.class, id);
        endSession();
        return produit;
    }

    @Override
    public List<Produit> findAll() {
        beginSession();
        Query<Produit> produitQuery = session.createQuery("from Produit ");
        List<Produit> produits = produitQuery.list();
        endSession();
        return produits;
    }
}
