package com.example.example3.service.impl;

import java.util.List;

import com.example.example3.entity.Category;
import com.example.example3.repository.CategoryRespository;
import com.example.example3.service.CategoryService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRespository categoryRespository;

    @Override
    public Category createCategory(Category category) {
        return categoryRespository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRespository.findById(categoryId);
        return optionalCategory.get();
    }

    @Override
    public List<Category> getAllcategories() {
        return categoryRespository.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        Category existingCategory = categoryRespository.findById(category.getId()).get();
        existingCategory.setName(category.getName());
        Category updatedCategory = categoryRespository.save(existingCategory);
        return updatedCategory;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRespository.deleteById(categoryId);
    }
}
