package com.yourcompany.expenseapp.application.ports.output;

import com.yourcompany.expenseapp.domain.model.Expense;

import java.util.List;

public interface ExpensePersistencePort {
    void addExpense(Expense expense);
    List<Expense> listExpenses();
}
