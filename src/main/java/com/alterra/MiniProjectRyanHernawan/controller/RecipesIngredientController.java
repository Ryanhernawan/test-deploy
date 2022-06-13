package com.alterra.MiniProjectRyanHernawan.controller;

import com.alterra.MiniProjectRyanHernawan.model.BaseResponse;
import com.alterra.MiniProjectRyanHernawan.model.RecipesIngredients;
import com.alterra.MiniProjectRyanHernawan.service.RecipesIngredient.RecipesIngredientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes-ingredients")
@AllArgsConstructor
public class RecipesIngredientController {
    private final RecipesIngredientService service;

    @GetMapping
    public ResponseEntity<?> getAllRecipesIngredient() {
        BaseResponse<List<RecipesIngredients>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(service.getAllRecipesIngredient());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipesIngredientsById(@PathVariable("id") Long id) {
        BaseResponse<RecipesIngredients> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(service.getRecipesIngredientsById(id));
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping
    public ResponseEntity<?> createNewRecipesIngredient(@RequestBody RecipesIngredients recipesIngredients) {
        BaseResponse<RecipesIngredients> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(service.createNewRecipesIngredient(recipesIngredients));
        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecipesIngredient(@PathVariable("id") Long id, @RequestBody RecipesIngredients recipesIngredients){
        BaseResponse<RecipesIngredients> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        recipesIngredients.setId(id);
        baseResponse.setData(service.updateRecipesIngredient(recipesIngredients));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipesIngredientById(@PathVariable("id") Long id){
        service.deleteRecipesIngredientById(id);
        return ResponseEntity.ok("Success");
    }




}
