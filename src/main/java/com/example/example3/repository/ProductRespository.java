package com.example.example3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example3.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Long> {

}