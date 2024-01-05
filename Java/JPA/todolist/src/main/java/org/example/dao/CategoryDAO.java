package org.example.dao;

import org.example.model.Category;

public interface CategoryDAO {
    void addCategory(Category category);

    void deleteCategory(Long id);

    Category getCategoryById(Long categoryId);
}
