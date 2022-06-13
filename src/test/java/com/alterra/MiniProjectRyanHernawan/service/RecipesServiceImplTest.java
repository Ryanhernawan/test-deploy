package com.alterra.MiniProjectRyanHernawan.service;

import com.alterra.MiniProjectRyanHernawan.model.Recipes;
import com.alterra.MiniProjectRyanHernawan.repository.RecipesRepository;
import com.alterra.MiniProjectRyanHernawan.service.Recipes.RecipesServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipesServiceImplTest {

    private final EasyRandom easyRandom = new EasyRandom();
    private Long id;

    @InjectMocks
    RecipesServiceImpl service;

    @Mock
    RecipesRepository repository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    //getAllService
    @Test
    public void findAll_WillThrowException(){
        String  errorMessage= "Recipes Not Found";
        when(repository.findAll()).thenAnswer(x ->{
            throw new Exception(errorMessage);
        });
        Exception exception = assertThrows(Exception.class, () -> {
            service.getAllRecipes();
        });
        assertTrue(exception.getMessage().equals(errorMessage));
    }

    //getByIdService
    @Test
    public void getRecipesById_WillReturnModelProduct(){
        Recipes recipes = easyRandom.nextObject(Recipes.class);
        when(repository.findById(id)).thenReturn(Optional.ofNullable(recipes));
        Recipes result = service.getRecipesById(id);
        assertEquals(recipes, result);
    }

    //createNewService
    @Test
    public void createNewRecipes_WillReturnModelRecipes(){
        Recipes recipes = easyRandom.nextObject(Recipes.class);
        when(repository.save(recipes)).thenReturn(recipes);
        Recipes result = service.CreateNewRecipes(recipes);
        assertEquals(recipes, result);
    }

    //deleteService
    @Test
    public void delete(){
        service.deleteRecipesById(id);
        verify(repository, times(1)).deleteById(id);
    }
}
