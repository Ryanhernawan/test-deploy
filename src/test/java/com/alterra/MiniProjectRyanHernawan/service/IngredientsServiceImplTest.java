package com.alterra.MiniProjectRyanHernawan.service;

import com.alterra.MiniProjectRyanHernawan.model.Ingredients;
import com.alterra.MiniProjectRyanHernawan.repository.IngredientRepository;
import com.alterra.MiniProjectRyanHernawan.service.Ingredients.IngredientsServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IngredientsServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    IngredientsServiceImpl service;

    @Mock
    IngredientRepository repository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_WillThrowException(){
        String errorMessage = "Ingredients Not Found";
        when(repository.findAll()).thenAnswer(x ->{
            throw new Exception(errorMessage);
        });
        Exception exception = assertThrows(Exception.class, () ->{
            service.getAllIngredients();
        });
        assertTrue(exception.getMessage().equals(errorMessage));
    }

    @Test
    public void getIngredientsById(){
        Ingredients ingredients = easyRandom.nextObject(Ingredients.class);
        when(repository.findById(id)).thenReturn(Optional.ofNullable(ingredients));
        Ingredients result = service.getIngredientsById(id);
        assertEquals(ingredients, result);
    }

    @Test
    public void createNewIngredient(){
        Ingredients ingredients = easyRandom.nextObject(Ingredients.class);
        when(repository.save(ingredients)).thenReturn(ingredients);
        Ingredients result = service.createNewIngredients(ingredients);
        assertEquals(ingredients, result);
    }

    @Test
    public void delete(){
        service.deleteIngredientsById(id);
        verify(repository, times(1)).deleteById(id);
    }


}
