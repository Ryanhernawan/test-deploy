package com.alterra.MiniProjectRyanHernawan.controller;


import com.alterra.MiniProjectRyanHernawan.model.BaseResponse;
import com.alterra.MiniProjectRyanHernawan.model.Category;
import com.alterra.MiniProjectRyanHernawan.service.Category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategory(){
        BaseResponse<List<Category>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(categoryService.getAllCategory());
        return ResponseEntity.ok(baseResponse);
    }

    @GetMapping("/{category_id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("category_id") Long id){
        BaseResponse<List<Category>> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(List.of(categoryService.getCategoryById(id)));
        return ResponseEntity.ok(baseResponse);
    }

    @PostMapping
    public ResponseEntity<?> createNewCategory(@RequestBody Category category){
        BaseResponse<Category> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        baseResponse.setData(categoryService.createNewCategory(category));
        return ResponseEntity.ok(baseResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        BaseResponse<Category> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Success");
        category.setId(id);
        baseResponse.setData(categoryService.updateCategory(category));
        return ResponseEntity.ok(baseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Success");
    }



}
