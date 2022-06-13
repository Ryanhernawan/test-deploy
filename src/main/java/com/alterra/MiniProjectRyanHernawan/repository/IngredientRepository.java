package com.alterra.MiniProjectRyanHernawan.repository;

import com.alterra.MiniProjectRyanHernawan.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, Long> {
}
