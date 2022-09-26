package com.example.examserver.service.impl;

import com.example.examserver.models.Category;
import com.example.examserver.repo.CategoryRepo;
import com.example.examserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;
    
    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepo.findAll());
    }

    @Override
    public Category getCategory(Long cid) {
        return categoryRepo.findById(cid).get();
    }

    @Override
    public void deleteCategory(Long cid) {
        categoryRepo.deleteById(cid);
    }
}
