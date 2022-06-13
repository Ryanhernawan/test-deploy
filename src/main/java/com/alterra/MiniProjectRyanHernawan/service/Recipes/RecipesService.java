package com.alterra.MiniProjectRyanHernawan.service.Recipes;

import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.model.Recipes;
import com.alterra.MiniProjectRyanHernawan.model.User;

import java.util.List;

public interface RecipesService {
    List<Recipes> getAllRecipes();
    Recipes getRecipesById(Long id);
    Recipes CreateNewRecipes(Recipes recipes);
    Recipes UpdateRecipes(Recipes recipes);
    void deleteRecipesById(Long id);
}
