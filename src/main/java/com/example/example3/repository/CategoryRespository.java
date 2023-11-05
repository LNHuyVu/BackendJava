package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Category;

public interface CategoryRespository extends JpaRepository<Category, Long> {

}
