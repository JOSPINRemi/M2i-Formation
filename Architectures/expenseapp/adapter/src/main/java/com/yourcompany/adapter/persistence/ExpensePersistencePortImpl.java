package com.yourcompany.adapter.persistence;

import com.yourcompany.adapter.utils.HibernateSession;
import com.yourcompany.expenseapp.application.ports.output.ExpensePersistencePort;
import com.yourcompany.expenseapp.domain.model.Expense;
import com.yourcompany.expenseapp.domain.repository.ExpenseRepository;
import org.hibernate.Session;

import java.util.List;

public class ExpensePersistencePortImpl implements ExpensePersistencePort {
    private ExpenseRepository expenseRepository;

    @Override
    public void addExpense(Expense expense) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            session.
        }
    }

    @Override
    public List<Expense> listExpenses() {
        Session session = HibernateSession.getSessionFactory().openSession();
        try (session) {
            return session.createQuery("from Expense", Expense.class).list();
        }
    }
}
