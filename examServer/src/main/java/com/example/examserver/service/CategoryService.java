package com.example.examserver.service;

import com.example.examserver.models.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long cid);
    public void deleteCategory(Long cid);
}
