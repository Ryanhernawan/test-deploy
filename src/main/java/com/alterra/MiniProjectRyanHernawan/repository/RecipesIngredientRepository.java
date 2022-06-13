package com.alterra.MiniProjectRyanHernawan.repository;

import com.alterra.MiniProjectRyanHernawan.model.RecipesIngredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesIngredientRepository extends JpaRepository<RecipesIngredients, Long> {
}
