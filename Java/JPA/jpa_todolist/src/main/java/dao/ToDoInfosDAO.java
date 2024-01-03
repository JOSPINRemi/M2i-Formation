package dao;

import entity.ToDoInfos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ToDoInfosDAO {
    private static EntityManagerFactory _emf;

    public ToDoInfosDAO(EntityManagerFactory emf) {
        _emf = emf;
    }

    public boolean save(ToDoInfos toDoInfos) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(toDoInfos);
        if (toDoInfos.getId() != null) {
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            em.getTransaction().rollback();
            em.close();
            return false;
        }
    }

    public List<ToDoInfos> get() {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        List<ToDoInfos> toDosInfos = em.createQuery("SELECT t FROM ToDo t", ToDoInfos.class).getResultList();
        return toDosInfos;
    }

    public ToDoInfos get(Long id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        ToDoInfos toDoInfos = em.find(ToDoInfos.class, id);
        if (toDoInfos != null) {
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().rollback();
        }
        em.close();
        return toDoInfos;
    }

    public boolean update(ToDoInfos toDoInfos) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        ToDoInfos updateToDoInfos = em.find(ToDoInfos.class, toDoInfos.getId());
        updateToDoInfos.setDescription(toDoInfos.getDescription());
        updateToDoInfos.setEcheance(toDoInfos.getEcheance());
        updateToDoInfos.setPriorite(toDoInfos.getPriorite());
        if (em.find(ToDoInfos.class, toDoInfos.getId()).equals(updateToDoInfos)){
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }

    public boolean remove(Long id) {
        EntityManager em = _emf.createEntityManager();
        em.getTransaction().begin();
        ToDoInfos toDoInfos = em.find(ToDoInfos.class, id);
        if (toDoInfos != null) {
            em.remove(toDoInfos);
            if (em.find(ToDoInfos.class, id) == null) {
                em.getTransaction().commit();
                em.close();
                return true;
            }
        }
        return false;
    }
}
