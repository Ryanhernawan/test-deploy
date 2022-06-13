package com.alterra.MiniProjectRyanHernawan.service;

import com.alterra.MiniProjectRyanHernawan.model.Ingredients;
import com.alterra.MiniProjectRyanHernawan.model.RecipesIngredients;
import com.alterra.MiniProjectRyanHernawan.repository.IngredientRepository;
import com.alterra.MiniProjectRyanHernawan.repository.RecipesIngredientRepository;
import com.alterra.MiniProjectRyanHernawan.service.Ingredients.IngredientsServiceImpl;
import com.alterra.MiniProjectRyanHernawan.service.RecipesIngredient.RecipesIngredientServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RecipesIngredientsServiceImplTest {
    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    RecipesIngredientServiceImpl service;

    @Mock
    RecipesIngredientRepository repository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll(){
        String errorMessage = "Recipes Ingredients Not Found";
        when(repository.findAll()).thenAnswer(x ->{
            throw new Exception(errorMessage);
        });
        Exception exception = assertThrows(Exception.class, () ->{
            service.getAllRecipesIngredient();
        });
        assertTrue(exception.getMessage().equals(errorMessage));
    }

    @Test
    public void getRecipesIngredientsById(){
        RecipesIngredients recipesIngredients = easyRandom.nextObject(RecipesIngredients.class);
        when(repository.findById(id)).thenReturn(Optional.ofNullable(recipesIngredients));
        RecipesIngredients result = service.getRecipesIngredientsById(id);
        assertEquals(recipesIngredients, result);
    }

    @Test
    public void createNewRecipesIngredients(){
        RecipesIngredients recipesIngredients = easyRandom.nextObject(RecipesIngredients.class);
        when(repository.save(recipesIngredients)).thenReturn(recipesIngredients);
        RecipesIngredients result = service.createNewRecipesIngredient(recipesIngredients);
        assertEquals(recipesIngredients, result);
    }

    @Test
    public void delete(){
        service.deleteRecipesIngredientById(id);
        verify(repository, times(1)).deleteById(id);
    }

}
