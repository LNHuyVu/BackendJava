package com.example.example3.service;

import java.util.List;

import com.example.example3.entity.Category;

public interface CategoryService {

    public Category createCategory(Category category);

    public Category getCategoryById(Long categoryId);

    public List<Category> getAllcategories();

    public Category updateCategory(Category category);

    public void deleteCategory(Long categoryId);
}
