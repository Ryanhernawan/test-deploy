package com.alterra.MiniProjectRyanHernawan.controller;

import com.alterra.MiniProjectRyanHernawan.model.BaseResponse;
import com.alterra.MiniProjectRyanHernawan.model.Ingredients;
import com.alterra.MiniProjectRyanHernawan.service.Ingredients.IngredientsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@AllArgsConstructor
public class IngredientsController {

    private final IngredientsService service;

    @GetMapping
    public ResponseEntity<?> getAllIngredients(){
        BaseResponse<List<Ingredients>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(service.getAllIngredients());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIngredientsById(@PathVariable("id") Long id){
        BaseResponse<List<Ingredients>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(List.of(service.getIngredientsById(id)));
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping
    public ResponseEntity<?> createNewIngredients(@RequestBody Ingredients ingredients){
        BaseResponse<Ingredients> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(service.createNewIngredients(ingredients));
        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIngredients(@PathVariable("id") Long id, @RequestBody Ingredients ingredients){
        BaseResponse<Ingredients> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        ingredients.setId(id);
        baseResponse.setData(service.updateIngredients(ingredients));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIngredientsById(@PathVariable("id") Long id){
        service.deleteIngredientsById(id);
        return ResponseEntity.ok("Success");
    }

}
