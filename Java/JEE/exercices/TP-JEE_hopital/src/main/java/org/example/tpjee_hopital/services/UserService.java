package org.example.tpjee_hopital.services;

import org.example.tpjee_hopital.entities.User;
import org.example.tpjee_hopital.interfaces.Repository;
import org.hibernate.cfg.NotYetImplementedException;
import org.hibernate.query.Query;

import java.util.List;

public class UserService extends BaseService implements Repository<User> {
    @Override
    public boolean createOrUpdate(User o) {
        try {
            beginSession();
            beginTransaction();
            session.saveOrUpdate(o);
            commitTransaction();
            return true;
        } catch (Exception e) {
            if (transaction  != null){
                rollbackTransaction();
            }
            e.printStackTrace();
        } finally {
            endSession();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        throw new NotYetImplementedException("La fonctionnalité sera implémentée dans une prochaine version");
    }

    @Override
    public User findById(Long id) {
        try {
            beginSession();
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endSession();
        }
        return null;
    }

    @Override
    public boolean delete(User o) {
        throw new NotYetImplementedException("La fonctionnalité sera implémentée dans une prochaine version");
    }

    public User findByEmailAndPassword(User user){
        try {
            beginSession();
            beginTransaction();
            Query<User> userQuery = session.createQuery("from user where email = :email and password = :password", User.class);
            userQuery.setParameter("email", user.getEmail());
            userQuery.setParameter("password", user.getPassword());
            User user1 = userQuery.uniqueResult();
            commitTransaction();
            if (user1 != null) {
                return user1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            endSession();
        }
        return null;
    }
}
