package com.alterra.MiniProjectRyanHernawan.service.RecipesIngredient;

import com.alterra.MiniProjectRyanHernawan.model.RecipesIngredients;

import java.util.List;

public interface RecipesIngredientService {
    List<RecipesIngredients> getAllRecipesIngredient();
    RecipesIngredients getRecipesIngredientsById(Long id);
    RecipesIngredients createNewRecipesIngredient(RecipesIngredients recipesIngredients);
    RecipesIngredients updateRecipesIngredient(RecipesIngredients recipesIngredients);
    void deleteRecipesIngredientById(Long id);

}
