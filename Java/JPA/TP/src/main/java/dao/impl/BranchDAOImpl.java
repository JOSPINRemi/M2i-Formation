package dao.impl;

import dao.IBranchDAO;
import entity.Branch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BranchDAOImpl implements IBranchDAO {
    private final EntityManagerFactory entityManagerFactory;

    public BranchDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void save(Branch branch) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(branch);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Branch get(long branchId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Branch customer = entityManager.find(Branch.class, branchId);
        transaction.commit();
        return customer;
    }

    @Override
    public List<Branch> get() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Branch> customers = entityManager.createQuery("SELECT b FROM Branch b", Branch.class).getResultList();
        entityManager.close();
        return customers;
    }
}
