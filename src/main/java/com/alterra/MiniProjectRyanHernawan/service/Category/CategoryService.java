package com.alterra.MiniProjectRyanHernawan.service.Category;

import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.model.Recipes;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();
    Category getCategoryById(Long id);
    Category createNewCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategoryById(Long id);


}
