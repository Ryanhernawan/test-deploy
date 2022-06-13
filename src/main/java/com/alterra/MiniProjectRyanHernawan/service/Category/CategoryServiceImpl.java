package com.alterra.MiniProjectRyanHernawan.service.Category;

import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = new Category();
        category = categoryRepository.findById(id).orElse(null);
        return category;
    }

    @Override
    public Category createNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
