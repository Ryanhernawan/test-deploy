package com.alterra.MiniProjectRyanHernawan.repository;

import com.alterra.MiniProjectRyanHernawan.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipesRepository extends JpaRepository<Recipes, Long> {
}
