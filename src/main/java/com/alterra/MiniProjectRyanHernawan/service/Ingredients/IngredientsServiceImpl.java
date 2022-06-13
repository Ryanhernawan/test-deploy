package com.alterra.MiniProjectRyanHernawan.service.Ingredients;

import com.alterra.MiniProjectRyanHernawan.model.Ingredients;
import com.alterra.MiniProjectRyanHernawan.repository.IngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IngredientsServiceImpl implements IngredientsService{

    private final IngredientRepository repository;

    @Override
    public List<Ingredients> getAllIngredients() {
        return repository.findAll();
    }

    @Override
    public Ingredients getIngredientsById(Long id) {
        Ingredients ingredients = new Ingredients();
        ingredients = repository.findById(id).orElse(null);
        return ingredients;
    }

    @Override
    public Ingredients createNewIngredients(Ingredients ingredients) {
        return repository.save(ingredients);
    }

    @Override
    public Ingredients updateIngredients(Ingredients ingredients) {
        return repository.save(ingredients);
    }

    @Override
    public void deleteIngredientsById(Long id) {
        repository.deleteById(id);
    }
}
