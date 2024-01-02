package dao;

import entity.ToDo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ToDoDAO {
    private static EntityManagerFactory _emf;

    public ToDoDAO(EntityManagerFactory emf) {
        _emf = emf;
    }

    public boolean save(ToDo toDo) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toDo);
        if (toDo.getId() != null) {
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            em.getTransaction().rollback();
            em.close();
            return false;
        }
    }
}
