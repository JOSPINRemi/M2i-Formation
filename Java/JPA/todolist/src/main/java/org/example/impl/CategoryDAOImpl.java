package org.example.impl;

import org.example.dao.CategoryDAO;
import org.example.model.Category;
import org.example.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class CategoryDAOImpl implements CategoryDAO {
    private EntityManagerFactory entityManagerFactory;

    public CategoryDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void addCategory(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteCategory(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Category category = entityManager.find(Category.class, id);
        if (category != null){
            entityManager.remove(category);
        }
        transaction.commit();
        entityManager.close();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Category category = (Category) entityManager.createQuery("SELECT c FROM Category c WHERE c.id = :categoryId")
                .setParameter("categoryId",categoryId)
                .getSingleResult();
        return category;
    }
}
