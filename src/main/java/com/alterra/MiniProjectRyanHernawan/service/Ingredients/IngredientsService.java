package com.alterra.MiniProjectRyanHernawan.service.Ingredients;

import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.model.Ingredients;

import java.util.List;

public interface IngredientsService {
    List<Ingredients> getAllIngredients();
    Ingredients getIngredientsById(Long id);
    Ingredients createNewIngredients(Ingredients ingredients);
    Ingredients updateIngredients(Ingredients ingredients);
    void deleteIngredientsById(Long id);
}
