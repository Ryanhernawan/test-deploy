package com.alterra.MiniProjectRyanHernawan.service.RecipesIngredient;

import com.alterra.MiniProjectRyanHernawan.model.RecipesIngredients;
import com.alterra.MiniProjectRyanHernawan.repository.RecipesIngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RecipesIngredientServiceImpl implements RecipesIngredientService{
    @Autowired
    private  RecipesIngredientRepository repository;

    @Override
    public List<RecipesIngredients> getAllRecipesIngredient() {
        return repository.findAll();
    }

    @Override
    public RecipesIngredients getRecipesIngredientsById(Long id) {
        RecipesIngredients recipesIngredients = new RecipesIngredients();
        recipesIngredients = repository.findById(id).orElse(null);
        return recipesIngredients;
    }

    @Override
    public RecipesIngredients createNewRecipesIngredient(RecipesIngredients recipesIngredients) {
        return repository.save(recipesIngredients);
    }

    @Override
    public RecipesIngredients updateRecipesIngredient(RecipesIngredients recipesIngredients) {
        return repository.save(recipesIngredients);
    }

    @Override
    public  void  deleteRecipesIngredientById(Long id) {
        repository.deleteById(id);
    }
}
