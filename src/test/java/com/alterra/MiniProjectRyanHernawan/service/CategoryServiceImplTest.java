package com.alterra.MiniProjectRyanHernawan.service;

import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.repository.CategoryRepository;
import com.alterra.MiniProjectRyanHernawan.service.Category.CategoryServiceImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryServiceImplTest {

    private final EasyRandom easyRandom =new EasyRandom();
    private Long id;

    @InjectMocks
    CategoryServiceImpl service;

    @Mock
    CategoryRepository repository;

    @BeforeEach
    public void  setUp(){
        MockitoAnnotations.initMocks(this);
    }

    //getAllService
    @Test
    public void findAlL_WillThrowException(){
        String errorMesssage = "Category Not Found";
        when(repository.findAll()).thenAnswer(x ->{
            throw new Exception(errorMesssage);
        });
        Exception exception = assertThrows(Exception.class, () -> {
            service.getAllCategory();
        });
        assertTrue(exception.getMessage().equals(errorMesssage));
    }

    //getByIdService
    @Test
    public void getCategoryById_WillReturnModelCategory(){
        Category category = easyRandom.nextObject(Category.class);
        when(repository.findById(id)).thenReturn(Optional.ofNullable(category));
        Category result = service.getCategoryById(id);
        assertEquals(category, result);
    }

    //createNewService
    @Test
    public void createNewCategory_WillReturnModelCategory(){
        Category category = easyRandom.nextObject(Category.class);
        when(repository.save(category)).thenReturn(category);
        Category result = service.createNewCategory(category);
        assertEquals(category, result);
    }

    //deleteService
    @Test
    public void delete(){
        service.deleteCategoryById(id);
        verify(repository, times(1)).deleteById(id);
    }

}
