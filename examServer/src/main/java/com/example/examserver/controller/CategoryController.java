package com.example.examserver.controller;

import com.example.examserver.models.Category;
import com.example.examserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(service.addCategory(category));
    }

    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return service.getCategory(categoryId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(service.getCategories());
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return service.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        service.deleteCategory(categoryId);
    }
}
