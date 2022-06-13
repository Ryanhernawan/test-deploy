package com.alterra.MiniProjectRyanHernawan.controller;

import com.alterra.MiniProjectRyanHernawan.model.BaseResponse;
import com.alterra.MiniProjectRyanHernawan.model.Recipes;
import com.alterra.MiniProjectRyanHernawan.model.User;
import com.alterra.MiniProjectRyanHernawan.service.Recipes.RecipesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@AllArgsConstructor
public class RecipesController {

    private final RecipesService recipesService;

    @GetMapping
    public ResponseEntity<?> getAllRecipes(){
        BaseResponse<List<Recipes>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(recipesService.getAllRecipes());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/{recipes_id}")
    public ResponseEntity<?> getRecipesById(@PathVariable("recipes_id") Long id){
        BaseResponse<Recipes> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(recipesService.getRecipesById(id));
        return ResponseEntity.ok(baseResponse);
    }


    @PostMapping
    public ResponseEntity<?> CreateNewRecipes(@RequestBody Recipes recipes){
        BaseResponse<Recipes> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(recipesService.CreateNewRecipes(recipes));
        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/{wid}")
    public ResponseEntity<?> UpdateRecipes(@PathVariable("id") Long id, @RequestBody Recipes recipes) {
        BaseResponse<Recipes> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        recipes.setId(id);
        baseResponse.setData(recipesService.UpdateRecipes(recipes));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public String deleteRecipesById(@PathVariable("id") Long id){
        recipesService.deleteRecipesById(id);
        return "Success";
    }


}
