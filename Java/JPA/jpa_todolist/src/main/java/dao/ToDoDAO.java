package dao;

import entity.ToDo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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

    public List<ToDo> get() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        List<ToDo> toDos = em.createQuery("SELECT t FROM ToDo t", ToDo.class).getResultList();
        return toDos;
    }

    public ToDo get(Long id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        ToDo toDo = em.find(ToDo.class, id);
        if (toDo != null) {
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().rollback();
        }
        em.close();
        return toDo;
    }

    public boolean update(ToDo toDo) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        ToDo updateToDo = em.find(ToDo.class, toDo.getId());
        updateToDo.setLabel(toDo.getLabel());
        updateToDo.setStatus(toDo.getStatus());
        if (em.find(ToDo.class, toDo.getId()).equals(updateToDo)){
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }

    public boolean remove(Long id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        ToDo toDo = em.find(ToDo.class, id);
        if (toDo != null) {
            em.remove(toDo);
            if (em.find(ToDo.class, id) == null) {
                em.getTransaction().commit();
                em.close();
                return true;
            }
        }
        return false;
    }
}
