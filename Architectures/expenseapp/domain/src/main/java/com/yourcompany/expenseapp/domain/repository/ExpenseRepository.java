package com.yourcompany.expenseapp.domain.repository;


import com.yourcompany.expenseapp.domain.model.Expense;

import java.util.List;

public interface ExpenseRepository {
    void save(Expense expense);
    List<Expense> findAll();
}
