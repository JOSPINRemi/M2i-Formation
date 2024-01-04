package dao;

import entity.ToDo;
import entity.ToDoInfos;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDAO {
    private static EntityManagerFactory _emf;

    public UserDAO(EntityManagerFactory emf) {
        _emf = emf;
    }

    public boolean save(User user) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        if (user.getId() != null){
            em.getTransaction().commit();
            em.close();
            return true;
        }
        else {
            em.getTransaction().rollback();
            em.close();
            return false;
        }
    }

    public List<User> get() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User get(Long id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }
        em.close();
        return user;
    }

    public boolean remove(Long id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
            if (em.find(User.class, id) == null) {
                em.getTransaction().commit();
                em.close();
                return true;
            }
        }
        return false;
    }
}
