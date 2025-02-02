package org.example.services;

import org.example.entities.Commentaire;
import org.example.entities.Image;
import org.example.entities.Produit;
import org.example.interfaces.Repository;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitService extends BaseService implements Repository<Produit> {

    public ProduitService() {
        super();
    }

    @Override
    public boolean create(Produit o) {
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Produit o) {
        for (Image image : o.getImages()) {
            session.beginTransaction();
            if (session.get(Image.class, image.getId()) == null) {
                session.save(image);
                session.getTransaction().commit();
            }
            else {
                session.getTransaction().rollback();
            }
        }
        for (Commentaire commentaire : o.getCommentaires()) {
            session.beginTransaction();
            if (session.get(Commentaire.class, commentaire.getId()) == null) {
                session.save(commentaire);
                session.getTransaction().commit();
            }
            else {
                session.getTransaction().rollback();
            }
        }
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Produit findById(int id) {
        return session.get(Produit.class, id);
    }

    @Override
    public List<Produit> findAll() {
        Query<Produit> produitQuery = session.createQuery("from Produit");
        return produitQuery.list();
    }

    public List<Produit> filterByPrice(double min) throws Exception {
        if (min >= 0) {
            Query<Produit> produitQuery = session.createQuery("from Produit where prix >= :min");
            produitQuery.setParameter("min", min);
            return produitQuery.list();
        }
        throw new Exception("erreur valeur");
    }

    public List<Produit> filterByDate(Date min, Date max) throws Exception {
        if (min.before(max)) {
            Query<Produit> produitQuery = session.createQuery("from Produit where dateAchat >= :min and dateAchat <= :max ");
            produitQuery.setParameter("min", min);
            produitQuery.setParameter("max", max);
            return produitQuery.list();
        }
        throw new Exception("erreur date");
    }

    public List<Produit> filterByStock(int max) throws Exception {
        if (max >= 0) {
            Query<Produit> produitQuery = session.createQuery("FROM Produit WHERE stock <= :max");
            produitQuery.setParameter("max", max);
            return produitQuery.list();
        }
        throw new Exception("erreur valeur");
    }

    public List<Produit> filterByBrand(String brand) throws Exception {
        if (!brand.isEmpty()) {
            Query<Produit> produitQuery = session.createQuery("FROM Produit WHERE marque = :brand");
            produitQuery.setParameter("brand", brand);
            return produitQuery.list();
        }
        throw new Exception("erreur valeur");
    }

    public List<Produit> filterByNote(float note) throws Exception {
        if (note >= 0 && note <= 5) {
            Query<Produit> produitQuery = session.createQuery("FROM Produit WHERE id IN (SELECT c.produit.id FROM Commentaire c GROUP BY c.produit HAVING avg(c.note) >= :note)");
            produitQuery.setParameter("note", (double) note);
            return produitQuery.list();
        } else {
            throw new Exception("Note invalide");
        }
    }

    public void begin() {
        session = sessionFactory.openSession();
    }

    public void end() {
        session.close();
    }
}
